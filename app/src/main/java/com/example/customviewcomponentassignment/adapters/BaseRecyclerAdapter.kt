package com.example.customviewcomponentassignment.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.customviewcomponentassignment.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder>
    : RecyclerView.Adapter<T>() {

   // var mData : MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return 3
        //return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
       // holder.bindData()
    }

//    fun setNewData(data : MutableList<W>){
//        mData = data
//        notifyDataSetChanged()
//    }
//
//    fun appendNewData(data : List<W>){
//        mData.addAll(data)
//        notifyDataSetChanged()
//    }
}