package com.hope.onlinestudy.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.hope.onlinestudy.R
import kotlinx.android.synthetic.main.view_dialog_loading.*

/**
 * @author kazeik.chen, QQ:77132995, email:kazeik@163.com
 * 2018 09 14 18:47
 * 类说明:
 */
@Deprecated("过时")
class LoadingDialog(context: Context) : Dialog(context, R.style.loadingDialogStyle) {
    private var msg = "加载中"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_dialog_loading)
        tv.text = msg
        LinearLayout.background.alpha = 210
    }

    fun setMsg(msg: String) {
        this.msg = msg
        tv?.text = this.msg
    }
}