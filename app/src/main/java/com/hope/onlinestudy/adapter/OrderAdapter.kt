package com.hope.onlinestudy.adapter

import android.widget.ImageView
import android.widget.TextView
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 26 21:59
 * 类说明:
 */
class OrderAdapter<A> : BaseAdapter<A>() {
    override fun getLayoutView(): Int {
        return R.layout.adapter_order_view
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val orderIcon = holder.getViewById<ImageView>(R.id.ivOrderIcon)
        val orderTypeStr = holder.getViewById<TextView>(R.id.tvOrderType)
        val orderTitleStr = holder.getViewById<TextView>(R.id.tvOrderTitle)
        val orderMoneyStr = holder.getViewById<TextView>(R.id.tvOrderMoney)
        val orderNumStr = holder.getViewById<TextView>(R.id.tvOrderNum)
        val orderTimeStr = holder.getViewById<TextView>(R.id.tvOrderTime)
    }
}