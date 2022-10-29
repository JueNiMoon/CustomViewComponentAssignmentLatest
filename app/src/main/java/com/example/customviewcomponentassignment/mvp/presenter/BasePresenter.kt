package com.example.customviewcomponentassignment.mvp.presenter

import com.example.customviewcomponentassignment.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}