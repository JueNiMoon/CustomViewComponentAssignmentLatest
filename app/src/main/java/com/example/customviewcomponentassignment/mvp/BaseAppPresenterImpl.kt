package com.example.customviewcomponentassignment.mvp

import com.example.customviewcomponentassignment.mvp.presenter.AbstractBasePresenter
import com.example.customviewcomponentassignment.mvp.presenter.BasePresenter
import com.example.customviewcomponentassignment.mvp.views.BaseView

abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>