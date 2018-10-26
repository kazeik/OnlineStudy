package com.hope.onlinestudy.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.OrderAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.model.OrderModel
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.layout_recyclerview.*
import kotlinx.android.synthetic.main.view_title.*

class OrderActivity : BaseActivity(), View.OnClickListener {
    private val adapter: OrderAdapter<OrderModel> by lazy { OrderAdapter<OrderModel>() }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
            R.id.tvObil -> {
            }
            R.id.tvIsPay -> {
            }
            R.id.tvNoPay -> {
            }
            R.id.tvCurrent -> {
            }
            R.id.tvHistroy -> {
            }
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_order
    }

    override fun initData() {
        tv_title.setText("我的订单")
        iv_backup.setOnClickListener(this)
        tvObil.setOnClickListener(this)
        tvIsPay.setOnClickListener(this)
        tvNoPay.setOnClickListener(this)
        tvCurrent.setOnClickListener(this)
        tvHistroy.setOnClickListener(this)

        rcvList.adapter = adapter
        rcvList.layoutManager = LinearLayoutManager(this)
    }

}
