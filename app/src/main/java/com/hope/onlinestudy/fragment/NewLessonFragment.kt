package com.hope.onlinestudy.fragment

import android.support.v7.widget.GridLayoutManager
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.LessonAdapter
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.model.LessonModel
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 26 20:34
 * 类说明:
 */
class NewLessonFragment : BaseFragment(),OnItemEventListener {
    override fun onItemEvent(pos: Int) {
    }

    private val lessonAdapter:LessonAdapter<LessonModel> by lazy { LessonAdapter<LessonModel>() }
    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.layoutManager = GridLayoutManager(activity,2)
        rcvList.adapter = lessonAdapter
        lessonAdapter.itemListener = this
    }
}