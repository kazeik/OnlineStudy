package com.hope.onlinestudy.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.HomeWorkAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.model.HomeWorkModel
import kotlinx.android.synthetic.main.layout_recyclerview.*
import kotlinx.android.synthetic.main.view_title.*

class HomeWorkActivity : BaseActivity(), View.OnClickListener,OnItemEventListener {
    override fun onItemEvent(pos: Int) {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_home_work
    }

    private val adapter: HomeWorkAdapter<HomeWorkModel> by lazy { HomeWorkAdapter<HomeWorkModel>() }
    override fun initData() {
        tv_title.setText("我的作业")
        iv_backup.setOnClickListener(this)

        rcvList.adapter = adapter
        rcvList.layoutManager = LinearLayoutManager(this)
        adapter.listener = this
    }

}
