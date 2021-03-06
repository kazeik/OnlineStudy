package com.hope.onlinestudy.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.PointAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.model.PointListModel
import com.hope.onlinestudy.model.PointModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import com.hope.onlinestudy.view.RecycleViewDivider
import kotlinx.android.synthetic.main.activity_integral.*
import kotlinx.android.synthetic.main.view_title.*

class IntegralActivity : BaseActivity(), View.OnClickListener {
    private var page = 1
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    private val adapter: PointAdapter<PointModel> by lazy { PointAdapter<PointModel>() }
    override fun getLayoutView(): Int {
        return R.layout.activity_integral
    }

    override fun initData() {
        tv_title.text = "我的积分"
        iv_backup.setOnClickListener(this)

        rcvList.layoutManager = LinearLayoutManager(this)
        rcvList.addItemDecoration(RecycleViewDivider(this,LinearLayoutManager.VERTICAL))
        rcvList.adapter = adapter

        getPoint()
    }

    private fun getPoint() {
        showDialog()
        apiInter.getUserPoint(page)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        if (tag == ApiUtils.toMyPoint) {
            val model: PointListModel = parserJson(body)
            adapter.setDataEntityList(model.list)
        }
    }
}
