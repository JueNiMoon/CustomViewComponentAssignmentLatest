package com.example.customviewcomponentassignment.viewpod

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.action_bar_view_pod.view.*

class ActionBarViewPod  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun bindData( title : String , isMainScreen : Boolean) {
        txtOMPDashboard.text = title
        if(!isMainScreen){
            btnInProgress.visibility = View.GONE
        }
    }

    private fun setUpListener() {
        iv_back.setOnClickListener {
            mDelegate?.onTapback()
        }

        btnInProgress.setOnClickListener {
            mDelegate?.onTabInProgressBtn()
        }
    }

    interface Delegate {
        fun onTapback()
        fun onTabInProgressBtn()
    }
}