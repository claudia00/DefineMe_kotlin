package com.example.defineme.foodExercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defineme.Model
import com.example.defineme.R
import kotlinx.android.synthetic.main.activity_active.*

class ActiveActivity : AppCompatActivity(){
    //, AdapterView.OnItemClickListener {

//    private var listView: ListView? = null
//    private var arrayAdapter: ArrayAdapter<String> ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active)


        val arrayList = ArrayList<Model>()
        arrayList.add(Model("Push ups!"))
        arrayList.add(Model("Pull ups"))
        arrayList.add(Model("Crunch time"))
        arrayList.add(Model("Warm - Up"))
        arrayList.add(Model("Stretch thoses muscles"))
        arrayList.add(Model("Take a swim"))
        arrayList.add(Model("Don't forget to drink some water"))


        val myAdapter = Adapter(arrayList, this)
        habitLists.layoutManager = LinearLayoutManager(this)
        habitLists.adapter = myAdapter

    }
}

