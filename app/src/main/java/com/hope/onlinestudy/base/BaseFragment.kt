package com.hope.onlinestudy.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hope.lib.iter.INetStrListener
import com.hope.onlinestudy.base.BaseActivity

abstract class BaseFragment : Fragment(), INetStrListener {
    protected var activity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initView(), container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    override fun getNetStr(tag: String, body: String?) {
    }

    override fun netError(tag: String, body: String?, e: Exception?) {
    }

    override fun reLogin() {
    }

    abstract fun initView(): Int

    abstract fun bindData()

}
