package com.hope.onlinestudy.fragment

import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.utils.ApiUtils


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 31 14:41
 * 类说明:
 */
class MessageFragment : BaseFragment() {
    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        apiInter?.getmessage("message", 1, ApiUtils.getmessage, this)
    }

    override fun getNetStr(tag: String, body: String?) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.getmessage -> {
            }
        }
    }
}