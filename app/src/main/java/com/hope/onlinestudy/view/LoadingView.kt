package com.hope.onlinestudy.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.DialogFragment
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.TextView
import com.hope.onlinestudy.R


/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 09 20 10:46
 * 类说明:
 */
class LoadingView : DialogFragment() {
    private var showDialog: Dialog? = null

    companion object {
        fun getInstance(msg: String? = "加载中", cancel: Boolean = false): LoadingView {
            val view = LoadingView()
            val bund = Bundle()
            bund.putString("msg", msg)
            bund.putBoolean("cancel", cancel)
            view.arguments = bund
            return view
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        showDialog = Dialog(activity, R.style.loadingDialogStyle)

        showDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        showDialog?.setContentView(view)


        val dialogWindow = showDialog?.window
        dialogWindow?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val lp = dialogWindow?.attributes
        lp?.gravity = Gravity.CENTER
        lp?.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialogWindow?.attributes = lp

        return showDialog!!
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = LayoutInflater.from(activity).inflate(R.layout.view_dialog_loading, null)
        val textview = view.findViewById<TextView>(R.id.tv)
        val tempBund = arguments
        if (null != tempBund) {
            val showmsg = tempBund.getString("msg")
            textview.text = showmsg
            val isCancel = tempBund.getBoolean("cancel")
            showDialog?.setCanceledOnTouchOutside(isCancel)
            showDialog?.setCancelable(isCancel)
            showDialog?.setOnKeyListener(object : DialogInterface.OnKeyListener {
                override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
                    return !isCancel
                }
            })
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        showDialog?.dismiss()
        showDialog = null
    }


}