package com.example.defineme.workPersonal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.defineme.R
import com.example.defineme.workModel
import kotlinx.android.synthetic.main.workrow.view.*

class workAdapter(private var workList: ArrayList<workModel>, val context: Context):
    RecyclerView.Adapter<com.example.defineme.workPersonal.workAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(workModel: workModel) {
            itemView.listHabit3.text = workModel.workHabit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): workAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.workrow, parent, false)
            return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    override fun onBindViewHolder(holder: workAdapter.ViewHolder, position: Int) {
        holder.bindItems(workList[position])
    }


}

