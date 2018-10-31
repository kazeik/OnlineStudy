package com.hope.onlinestudy.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.fragment.MessageFragment
import com.hope.onlinestudy.fragment.NotifiyFragment
import kotlinx.android.synthetic.main.layout_tab_vfp.*
import kotlinx.android.synthetic.main.view_title.*

class MessageActivity : BaseActivity(), View.OnClickListener, TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.layout_tab_vfp
    }

    private val homeAdapter: TabVpAdapter by lazy { TabVpAdapter(supportFragmentManager) }
    private val tabInndicat: Array<String> by lazy { resources.getStringArray(R.array.messagetitle) }
    private val itemFragments: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }
    override fun initData() {
        tv_title.setText("我的消息")
        iv_backup.setOnClickListener(this)

        itemFragments.add(MessageFragment())
        itemFragments.add(NotifiyFragment())

        homeAdapter.fmTitle = tabInndicat
        homeAdapter.fmList = itemFragments
        vpfPage.adapter = homeAdapter

        tabPolling.addOnTabSelectedListener(this)
        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)
    }

}
