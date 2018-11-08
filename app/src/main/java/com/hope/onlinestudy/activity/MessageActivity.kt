package com.hope.onlinestudy.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.fragment.MessageFragment
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

    private val msgFragment: MessageFragment by lazy { MessageFragment() }
    private val noticFragment: MessageFragment by lazy { MessageFragment() }
    private val homeAdapter: TabVpAdapter by lazy { TabVpAdapter(supportFragmentManager) }
    private val tabInndicat: Array<String> by lazy { resources.getStringArray(R.array.messagetitle) }
    private val itemFragments: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }
    override fun initData() {
        tv_title.setText("我的消息")
        iv_backup.setOnClickListener(this)

        itemFragments.add(msgFragment)
        itemFragments.add(noticFragment)

        homeAdapter.fmTitle = tabInndicat
        homeAdapter.fmList = itemFragments
        vpfPage.adapter = homeAdapter

        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)

        showDialog()
        apiInter.sigleRequest(ApiUtils.toMyMsg)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyMsg -> {
                val model: MsgNotifModel? = Utils.parserJson(body)
                noticFragment.setData(model?.data?.get(0)?.notice!!)
                msgFragment.setData(model.data?.get(0)?.message!!)
            }
        }
    }
}
