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
import com.hope.onlinestudy.model.UserBoy
import com.hope.onlinestudy.utils.ApiUtils

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 27 13:46
 * 类说明:
 */
class BuyLessonAdapter<A>(private val context: Context) : BaseAdapter<A>() {
    internal var itemListener: OnItemEventListener? = null
    override fun getLayoutView(): Int {
        return R.layout.layout_home_grid
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val lessonIcon = holder.getViewById<ImageView>(R.id.ivLessonIcon)
        val lessonTitleStr = holder.getViewById<TextView>(R.id.tvLessonName)
        val lessonPlyaer = holder.getViewById<TextView>(R.id.tvPlayer)
        val lessonPrivate = holder.getViewById<TextView>(R.id.tvPrivate)
        val lessionItem = holder.getViewById<LinearLayout>(R.id.llLesson)

        val entity: UserBoy = dataList?.get(position) as UserBoy
        lessonTitleStr.text = entity.courseGoodsName

        lessonPlyaer.text = "购买数量：${entity.salePoint}"

        Glide.with(context).load("${ApiUtils.imgUrl}${entity.courseImage}").asBitmap().into(lessonIcon)

        lessionItem.setOnClickListener {
            if (null != itemListener) {
                itemListener?.onItemEvent(position)
            }
        }
    }
}