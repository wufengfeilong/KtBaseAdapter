# KtBaseAdapter

#### 介绍
Kotlin封装的Recyclerview的通用adapter

1. KtBaseAdapter：普通的通用Adapter
2. KtDBBaseAdapter：结合DataBinding的通用Adapter

**只有单一数据类型的，也就是一种布局**

#### 软件版本
[![](https://www.jitpack.io/v/wufengfeilong/KtBaseAdapter.svg)](https://www.jitpack.io/#wufengfeilong/KtBaseAdapter)



#### 安装教程

**1.Import**

Step 1. Add the JitPack repository to your build file.

Add it in your **root** build.gradle at the end of repositories:

```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency

Add it in your **module** build.gradle at the end of dependencies:
```
dependencies {
   implementation 'com.github.wufengfeilong:KtBaseAdapter:tag'
 }
```

#### 使用说明之KtBaseAdapter：普通的通用Adapter

1. 自定义一个Adapter，继承自KtBaseAdapter
```
class MyAdapter: KtBaseAdapter<UserInfo>{
        constructor(mList: List<UserInfo>?, mLayoutId: Int?) : super(mList, mLayoutId)
        // 重写convert方法，用来将数据填充到每个item view中
        override fun convert(itemView : View?, item: UserInfo) {
            itemView!!.photo_iv.setImageResource(R.drawable.using)
            itemView!!.textView.text = item.name
            // 设置item中控件的点击事件（如果不需要可以不做这一步）
            itemView!!.button
                .setOnClickListener { Toast.makeText(itemView.context, "click:" + item.name, Toast.LENGTH_SHORT).show() }
        }
    }
```

2. 创建自定义Adapter，将数据源和布局文件作为参数传进去
```
val mAdapter = MyAdapter(mList, R.layout.list_item)
rv.adapter = mAdapter
```
3. 设置item view的点击事件（非必需）
```
mAdapter!!.setItemClickListener(object : KtBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })
```
4. 更新数据
```
mAdapter.updateData(mList)
```

#### 使用说明之KtDBBaseAdapter：结合DataBinding的通用Adapter

**使用了DataBinding后就不用重写Adapter了，除非你想添加item里面的控件的点击事件**

1.创建Adapter方式： 
- 如果不需要item里面控件的点击事件可以直接用KtDBBaseAdapter
```
val mAdapter = KtDBBaseAdapter(mList, R.layout.db_list_item,BR.userInfo)
```
- 需要item里面控件的点击事件可以自定义Adapter，，继承自KtDBBaseAdapter
```
class MyAdapter:KtDBBaseAdapter<UserInfo>{
        constructor(mList: List<UserInfo>?, layoutId: Int?, brId: Int?) : super(mList, layoutId, brId)

        override fun convert(itemView: View?, item: UserInfo) {
            // 控件中的点击事件设置
            itemView!!.button
                .setOnClickListener { Toast.makeText(itemView.context, "click:" + item.name, Toast.LENGTH_SHORT).show() }
        }
    }
```
```
val mAdapter = MyAdapter(mList, R.layout.db_list_item,BR.userInfo)
```
2. 设置Adapter
```
rv.adapter = mAdapter
```
3. 设置item view的点击事件（非必需）
```
mAdapter!!.setItemClickListener(object : KtBaseAdapter.ItemClick {
            override fun OnItemClick(v: View, position: Int) {
                Toast.makeText(this@MainActivity, "click$position", Toast.LENGTH_SHORT).show()
            }
        })
```
4. 更新数据
```
mAdapter.updateData(mList)
```


