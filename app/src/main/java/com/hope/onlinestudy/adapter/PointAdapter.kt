package com.hope.onlinestudy.adapter

import android.annotation.SuppressLint
import android.util.TimeUtils
import android.widget.TextView
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.PointModel
import com.hope.onlinestudy.utils.TimeUtil

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 08 11:43
 * 类说明:
 */
class PointAdapter<A> : BaseAdapter<A>() {
    override fun getLayoutView(): Int {
        return R.layout.layout_adapter_point
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val info = holder.getViewById<TextView>(R.id.tvInfo)
        val info1 = holder.getViewById<TextView>(R.id.tvInfo1)
        val info2 = holder.getViewById<TextView>(R.id.tvInfo2)
        val entity = dataList?.get(position) as PointModel

        info.text = TimeUtil.getDayByType(entity.creationtime, TimeUtil.DATE_YMD_HMS)
        info1.text = "${if (entity.integralIaeState == 0) "+" else "-"}${entity.integralIae}"
        info2.text = if (entity.integralType == 0) "购物积分" else "消费积分"
    }
}