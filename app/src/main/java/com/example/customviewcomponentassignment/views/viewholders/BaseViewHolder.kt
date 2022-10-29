package com.example.customviewcomponentassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {


    abstract fun bindData()
}