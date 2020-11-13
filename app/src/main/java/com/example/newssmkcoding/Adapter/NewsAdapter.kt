package com.example.newssmkcoding.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newssmkcoding.DetailActivity
import com.example.newssmkcoding.Model.MNews
import com.example.newssmkcoding.R
import com.example.newssmkcoding.Utils.Constans.IMAGE_URL
import java.util.ArrayList

class NewsAdapter(var mContext: Context, var mData: ArrayList<MNews>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTitle = v.findViewById<TextView>(R.id.tvTitle)
        var mDescription = v.findViewById<TextView>(R.id.tvDeskripsi)
        var mImageUrl = v.findViewById<ImageView>(R.id.imgItem)
        var mPublishedAt = v.findViewById<TextView>(R.id.tvPublishedAt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mData[position]
        holder.mTitle.text = data.title
        holder.mDescription.text = data.description

        holder.itemView.setOnClickListener(){
            val detail = Intent(mContext, DetailActivity::class.java)
                .putExtra("title", data.title)
                .putExtra("description", data.description)
                .putExtra("publishedAt", data.publishedAt)
                .putExtra("imgItem", data.imageUrl )
            (mContext as Activity).startActivity(detail)
            (mContext as Activity).finish()
        }

        Glide.with(mContext)
            .load(IMAGE_URL + data.imageUrl)
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .into(holder.mImageUrl)
    }

    override fun getItemCount(): Int = mData.size

}