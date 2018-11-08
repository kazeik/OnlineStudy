package com.hope.onlinestudy.adapter

import android.widget.TextView
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.PointModel

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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val info = holder.getViewById<TextView>(R.id.tvInfo)
        val info1 = holder.getViewById<TextView>(R.id.tvInfo1)
        val info2 = holder.getViewById<TextView>(R.id.tvInfo2)
        val entity = dataList?.get(position) as PointModel

        info.text = entity.allIntegralRules[0].integralRulesName
        info1.text = "${entity.allIntegralRules[0].integralRulesMaximum}"
        info2.text = entity.allIntegralRules[0].integralRulesRemark
    }
}