package com.example.newstesttask.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newstesttask.R
import com.example.newstesttask.repository.models.Article

class CustomRecyclerAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    override fun toString(): String {
        return articles.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewTitle.text = articles[position].description
    }

    override fun getItemCount() = articles.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textView_title)
    }
}