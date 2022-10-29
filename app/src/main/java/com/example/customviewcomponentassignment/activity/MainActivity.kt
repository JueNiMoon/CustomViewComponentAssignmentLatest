package com.example.customviewcomponentassignment.activity


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewcomponentassignment.R
import com.example.customviewcomponentassignment.adapters.UserImageRecyclerAdatper
import com.example.customviewcomponentassignment.adapters.UserRecyclerAdatper
import com.example.customviewcomponentassignment.mvp.presenter.MainPresenter
import com.example.customviewcomponentassignment.mvp.presenter.MainPresenterImpl
import com.example.customviewcomponentassignment.mvp.views.MainView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.profile_group_layout.*
import kotlinx.android.synthetic.main.profile_group_layout.view.*

class MainActivity : BaseActivity(), MainView {
    private lateinit var muserAdapter: UserRecyclerAdatper
    private lateinit var mPresenter: MainPresenter
    private lateinit var muserimageAdapter: UserImageRecyclerAdatper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpUI()
        mPresenter.onUiReady(this)
    }
    private fun setUpPresenter() {
        mPresenter =  ViewModelProvider(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpUI() {

        circularprogressbar.setProgressColor(getResources().getColor(R.color.color_primary));
        circularprogressbar.setProgressWidth(10.toFloat())
        circularprogressbar.setProgress(85)

        muserAdapter = UserRecyclerAdatper(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_user.layoutManager = linearLayoutManager
        rv_user.adapter = muserAdapter

        muserimageAdapter = UserImageRecyclerAdatper(mPresenter)
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        iv_recycler.rv_createuser.layoutManager = mlinearLayoutManager
        iv_recycler.rv_createuser.adapter = muserimageAdapter

    }

    override fun navigateToProfileScreen() {
        startActivity(ProfileActivity.newIntent(this))
    }

    override fun navigateToCreateTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }
}