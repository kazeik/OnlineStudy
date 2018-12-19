package com.hope.onlinestudy.fragment


import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.ClassifyAdapter
import com.hope.onlinestudy.base.LazyFragment
import com.hope.onlinestudy.model.MenuModel
import kotlinx.android.synthetic.main.fragment_classify.*
import kotlinx.android.synthetic.main.view_title.*


class ClassifyFragment : LazyFragment() {
    private var menuListData: List<MenuModel>? = null
    override fun lazyLoad() {
        adapter.setData(menuListData!!)
    }


    private val adapter: ClassifyAdapter by lazy { ClassifyAdapter() }
    override fun initView(): Int {
        return R.layout.fragment_classify
    }

    override fun bindData() {
        tv_title.setText("课程分类")
        iv_backup.visibility = View.GONE

        elvExpand.setAdapter(adapter)
//        adapter.setData(menuListData!!)

    }

    fun setTypeData(menuList: List<MenuModel>) {
        this.menuListData = menuList
        adapter.setData(menuList)
    }

}
