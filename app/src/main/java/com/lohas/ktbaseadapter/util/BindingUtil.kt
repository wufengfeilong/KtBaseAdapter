package com.lohas.ktbaseadapter.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.lohas.ktbaseadapter.R

/**
 * Created by zfw on 2019/8/1 13:59 auto
 */
class BindingUtil {
    companion object {
        @BindingAdapter("bind:imgData")
        @JvmStatic
        fun imgData(iv: ImageView, data: String) {
            Log.e("zfw",data)
            iv.setImageResource(R.drawable.using)
        }

//        @BindingAdapter("bind:refresh")
//        @JvmStatic
//        fun refreshData(data: List<UserInfo>,adapter: KtDBVMBaseAdapter<UserInfo>) {
//            Log.e("zfw",data.toString())
//            Log.e("zfw", data.size.toString())
//            adapter.mList = data
//            adapter.notifyDataSetChanged()
//        }
    }



}