package com.hope.onlinestudy.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.MessageAdapter
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.model.MessageModel
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 31 14:41
 * 类说明:
 */
class NotifiyFragment : BaseFragment() {

    private val adapter: MessageAdapter<MessageModel> by lazy { MessageAdapter<MessageModel>() }

    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.layoutManager = LinearLayoutManager(activity)
        rcvList.adapter = adapter
    }

    fun setData(data: List<MessageModel>) {
        adapter.setDataEntityList(data)
    }
}