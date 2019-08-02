package com.lohas.ktbaseadapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lohas.library.KtBaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*
import com.lohas.ktbaseadapter.MainDBActivity as MainDBActivity1
/**
 * Created by zfw on 2019/8/2 10:38
 * 通用的RecyclerView Adapter使用例
 */
class MainActivity : AppCompatActivity() {
    //①定义数据源
    var mList: ArrayList<UserInfo>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //②获取数据
        getData()
        //③设置RecyclerView布局
        rv.layoutManager = LinearLayoutManager(this)
        //⑥创建自定义Adapter，将数据源和布局文件作为参数传进去
        val mAdapter = MyAdapter(mList, R.layout.list_item)
        //⑦设置Adapter
        rv.adapter = mAdapter
        //⑧设置item view的点击事件（如果不需要可以不做这一步）
        mAdapter!!.setItemClickListener(object : KtBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })

        mAdapter.updateData(mList)

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
    //④自定义一个Adapter，继承自KtBaseAdapter
    class MyAdapter: KtBaseAdapter<UserInfo>{

        constructor(mList: List<UserInfo>?, mLayoutId: Int?) : super(mList, mLayoutId)
        //⑤重写convert方法，用来将数据填充到每个item view中
        override fun convert(itemView : View?, item: UserInfo) {
            itemView!!.photo_iv.setImageResource(R.drawable.using)
            itemView!!.textView.text = item.name
            //⑨设置item中控件的点击事件（如果不需要可以不做这一步）
            itemView!!.button
                .setOnClickListener { Toast.makeText(itemView.context, "click:" + item.name, Toast.LENGTH_SHORT).show() }

        }

    }

    fun jumpDb(v:View){
        toActivity(this, com.lohas.ktbaseadapter.MainDBVMActivity().javaClass)
    }

    private fun toActivity(ctx: Context, clazz:Class<Any>){
        var intent = Intent()
        intent.setClass(ctx,clazz)
        startActivity(intent)
    }
}
