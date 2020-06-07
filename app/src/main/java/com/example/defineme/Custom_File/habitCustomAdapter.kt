package com.example.defineme.Custom_File

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.R

class habitCustomAdapter internal constructor(
    context: Context
):RecyclerView.Adapter<habitCustomAdapter.CustomHabitViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var customHabits = emptyList<custom>()

    inner class CustomHabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val habitCustomItemView : TextView = itemView.findViewById(R.id.habitCustom)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): habitCustomAdapter.CustomHabitViewHolder {
        val habitCustomItemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return CustomHabitViewHolder(habitCustomItemView)
    }
    override fun onBindViewHolder(holder: CustomHabitViewHolder, position: Int){
        val current = customHabits [position]
        holder.habitCustomItemView.text = current.customHabit
    }
    internal fun setNewHabits(customHabits: List<custom>){
        this.customHabits = customHabits
        notifyDataSetChanged()
    }

    override fun getItemCount() = customHabits.size

}