package com.hope.onlinestudy.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.MessageAdapter
import com.hope.onlinestudy.base.LazyFragment
import com.hope.onlinestudy.model.MessageModel
import com.hope.onlinestudy.model.MsgNotifModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.layout_recyclerview.*
import org.jetbrains.anko.support.v4.toast


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 10 31 14:41
 * 类说明:
 */
class MessageFragment : LazyFragment() {
    private var page = 1
    private val allMsg :ArrayList<MessageModel> by lazy { ArrayList<MessageModel>() }
    override fun lazyLoad() {
        if(allMsg.isEmpty())
            getData()
    }

    private val adapter: MessageAdapter<MessageModel> by lazy { MessageAdapter<MessageModel>() }

    override fun initView(): Int {
        return R.layout.layout_recyclerview
    }

    override fun bindData() {
        rcvList.layoutManager = LinearLayoutManager(activity)
        rcvList.adapter = adapter
    }

    private fun getData() {
        activity?.showDialog()
        apiInter.getmessage("0", page)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when(tag){
            ApiUtils.toMyMsg->{
                try {
                    val model = parserJson<MsgNotifModel>(body)
                    if (model.statusCode == 0)
                        allMsg.addAll(model.list!!)
                    adapter.setDataEntityList(allMsg)
                }catch (ex:Exception){
                    toast("数据解析出错")
                    ex.printStackTrace()
                }
            }
        }
    }
}