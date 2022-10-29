package com.example.customviewcomponentassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviewcomponentassignment.R
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import com.example.customviewcomponentassignment.views.viewholders.UserViewHolder

class UserRecyclerAdatper(private val mDelegate : PeopleListActionDelegate)
    : BaseRecyclerAdapter<UserViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): UserViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
            return UserViewHolder(view, mDelegate)
        }
}