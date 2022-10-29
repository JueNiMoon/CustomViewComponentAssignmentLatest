package com.example.customviewcomponentassignment.views.viewholders

import android.view.View
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import kotlinx.android.synthetic.main.user_image_item.view.*

class UserImageViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate) :
    BaseImageViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            //mDelegate.onTap(itemView.roundedCornerImageView)
            mDelegate.onTap(itemView.roundedCornerImageView)
        }
    }

    override fun bindData() {

    }

//    override fun bindData(data: UserVO) {
//        mData = data
//        itemView.roundedCornerImageView.setImageResource(data.imageurl)
//    }
}