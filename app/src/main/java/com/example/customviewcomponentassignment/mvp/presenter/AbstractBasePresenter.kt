package com.example.customviewcomponentassignment.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.customviewcomponentassignment.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}