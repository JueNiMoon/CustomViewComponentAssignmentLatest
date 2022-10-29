package com.example.customviewcomponentassignment.views.viewholders

import android.view.View
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate

class CreateUserImageViewHolder(itemView: View, private val mDelegate: PeopleListActionDelegate) :
    BaseImageViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTapAddBtn()
        }
    }

    override fun bindData() {

    }

//    override fun bindData(data: UserVO) {
//        mData = data
//        // itemView.addbtn.setImageResource(data.imageurl)
//    }
}