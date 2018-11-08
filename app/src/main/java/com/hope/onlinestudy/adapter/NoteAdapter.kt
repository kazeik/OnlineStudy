package com.hope.onlinestudy.adapter

import android.widget.TextView
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.EduNote
import com.hope.onlinestudy.utils.TimeUtil

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 08 11:03
 * 类说明:
 */
class NoteAdapter<A> : BaseAdapter<A>() {
    internal var itemEventListener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.adapter_layout_note
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val tvNoteBody = holder.getViewById<TextView>(R.id.tvNoteBody)
        val tvNoteClass = holder.getViewById<TextView>(R.id.tvNoteClass)
        val tvNoteLesson = holder.getViewById<TextView>(R.id.tvNoteLesson)
        val tvNoteTime = holder.getViewById<TextView>(R.id.tvNoteTime)
        val tvDeleteNote = holder.getViewById<TextView>(R.id.tvDeleteNote)

        val entity: EduNote = dataList?.get(position) as EduNote
        tvNoteLesson.text = "课程分类：${entity.courseChapterName}"
        tvNoteClass.text = "章节：${entity.courseName}"
        tvNoteBody.text = entity.noteInfo
        tvNoteTime.text = "时间：${TimeUtil.getDayByType(entity.createtime.time, TimeUtil.DATE_YMD_HMS)}"
        tvDeleteNote.setOnClickListener {
            if (null != itemEventListener)
                itemEventListener?.onItemEvent(position)
        }
    }
}