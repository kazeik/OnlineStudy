package com.hope.onlinestudy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.hope.onlinestudy.R
import com.hope.onlinestudy.model.MenuModel
import com.hope.onlinestudy.model.TextViewHolder


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 08 21:04
 * 类说明:
 */
class ClassifyAdapter : BaseExpandableListAdapter() {
    private var menuListData: List<MenuModel>? = null

    fun setData(menuList: List<MenuModel>) {
        this.menuListData = menuList
        notifyDataSetChanged()
    }

    override fun getGroup(groupPosition: Int): Any {
        return menuListData?.get(groupPosition)?.specialtyName!!
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null
        var holder: TextViewHolder? = null
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context!!).inflate(R.layout.layout_textview, null)
            holder = TextViewHolder(view)
            view?.setTag(holder)
        } else {
            view = convertView
            holder = view.tag as TextViewHolder
        }
        holder.textView?.text = menuListData?.get(groupPosition)?.specialtyName
        return view!!
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return if (menuListData == null || menuListData?.isEmpty()!! || menuListData?.get(groupPosition)?.secondStudySpecialty == null
                || menuListData?.get(groupPosition)?.secondStudySpecialty?.isEmpty()!!) {
            0
        } else {
            menuListData?.get(groupPosition)?.secondStudySpecialty?.size!!
        }
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return menuListData?.get(groupPosition)?.secondStudySpecialty?.get(childPosition)?.specialtyName!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null
        var holder: TextViewHolder? = null
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context!!).inflate(R.layout.layout_textview, null)
            holder = TextViewHolder(view)
            view?.tag = holder
        } else {
            view = convertView
            holder = view.getTag() as TextViewHolder
        }
        holder.textView?.text = menuListData?.get(groupPosition)?.secondStudySpecialty?.get(childPosition)?.specialtyName
        return view!!
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return if (menuListData == null || menuListData?.isEmpty()!!) {
            0
        } else {
            menuListData?.size!!
        }
    }

}