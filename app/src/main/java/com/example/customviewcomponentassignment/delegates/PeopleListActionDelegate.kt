package com.example.customviewcomponentassignment.delegates

import android.widget.ImageView

interface PeopleListActionDelegate {
    fun onTap(profileImage: ImageView)
    fun onTapAddBtn()
}