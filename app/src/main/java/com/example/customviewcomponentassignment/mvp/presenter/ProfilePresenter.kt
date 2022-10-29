package com.example.customviewcomponentassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewcomponentassignment.delegates.ActionBarDelegate
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import com.example.customviewcomponentassignment.mvp.views.ProfileView
import com.example.customviewcomponentassignment.viewpod.ActionBarViewPod

interface ProfilePresenter : BasePresenter<ProfileView>, PeopleListActionDelegate,ActionBarViewPod.Delegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}