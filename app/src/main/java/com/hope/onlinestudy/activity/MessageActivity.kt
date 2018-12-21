package com.hope.onlinestudy.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.fragment.MessageFragment
import com.hope.onlinestudy.fragment.NotifiyFragment
import com.hope.onlinestudy.model.MsgNotifModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils
import kotlinx.android.synthetic.main.layout_tab_vfp.*
import kotlinx.android.synthetic.main.view_title.*

class MessageActivity : BaseActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.layout_tab_vfp
    }

    override fun initData() {
        tv_title.text = "我的消息"
        iv_backup.setOnClickListener(this)

        val itemFragments = ArrayList<Fragment>()
        itemFragments.add(MessageFragment())
        itemFragments.add(NotifiyFragment())

        val tabInndicat: Array<String> = resources.getStringArray(R.array.messagetitle)

        val homeAdapter = TabVpAdapter(supportFragmentManager)
        homeAdapter.fmTitle = tabInndicat
        homeAdapter.fmList = itemFragments
        vpfPage.adapter = homeAdapter

        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)
    }

}
