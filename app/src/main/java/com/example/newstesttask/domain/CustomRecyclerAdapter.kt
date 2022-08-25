package com.example.newstesttask.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newstesttask.R
import com.example.newstesttask.domain.models.ArticleDomain
import com.example.newstesttask.repository.models.Article
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(private val articles: List<ArticleDomain>?) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    private val picasso = Picasso.get()

    override fun toString(): String {
        return articles.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        articles?.let {
            holder.textViewTitle.text = articles[position].title

            val maxDescriptionLength = 100
            val description = articles[position].description

            if (!description.isNullOrEmpty()) {
                holder.textViewDescription.text =
                    if (description.length >= maxDescriptionLength) description.substring(0,
                        maxDescriptionLength).plus("...")
                    else description
            }
            picasso.load(articles[position].urlToImage).into(holder.imageView)
        }


    }

    override fun getItemCount() = articles?.size ?: 0

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textView_title)
        val textViewDescription: TextView = itemView.findViewById(R.id.textView_description)
        val imageView: ShapeableImageView = itemView.findViewById(R.id.imageView)
    }
}