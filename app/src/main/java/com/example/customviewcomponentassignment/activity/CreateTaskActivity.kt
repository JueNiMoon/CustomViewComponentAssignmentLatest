package com.example.customviewcomponentassignment.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewcomponentassignment.R
import com.example.customviewcomponentassignment.adapters.UserImageRecyclerAdatper
import com.example.customviewcomponentassignment.mvp.presenter.CreateTaskPresenter
import com.example.customviewcomponentassignment.mvp.presenter.CreateTaskPresenterImpl
import com.example.customviewcomponentassignment.mvp.views.CreateTaskView
import com.example.customviewcomponentassignment.viewpod.ActionBarViewPod
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_create_task.actionBarViewPod
import kotlinx.android.synthetic.main.profile_group_layout.view.*

class CreateTaskActivity: BaseActivity(), CreateTaskView {

    private lateinit var mPresenter: CreateTaskPresenter
    private lateinit var mimageAdapter: UserImageRecyclerAdatper
    private lateinit var mActionBar: ActionBarViewPod

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateTaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        setUpPresenter()
        setUpUI()
        setUpViewPod()
        mPresenter.onUiReady(this)

    }

    private fun setUpViewPod() {
        mActionBar = actionBarViewPod as ActionBarViewPod
        mActionBar.bindData("A Create New Task ",false)
        mActionBar.setDelegate(mPresenter)
    }

    private fun setUpPresenter() {
        mPresenter =  ViewModelProvider(this).get(CreateTaskPresenterImpl::class.java)
        (mPresenter as CreateTaskPresenterImpl).initPresenter(this)
    }

    private fun setUpUI() {
        rv_createtask.circularprogressbar.visibility = View.GONE
        mimageAdapter = UserImageRecyclerAdatper(mPresenter)
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_createtask.rv_createuser.layoutManager = mlinearLayoutManager
        rv_createtask.rv_createuser.adapter = mimageAdapter

    }

    override fun navigateToProfileScreen() {
        startActivity(ProfileActivity.newIntent(this))
    }

    override fun navigateToCreateTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }

    override fun navigateBack() {
        super.onBackPressed()
    }
}