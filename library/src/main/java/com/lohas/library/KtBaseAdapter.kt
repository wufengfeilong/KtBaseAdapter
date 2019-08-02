package com.lohas.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.lohas.library.KtBaseAdapter.KtViewHolder
import java.util.*

/**
 * Created by zfw on 2019/7/30 15:15
 */
open class KtBaseAdapter<T>: Adapter<KtViewHolder> {


    private var mList: List<T>? = null
    private var mLayoutId:Int? = null
    var itemClick : ItemClick ?= null

    constructor(mList: List<T>?, mLayoutId: Int?) {
        this.mList = mList
        this.mLayoutId = mLayoutId
    }

    interface ItemClick{
        fun OnItemClick(v: View, position: Int)
    }
    fun setItemClickListener(itemClick : ItemClick){
        this.itemClick = itemClick
    }
    fun updateData(items :  ArrayList<T>?){
        this.mList = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KtViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(this!!.mLayoutId!!, parent, false)
        return KtViewHolder(v)
    }

    override fun onBindViewHolder(holder: KtViewHolder, position: Int) {
        val item = mList!![position]
        // item点击事件
        holder.itemView.setOnClickListener {
            itemClick?.OnItemClick(holder.itemView, position)
        }
        convert(holder.itemView, item)
    }

    open fun convert(itemView : View?, item: T){

    }

    override fun getItemCount(): Int = mList!!.size

    class KtViewHolder(itemView : View?):RecyclerView.ViewHolder(itemView!!){
        fun<T : View?> getView(id:Int):T{
            return itemView!!.findViewById<T>(id)
        }
    }
}