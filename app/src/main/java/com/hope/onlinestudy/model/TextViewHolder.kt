package com.hope.onlinestudy.model

import android.view.View
import android.widget.TextView
import com.hope.onlinestudy.R


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 08 21:21
 * 类说明:
 */
class TextViewHolder(view: View) {
    var textView: TextView? = null

    init {
        textView = view.findViewById(R.id.tvTitle)
    }
}