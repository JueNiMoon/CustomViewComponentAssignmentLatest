package com.example.customviewcomponentassignment.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewcomponentassignment.R
import com.example.customviewcomponentassignment.adapters.UserRecyclerAdatper
import com.example.customviewcomponentassignment.mvp.presenter.ProfilePresenter
import com.example.customviewcomponentassignment.mvp.presenter.ProfilePresenterImpl
import com.example.customviewcomponentassignment.mvp.views.ProfileView
import com.example.customviewcomponentassignment.viewpod.ActionBarViewPod
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity: BaseActivity(), ProfileView {

    private lateinit var mPresenter: ProfilePresenter
    private lateinit var muserAdapter: UserRecyclerAdatper
    private lateinit var mActionBar: ActionBarViewPod
    val titleList = arrayListOf("Project Tasks", "Contacts","About You")

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUpPresenter()
        setUpUI()
        setUpListener()
        setUpViewPod()
    }

    private fun setUpViewPod() {
        mActionBar = actionBarViewPod as ActionBarViewPod
        mActionBar.bindData("Profile",false)
        mActionBar.setDelegate(mPresenter)
    }

    private fun setUpUI() {

        // tab layout

        titleList.forEach{
            tab_tasks.newTab().apply {
                text = it
                tab_tasks.addTab(this)
            }
        }

        // user list
        muserAdapter = UserRecyclerAdatper(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_user_list.layoutManager = linearLayoutManager
        rv_user_list.adapter = muserAdapter

    }

    private fun setUpListener(){

        //tab layout
        tab_tasks.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

               var tab_position = tab?.position
                tab_position?.let {
                    showSnackBarMessage(titleList[tab_position].toString())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        // Share button
        iv_share.setOnClickListener {
            showSnackBarMessage("Share Button")
        }

        //Message Button
        btn_message.setOnClickListener {
            showSnackBarMessage("Message Button")
        }

        //chart button
        iv_chart.setOnClickListener {
            showSnackBarMessage("Chart Button")
        }
    }

    private fun showSnackBarMessage(message : String){
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }


    private fun setUpPresenter() {
        mPresenter =  ViewModelProvider(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun navigateToProfileScreen() {
        showSnackBarMessage("Profile Screen")
    }

    override fun navigateBack() {
        super.onBackPressed()
    }
}