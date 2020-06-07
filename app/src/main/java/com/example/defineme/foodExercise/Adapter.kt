package com.example.defineme.foodExercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.Model
import com.example.defineme.R
import kotlinx.android.synthetic.main.row.view.*

class Adapter(private var arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var checkerHabit = ArrayList<Model>()
        fun bindItems(model: Model) {
            itemView.listHabit.text = model.habit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(arrayList[position])
        //holder.checkbox.isChecked = habitChecker.isSelected
        //setOnClickListener
        holder.itemView.setOnClickListener{
                Toast.makeText(context, "Habit ${arrayList[position+1]}", Toast.LENGTH_SHORT).show()
            }
        }
}