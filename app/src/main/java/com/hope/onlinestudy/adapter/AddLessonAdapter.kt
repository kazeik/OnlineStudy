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
import com.hope.onlinestudy.model.UserFavorites
import com.hope.onlinestudy.utils.ApiUtils

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 27 13:46
 * 类说明:
 */
class AddLessonAdapter<A>(private val context: Context) : BaseAdapter<A>() {
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

        val entity: UserFavorites = dataList?.get(position) as UserFavorites

        lessonPrivate.text = if (entity.isopen == 1) {
            "公开"
        } else {
            "VIP"
        }
        lessonPlyaer.text = "已销售：${entity.salePoint}"
        lessonTitleStr.text = entity.courseGoodsName
        Glide.with(context).load("${ApiUtils.imgUrl}${entity.courseImage}").into(lessonIcon)

        lessionItem.setOnClickListener {
            if (null != itemListener) {
                itemListener?.onItemEvent(position)
            }
        }
    }
}