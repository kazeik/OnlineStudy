package com.hope.onlinestudy.adapter

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 26 21:41
 * 类说明:
 */
class HomeWorkAdapter<A> : BaseAdapter<A>() {
    internal var listener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.adapter_homework
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val lessonIcon = holder.getViewById<ImageView>(R.id.ivWorkIcon)
        val lessonTitleStr = holder.getViewById<TextView>(R.id.tvLessonTitle)
        val startTimeStr = holder.getViewById<TextView>(R.id.tvStartTime)
        val endTimeStr = holder.getViewById<TextView>(R.id.tvEndTime)
        val check = holder.getViewById<Button>(R.id.btnCheck)
        check.setOnClickListener {
            if (null != listener)
                listener?.onItemEvent(position)
        }
    }
}