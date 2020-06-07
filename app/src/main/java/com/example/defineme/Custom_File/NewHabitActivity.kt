package com.example.defineme.Custom_File

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.defineme.R
import kotlinx.android.synthetic.main.activity_new_habit.*

private lateinit var editHabitView: EditText

class NewHabitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_habit)
        editHabitView = findViewById(R.id.newHabit)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
                if(TextUtils.isEmpty(editHabitView.text)){
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                }
            else{
                    val newCustomHabit = editHabitView.text.toString()
                    replyIntent.putExtra(EXTRA_REPLY, newCustomHabit)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
            finish()
        }
    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.DefineMe.REPLY"
    }
}