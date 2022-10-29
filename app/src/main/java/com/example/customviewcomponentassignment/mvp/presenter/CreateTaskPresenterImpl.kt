package com.example.customviewcomponentassignment.mvp.presenter


import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.example.customviewcomponentassignment.mvp.BaseAppPresenterImpl
import com.example.customviewcomponentassignment.mvp.views.CreateTaskView


class CreateTaskPresenterImpl  : CreateTaskPresenter, BaseAppPresenterImpl<CreateTaskView>()  {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        // mView?.displayPeopleList()
    }

    override fun onTap(profileImage: ImageView) {
        mView?.navigateToProfileScreen()
    }

    override fun onTapAddBtn() {
        mView?.navigateToCreateTask()
    }

    override fun onTapback() {
        mView?.navigateBack()
    }

    override fun onTabInProgressBtn() {
    }

}