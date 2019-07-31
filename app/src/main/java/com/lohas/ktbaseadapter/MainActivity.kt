package com.lohas.ktbaseadapter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lohas.library.KtBaseAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mList: ArrayList<UserInfo>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        rv.layoutManager = LinearLayoutManager(this)



        val mAdapter = MyAdapter(mList, this, R.layout.list_item)
        rv.adapter = mAdapter
        mAdapter!!.setItemClickListener(object : KtBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })



    }

    class MyAdapter: KtBaseAdapter<UserInfo>{

        constructor(mList: List<UserInfo>?, mContext: Context?, mLayoutId: Int?) : super(mList, mContext, mLayoutId)


        override fun convert(holder: KtViewHolder, item: UserInfo) {
            holder.getView<ImageView>(R.id.photo_iv).setImageResource(R.drawable.using)
            holder.getView<TextView>(R.id.textView).text = item.name
            holder.getView<Button>(R.id.button)
                .setOnClickListener { Toast.makeText(mContext, "click:" + item.name, Toast.LENGTH_SHORT).show() }

        }

    }


}
