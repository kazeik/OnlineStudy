package com.hope.onlinestudy.adapter

import android.widget.Button
import android.widget.TextView
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 27 14:25
 * 类说明:
 */
class ExamAdapter<A> : BaseAdapter<A>() {
    internal var itemEventListener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.adapter_examine
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val btnExamStr = holder.getViewById<Button>(R.id.btnStartExam)
        val tvLessonTitleStr = holder.getViewById<TextView>(R.id.tvLessonTitle)
        val tvStartTimeStr = holder.getViewById<TextView>(R.id.tvStartTime)
        val tvEndTimeStr = holder.getViewById<TextView>(R.id.tvEndTime)
        btnExamStr.setOnClickListener {
            if (null != itemEventListener)
                itemEventListener?.onItemEvent(position)
        }
    }
}