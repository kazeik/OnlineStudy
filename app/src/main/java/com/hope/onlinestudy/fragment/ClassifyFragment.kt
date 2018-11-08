package com.hope.onlinestudy.fragment


import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.model.MenuModel
import kotlinx.android.synthetic.main.view_title.*


class ClassifyFragment : BaseFragment() {
    override fun initView(): Int {
        return R.layout.fragment_classify
    }

    override fun bindData() {
        tv_title.setText("课程分类")
        iv_backup.visibility = View.GONE
    }

    fun setTypeData(menuList: List<MenuModel>) {

    }

}
