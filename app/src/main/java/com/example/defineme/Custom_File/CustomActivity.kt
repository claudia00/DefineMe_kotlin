package com.example.defineme.Custom_File

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_new_habit.*

class CustomActivity : AppCompatActivity() {
    private val newHabitActivityRequestCode = 1
    private lateinit var customHabitViewModel: CustomHabitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = habitCustomAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        customHabitViewModel = ViewModelProvider(this).get(CustomHabitViewModel::class.java)
        customHabitViewModel.allHabits.observe(this, Observer { customHabits ->
            customHabits?.let{ adapter.setNewHabits(it)}
        })
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@CustomActivity, NewHabitActivity::class.java)
            startActivityForResult(intent, newHabitActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == newHabitActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.getStringExtra(NewHabitActivity.EXTRA_REPLY)?.let{
                val customHabit = custom(it)
                customHabitViewModel.insert(customHabit)
            }
        }else{
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }

}