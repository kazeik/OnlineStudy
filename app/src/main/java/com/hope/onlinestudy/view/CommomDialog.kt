package com.hope.onlinestudy.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.hope.onlinestudy.R


/**
 * @author hope.chen
 * QQ:77132995 email:kazeik@163.com
 * 2018 10 27 16:15
 * 类说明:
 */
class CommomDialog : Dialog, View.OnClickListener {
    private var contentTxt: TextView? = null
    private var titleTxt: TextView? = null
    private var submitTxt: TextView? = null
    private var cancelTxt: TextView? = null

    private var cancelImg: ImageView? = null

    private var mContext: Context? = null
    private var content: String? = null
    private var listener: OnCloseListener? = null
    private var positiveName: String? = null
    private var negativeName: String? = null
    private var title: String? = null

    constructor(context: Context) : super(context) {
        this.mContext = context
    }

    constructor(context: Context, themeResId: Int, content: String) : super(context, themeResId) {
        this.mContext = context
        this.content = content
    }

    constructor(context: Context, themeResId: Int, content: String, listener: OnCloseListener) : super(context, themeResId) {
        this.mContext = context
        this.content = content
        this.listener = listener
    }

    protected constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {
        this.mContext = context
    }

    fun setTitle(title: String): CommomDialog {
        this.title = title
        return this
    }

    fun setPositiveButton(name: String): CommomDialog {
        this.positiveName = name
        return this
    }

    fun setNegativeButton(name: String): CommomDialog {
        this.negativeName = name
        return this
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_commom)
        setCanceledOnTouchOutside(false)
        initView()
    }

    private fun initView() {
        contentTxt = findViewById(R.id.content)
        titleTxt = findViewById(R.id.title)
        submitTxt = findViewById(R.id.submit)
        submitTxt?.setOnClickListener(this)
        cancelTxt = findViewById(R.id.cancel)
        cancelTxt?.setOnClickListener(this)

        cancelImg = findViewById(R.id.ivClose)
        cancelImg?.setOnClickListener(this)

        contentTxt?.text = content
        if (!TextUtils.isEmpty(positiveName)) {
            submitTxt?.text = positiveName
        }

        if (!TextUtils.isEmpty(negativeName)) {
            cancelTxt?.text = negativeName
        }

        if (!TextUtils.isEmpty(title)) {
            titleTxt?.text = title
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.cancel, R.id.ivClose -> {
                listener?.onClick(this, false)
                this.dismiss()
            }
            R.id.submit -> listener?.onClick(this, true)
        }
    }

    interface OnCloseListener {
        fun onClick(dialog: Dialog, confirm: Boolean)
    }
}
