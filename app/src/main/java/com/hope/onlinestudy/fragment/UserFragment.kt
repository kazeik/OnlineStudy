package com.hope.onlinestudy.fragment


import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.hope.onlinestudy.base.BaseFragment

import com.hope.onlinestudy.R
import com.hope.onlinestudy.activity.*
import kotlinx.android.synthetic.main.fragment_user.*

/**
 * A simple [Fragment] subclass.
 *
 */
class UserFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rlChangePass -> startActivity(Intent(activity, ChangePassActivity::class.java))
            R.id.rlInfo -> startActivity(Intent(activity, InfoActivity::class.java))
            R.id.rlJf -> startActivity(Intent(activity, IntegralActivity::class.java))
            R.id.rlMessage -> startActivity(Intent(activity, MessageActivity::class.java))
            R.id.rlOrder -> startActivity(Intent(activity, OrderActivity::class.java))
            R.id.rlZy -> startActivity(Intent(activity, HomeWorkActivity::class.java))
            R.id.btnExit -> {
            }
        }
    }

    override fun initView(): Int {
        return R.layout.fragment_user
    }

    override fun bindData() {
        rlChangePass.setOnClickListener(this)
        rlInfo.setOnClickListener(this)
        rlJf.setOnClickListener(this)
        rlMessage.setOnClickListener(this)
        rlOrder.setOnClickListener(this)
        rlZy.setOnClickListener(this)
    }


}
