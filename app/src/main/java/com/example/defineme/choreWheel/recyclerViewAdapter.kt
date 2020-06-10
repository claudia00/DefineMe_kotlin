package com.example.defineme.choreWheel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.Model
import com.example.defineme.R
import com.example.defineme.choreModel
import kotlinx.android.synthetic.main.chorerow.view.*
import kotlinx.android.synthetic.main.row.view.*

class recyclerViewAdapter(private var choreHabitList: ArrayList<choreModel>, val context: Context):
RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(choreModel: choreModel) {
            itemView.listHabit2.text = choreModel.choreHabitList
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chorerow, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return choreHabitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(choreHabitList[position])
        //holder.checkbox.isChecked = habitChecker.isSelected
        //setOnClickListener

//        holder.itemView.setOnClickListener{
//            Toast.makeText(context, "Habit ${choreHabitList", Toast.LENGTH_SHORT).show()
//        }

}
}