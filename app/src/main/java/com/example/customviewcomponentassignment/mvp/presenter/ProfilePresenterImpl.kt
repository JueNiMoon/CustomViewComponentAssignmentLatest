package com.example.customviewcomponentassignment.mvp.presenter

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.example.customviewcomponentassignment.mvp.BaseAppPresenterImpl
import com.example.customviewcomponentassignment.mvp.views.ProfileView

class ProfilePresenterImpl : ProfilePresenter, BaseAppPresenterImpl<ProfileView>()  {

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

    }

    override fun onTap(profileImage: ImageView) {
        mView?.navigateToProfileScreen()
    }

    override fun onTapAddBtn() {
    }

    override fun onTapback() {
        mView?.navigateBack()
    }

    override fun onTabInProgressBtn() {

    }
}