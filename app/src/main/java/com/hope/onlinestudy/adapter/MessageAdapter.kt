package com.hope.onlinestudy.adapter

import android.widget.TextView
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.MessageModel

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 06 11:22
 * 类说明:
 */
class MessageAdapter<A> : BaseAdapter<A>() {
    override fun getLayoutView(): Int {
        return R.layout.layout_message
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val entity = dataList?.get(position) as MessageModel

        val tvTitle = holder.getViewById<TextView>(R.id.tvMsgTitle)
        val tvTime = holder.getViewById<TextView>(R.id.tvMsgTime)

        tvTitle.setText(entity.messageInfo)
        tvTime.setText(entity.createtime)
    }
}