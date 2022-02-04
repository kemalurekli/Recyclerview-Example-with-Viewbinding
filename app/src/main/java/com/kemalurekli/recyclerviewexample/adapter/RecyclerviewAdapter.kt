package com.kemalurekli.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kemalurekli.recyclerviewexample.databinding.RowLayoutBinding
import com.kemalurekli.recyclerviewexample.model.ContentModel

class RecyclerviewAdapter (val contentList : ArrayList<ContentModel>)
    : RecyclerView.Adapter<RecyclerviewAdapter.RowLayoutDesign>() {
    class RowLayoutDesign(val rowLayoutBinding: RowLayoutBinding)
        :RecyclerView.ViewHolder(rowLayoutBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowLayoutDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowLayoutBinding = RowLayoutBinding.inflate(layoutInflater,parent,false)
        return RowLayoutDesign(rowLayoutBinding)
    }

    override fun onBindViewHolder(holder: RowLayoutDesign, position: Int) {
        val content = contentList[position]
        holder.rowLayoutBinding.tvId.text = content.firstContent
        holder.rowLayoutBinding.tvContent.text = content.secondContent

    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    fun updateContentList(newContentList: List<ContentModel>) {
        contentList.clear()
        contentList.addAll(newContentList)
        notifyDataSetChanged()
    }
}