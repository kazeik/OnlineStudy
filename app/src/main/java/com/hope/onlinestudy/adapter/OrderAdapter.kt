package com.hope.onlinestudy.adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.OrderModel
import com.hope.onlinestudy.utils.TimeUtil

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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val orderIcon = holder.getViewById<ImageView>(R.id.ivOrderIcon)
        val orderTypeStr = holder.getViewById<TextView>(R.id.tvOrderType)
        val orderTitleStr = holder.getViewById<TextView>(R.id.tvOrderTitle)
        val orderMoneyStr = holder.getViewById<TextView>(R.id.tvOrderMoney)
        val orderNumStr = holder.getViewById<TextView>(R.id.tvOrderNum)
        val orderTimeStr = holder.getViewById<TextView>(R.id.tvOrderTime)

        val entity: OrderModel = dataList?.get(position) as OrderModel

        orderNumStr.text = "订单号：${entity.orderId}"
        orderTimeStr.text = TimeUtil.getDayByType(entity.createtime.time, TimeUtil.DATE_YMD_HMS)
        orderTitleStr.text = entity.orderName
        orderMoneyStr.text = "￥${entity.orderMoney}"
        orderTypeStr.text = if (entity.orderState == 0) {
            "未支付"
        } else {
            "已支付"
        }
    }
}