package com.hope.onlinestudy.adapter

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 27 13:46
 * 类说明:
 */
class LessonAdapter<A> : BaseAdapter<A>() {
    internal var itemListener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.layout_home_grid
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val lessonIcon = holder.getViewById<ImageView>(R.id.ivLessonIcon)
        val lessonTitleStr = holder.getViewById<TextView>(R.id.tvLessonName)
        val lessonPlyaer = holder.getViewById<TextView>(R.id.tvPlayer)
        val lessonPrivate = holder.getViewById<TextView>(R.id.tvPrivate)
        val lessionItem = holder.getViewById<LinearLayout>(R.id.llLesson)

        lessionItem.setOnClickListener {
            if (null != itemListener) {
                itemListener?.onItemEvent(position)
            }
        }
    }
}