package com.hope.onlinestudy.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.fragment.UserBuyFragment
import com.hope.onlinestudy.fragment.UserFavoritesFragment
import com.hope.onlinestudy.model.LessonListModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.layout_tab_vfp.*
import kotlinx.android.synthetic.main.view_title.*

/**
 * 我的课程
 */
class LessonActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.layout_tab_vfp
    }

    private val userBuyFragment: UserBuyFragment by lazy { UserBuyFragment() }
    private val addLessonFragment: UserFavoritesFragment by lazy { UserFavoritesFragment() }
    private val homeAdapter: TabVpAdapter by lazy { TabVpAdapter(supportFragmentManager) }
    private val tabInndicat: Array<String> by lazy { resources.getStringArray(R.array.lessonarray) }
    private val itemFragments: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }
    override fun initData() {
        tv_title.text = "我的课程"
        iv_backup.setOnClickListener(this)

        itemFragments.add(addLessonFragment)
        itemFragments.add(userBuyFragment)

        homeAdapter.fmTitle = tabInndicat
        homeAdapter.fmList = itemFragments
        vpfPage.adapter = homeAdapter

        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)

        showDialog()
        apiInter.sigleRequest(ApiUtils.toMyCourse)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyCourse -> {
                val model: LessonListModel = parserJson(body)
                addLessonFragment.showData(model.data?.get(0)?.userFavoritesList)
                userBuyFragment.showData(model.data?.get(0)?.userBoyList)
            }
        }
    }
}
