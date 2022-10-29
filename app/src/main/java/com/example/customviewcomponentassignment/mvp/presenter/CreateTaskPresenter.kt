package com.example.customviewcomponentassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import com.example.customviewcomponentassignment.viewpod.ActionBarViewPod

interface CreateTaskPresenter : PeopleListActionDelegate, ActionBarViewPod.Delegate  {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}