package com.hope.onlinestudy.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.ExamAdapter
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.model.ExamModel
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 27 14:23
 * 类说明:
 */
class ExamDoneFragment : BaseFragment() ,OnItemEventListener{
    override fun onItemEvent(pos: Int) {
    }

    private val examAdapter:ExamAdapter<ExamModel> by lazy { ExamAdapter<ExamModel>() }
    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.adapter = examAdapter
        rcvList.layoutManager = LinearLayoutManager(activity)
        examAdapter.itemEventListener =this
    }
}