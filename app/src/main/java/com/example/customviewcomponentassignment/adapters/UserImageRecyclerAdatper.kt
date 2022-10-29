package com.example.customviewcomponentassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviewcomponentassignment.R
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import com.example.customviewcomponentassignment.views.viewholders.BaseImageViewHolder
import com.example.customviewcomponentassignment.views.viewholders.CreateUserImageViewHolder
import com.example.customviewcomponentassignment.views.viewholders.UserImageViewHolder

class UserImageRecyclerAdatper(private val mDelegate: PeopleListActionDelegate) :
    BaseRecyclerAdapter<BaseImageViewHolder>() {
    val VIEW_TYPE_IMAGE = 100
    val VIEW_TYPE_ADD = 101

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseImageViewHolder {
        return when (viewType) {
            VIEW_TYPE_ADD -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.add_user_item, parent, false)
                 CreateUserImageViewHolder(view, mDelegate)
            }
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_image_item, parent, false)
                 UserImageViewHolder(view, mDelegate)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.user_image_item, parent, false)
                return CreateUserImageViewHolder(view, mDelegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        when {
            position == 2-> {
                return VIEW_TYPE_ADD
            }
            else -> {
                return VIEW_TYPE_IMAGE
            }
        }
    }

}