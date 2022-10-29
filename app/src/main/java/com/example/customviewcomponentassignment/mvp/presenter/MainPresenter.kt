package com.example.customviewcomponentassignment.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.customviewcomponentassignment.delegates.PeopleListActionDelegate
import com.example.customviewcomponentassignment.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, PeopleListActionDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}