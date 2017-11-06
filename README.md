# EasyBanner

> 一个轻松实现简单banner的框架，轻松实现。。。。

### 先上效果图：
![](http://olg7c0d2n.bkt.clouddn.com/17-10-3/64062219.jpg)

### 已实现的功能
* 自动轮播
* 无限左划右划
* 加载网络图片交给外部调用者（实现解耦），加载标题
* 底部小白点可切换，大小可换，数量可动态增加
* 触摸时不能滑动
* 实现banner的item点击事件
* 广告数目可以随意
* 可以在代码中生成banner，也可以在xml布局中生成

## 简单使用

> 使用前将该EasyBanner 这个module导入到自己的项目，并在app主项目中依赖此module.

### 1.在xml中使用

``` xml
<com.xfhy.easybanner.ui.EasyBanner
    android:id="@+id/eb_banner"
    android:layout_width="match_parent"
    android:layout_height="200dp"/>
```

``` java
//可以在布局里面写
mBanner = (EasyBanner) findViewById(R.id.eb_banner);
//初始化:设置图片url和图片标题
mBanner.initBanner(getImageUrlData(), getContentData());
// 开始轮播
mBanner.start();
```

### 2.在代码中使用banner

``` java
//也可以直接动态生成
EasyBanner easyBanner = new EasyBanner(this);
//初始化:设置图片url和图片标题
easyBanner.initBanner(getImageUrlData(), getContentData());
mRootView.addView(easyBanner,new LinearLayout.LayoutParams(LinearLayout
        .LayoutParams.MATCH_PARENT, DensityUtil.dip2px(this,200)));
// 开始轮播
mBanner.start();
```


### 3.设置图片加载器（必须）

``` java
//设置图片加载器
mBanner.setImageLoader(new EasyBanner.ImageLoader() {
    @Override
    public void loadImage(ImageView imageView, String url) {
        Glide.with(mContext).load(url).into(imageView);
    }
});
```

### 4.实现点击事件(非必须)

```java
//监听banner的item点击事件
mBanner.setOnItemClickListener(new EasyBanner.OnItemClickListener() {
    @Override
    public void onItemClick(int position, String title) {
        Toast.makeText(MainActivity.this, "position:"+position+"   title:"+title, Toast
                .LENGTH_SHORT).show();
    }
});
```

### 5.开始轮播(必须)

初始化之后就可以调用start()方法开始轮播啦

当然也可以在Activity或者fragment中的onResume()方法中调用start()方法开始轮播

```java
mBanner.start();
```
### 6.结束轮播(必须)

当我们在离开当前Activity或者fragment时我们需要结束轮播,当然你也可以不结束.不结束轮播的话,它就一直在后台轮播....哈哈哈哈,这个问题暂时没有解决,,,,

```java
@Override
protected void onStop() {
    super.onStop();
    if (mBanner != null) {
        mBanner.stop();
    }
}
```

基本使用就是这样，详情请看demo