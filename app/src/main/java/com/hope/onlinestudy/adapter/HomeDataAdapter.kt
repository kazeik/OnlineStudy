package com.hope.onlinestudy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseAdapter
import com.hope.onlinestudy.base.BaseViewHolder
import com.hope.onlinestudy.model.LessonItemModel
import com.hope.onlinestudy.utils.ApiUtils


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 08 15:49
 * 类说明:
 */
class HomeDataAdapter<A>(private val context: Context) : BaseAdapter<A>() {
    internal var itemEventListener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.layout_home_grid
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val tvLessonName = holder.getViewById<TextView>(R.id.tvLessonName)
        val tvPlayer = holder.getViewById<TextView>(R.id.tvPlayer)
        val tvPrivate = holder.getViewById<TextView>(R.id.tvPrivate)
        val ivLessonIcon = holder.getViewById<ImageView>(R.id.ivLessonIcon)
        val llLesson = holder.getViewById<LinearLayout>(R.id.llLesson)

        val entity = dataList?.get(position) as LessonItemModel
        Glide.with(context).load("${ApiUtils.imgUrl}${entity.courseImage}").into(ivLessonIcon)
        tvLessonName.text = entity.courseGoodsName
        tvPlayer.text = "已销售:${entity.courseSaleCount}"

        llLesson.setOnClickListener {
            if (null != itemEventListener)
                itemEventListener?.onItemEvent(position)
        }
    }
}