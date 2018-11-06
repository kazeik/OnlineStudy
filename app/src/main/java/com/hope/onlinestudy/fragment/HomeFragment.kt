package com.hope.onlinestudy.fragment


import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import com.hope.onlinestudy.iter.INetStrListener
import com.hope.onlinestudy.utils.ApiUtils
import kotlinx.android.synthetic.main.layout_tab_vfp.*
import kotlinx.android.synthetic.main.view_title.*


/**
 * A simple [Fragment] subclass.
 * 首页
 */
class HomeFragment : BaseFragment(), TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    private val homeAdapter: TabVpAdapter by lazy { TabVpAdapter(childFragmentManager) }
    private val tabInndicat: Array<String> by lazy { resources.getStringArray(R.array.lessonarray) }
    private val itemFragments: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }
    override fun initView(): Int {
        return R.layout.layout_tab_vfp
    }

    override fun bindData() {
        tv_title.setText("我的课程")
        iv_backup.visibility = View.GONE
        itemFragments.add(NewLessonFragment())
        itemFragments.add(HotLessonFragment())

        homeAdapter.fmTitle = tabInndicat
        homeAdapter.fmList = itemFragments
        vpfPage.adapter = homeAdapter

        tabPolling.addOnTabSelectedListener(this)
        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)

        activity?.showDialog()
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
    }
}
