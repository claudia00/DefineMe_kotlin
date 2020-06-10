package com.example.defineme.workPersonal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.Model
import com.example.defineme.R
import com.example.defineme.workModel
import kotlinx.android.synthetic.main.activity_active.*
import kotlinx.android.synthetic.main.activity_work.*
import kotlinx.android.synthetic.main.row.view.*

class WorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)


        val workArray = ArrayList<workModel>()
        workArray.add(workModel("Check Emails"))
        workArray.add(workModel("Pay the bills"))
        workArray.add(workModel("Do Assignment"))
        workArray.add(workModel("Buy a present"))
        workArray.add(workModel("Recieve Package"))
        workArray.add(workModel("Email Back"))
        workArray.add(workModel("Review Assignment"))


        val myAdapter3 = workAdapter(workArray, this)
        HabitList3.layoutManager = LinearLayoutManager(this)
        HabitList3.adapter = myAdapter3

    }
}