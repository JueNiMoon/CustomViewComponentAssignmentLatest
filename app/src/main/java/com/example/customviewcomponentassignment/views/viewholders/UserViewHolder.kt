package com.example.customviewcomponentassignment.views.viewholders

import android.view.View
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import kotlinx.android.synthetic.main.user_image_item.view.*
import kotlinx.android.synthetic.main.user_item.view.*

class UserViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate): BaseViewHolder(itemView)
    {
        init {
            itemView.setOnClickListener {
                    mDelegate.onTap(itemView.imageitem)
            }
        }

        override fun bindData() {

        }
}