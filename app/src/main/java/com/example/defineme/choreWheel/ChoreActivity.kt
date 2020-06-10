package com.example.defineme.choreWheel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.Model
import com.example.defineme.R
import com.example.defineme.choreModel
import kotlinx.android.synthetic.main.activity_active.*

import kotlinx.android.synthetic.main.activity_chore.*
import kotlinx.android.synthetic.main.chorerow.*

class ChoreActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore)


        val arrayChoreList = ArrayList<choreModel>()
        arrayChoreList.add(choreModel("Laundry"))
        arrayChoreList.add(choreModel("Clean the dishes"))
        arrayChoreList.add(choreModel("Feed pet"))
        arrayChoreList.add(choreModel("Clean Fridge"))
        arrayChoreList.add(choreModel("Make Bed"))
        arrayChoreList.add(choreModel("Stock up more toilet paper"))
        arrayChoreList.add(choreModel("Take out the trash"))
        arrayChoreList.add(choreModel("Get grocery"))

        val myAdapter2 = recyclerViewAdapter(arrayChoreList, this)
        habitList2.layoutManager = LinearLayoutManager(this)
        habitList2.adapter = myAdapter2




    }
}



