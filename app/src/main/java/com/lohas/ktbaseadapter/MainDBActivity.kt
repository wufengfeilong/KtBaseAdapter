package com.lohas.ktbaseadapter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lohas.library.KtDBBaseAdapter
import kotlinx.android.synthetic.main.activity_main_db.*
import kotlinx.android.synthetic.main.db_list_item.view.*

class MainDBActivity : AppCompatActivity() {

    var mList: ArrayList<UserInfo>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_db)

        getData()

        db_rv.layoutManager = LinearLayoutManager(this)
//        val mAdapter = MyAdapter(mList, R.layout.db_list_item,BR.userInfo)
        val mAdapter = KtDBBaseAdapter(mList, R.layout.db_list_item,BR.userInfo)
        db_rv.adapter = mAdapter
        mAdapter!!.setItemClickListener(object : KtDBBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainDBActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getData() {
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
        mList?.add(UserInfo("1", "zhangsan", "123"))
        mList?.add(UserInfo("2", "lisi", "123"))
        mList?.add(UserInfo("3", "wangwu", "123"))
    }

    class MyAdapter:KtDBBaseAdapter<UserInfo>{
        constructor(mList: List<UserInfo>?, layoutId: Int?, brId: Int?) : super(mList, layoutId, brId)

        override fun convert(itemView: View?, item: UserInfo) {
            itemView!!.button
                .setOnClickListener { Toast.makeText(itemView.context, "click:" + item.name, Toast.LENGTH_SHORT).show() }
        }
    }
}
