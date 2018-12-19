package com.hope.onlinestudy.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 23 11:11
 * 类说明:
 */
class TabVpAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    internal var fmList: List<Fragment>? = null
    internal var fmTitle: Array<String>? = null
    override fun getItem(position: Int): Fragment {
        return fmList?.get(position)!!
    }

    override fun getCount(): Int {
        return fmList?.size!!
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fmTitle?.get(position)!!
    }
}