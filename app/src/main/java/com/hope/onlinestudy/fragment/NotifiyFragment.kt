package com.hope.onlinestudy.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.MessageAdapter
import com.hope.onlinestudy.base.LazyFragment
import com.hope.onlinestudy.model.MessageModel
import com.hope.onlinestudy.model.MsgNotifModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 31 14:41
 * 类说明:
 */
class NotifiyFragment : LazyFragment() {
    override fun lazyLoad() {
    }

    private val adapter: MessageAdapter<MessageModel> by lazy { MessageAdapter<MessageModel>() }

    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.layoutManager = LinearLayoutManager(activity)
        rcvList.adapter = adapter

//        activity?.showDialog()
        apiInter.getmessage("notice", 1, ApiUtils.toMyMsg)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyMsg -> {
                val model = Utils.parserJson<MsgNotifModel>(body)
                adapter.setDataEntityList(model.data?.get(0)?.notice!!)
            }
        }
    }
}