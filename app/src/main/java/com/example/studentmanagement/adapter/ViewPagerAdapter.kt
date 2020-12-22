package com.example.studentmanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.studentmanagement.R

class ViewPagerAdapter(context: Context, list:ArrayList<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    private val mList = list
    private val mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.activity_guide_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(mContext).load(mList[position]).into(holder.imgGuide)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgGuide: ImageView = itemView.findViewById(R.id.imgGuide)
    }

}