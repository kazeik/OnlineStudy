package com.hope.onlinestudy.fragment


import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.hope.onlinestudy.base.BaseFragment

import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.TabVpAdapter
import kotlinx.android.synthetic.main.layout_tab_vfp.*
import kotlinx.android.synthetic.main.view_title.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ExamineFragment : BaseFragment(), TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    private val examAdapter: TabVpAdapter by lazy { TabVpAdapter(childFragmentManager) }
    private val tabInndicat: Array<String> by lazy { resources.getStringArray(R.array.examarray) }
    private val itemFragments: ArrayList<Fragment> by lazy { ArrayList<Fragment>() }
    override fun initView(): Int {
        return R.layout.layout_tab_vfp
    }

    override fun bindData() {
        tv_title.setText("我的考试")
        itemFragments.add(ExamingFragment())
        itemFragments.add(ExamStartingFragment())
        itemFragments.add(ExamDoneFragment())

        examAdapter.fmTitle = tabInndicat
        examAdapter.fmList = itemFragments
        vpfPage.adapter = examAdapter

        tabPolling.addOnTabSelectedListener(this)
        for (item in tabInndicat) {
            tabPolling.addTab(tabPolling.newTab().setText(item))
        }
        tabPolling.tabMode = TabLayout.MODE_FIXED
        tabPolling.setupWithViewPager(vpfPage)
    }
//    new CommomDialog(mContext, R.style.dialog, "您确定删除此信息？", new CommomDialog.OnCloseListener() {
//        @Override
//        public void onClick(boolean confirm) {
//            if(confirm){
//                Toast.makeText(this,"点击确定", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//
//        }
//    })
//    .setTitle("提示").show();
}
