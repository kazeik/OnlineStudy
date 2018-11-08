package com.hope.onlinestudy.fragment

import android.support.v7.widget.GridLayoutManager
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.BuyLessonAdapter
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.model.UserBoy
import kotlinx.android.synthetic.main.layout_recyclerview.*


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 26 20:34
 * 类说明:
 */
class UserBuyFragment : BaseFragment(),OnItemEventListener {
    override fun onItemEvent(pos: Int) {
    }

    private val lessonAdapter:BuyLessonAdapter<UserBoy> by lazy { BuyLessonAdapter<UserBoy>(activity!!) }
    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.layoutManager = GridLayoutManager(activity,2)
        rcvList.adapter = lessonAdapter
        lessonAdapter.itemListener = this
    }

    fun showData(data:List<UserBoy>?){
        lessonAdapter.setDataEntityList(data!!)
    }
}