package com.example.shoppingmall.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoppingmall.R;
import com.example.shoppingmall.adapter.DividerItemDecortion;
import com.example.shoppingmall.adapter.HomeCatgoryAdapter;
import com.example.shoppingmall.bean.HomeCategory;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomePageFragment extends BaseFragment {
    private Banner banner;
    //放图片地址的集合
    private ArrayList list_path = new ArrayList<>();
    //放标题的集合
    private ArrayList list_title = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private HomeCatgoryAdapter mAdatper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
    }

    public void initView(View view) {
        banner = view.findViewById(R.id.banner);
        mRecyclerView = view.findViewById(R.id.recyclerView);

        List<HomeCategory> datas = new ArrayList<>(15);
        HomeCategory category = new HomeCategory("点餐平台（一）", R.mipmap.xq1, R.mipmap.xq2, R.mipmap.xq3);
        datas.add(category);
        category = new HomeCategory("点餐平台（二）", R.mipmap.xq4, R.mipmap.xq5, R.mipmap.xq6);
        datas.add(category);
        category = new HomeCategory("点餐平台（三）", R.mipmap.xq7, R.mipmap.xq8, R.mipmap.xq9);
        datas.add(category);
        category = new HomeCategory("点餐平台（四）", R.mipmap.xq1, R.mipmap.xq2, R.mipmap.xq3);
        datas.add(category);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecortion());
        mAdatper = new HomeCatgoryAdapter(datas);
        mRecyclerView.setAdapter(mAdatper);
    }

    public void initData() {
        setBanner();
    }

    @Override
    public void initImmersionBar() {
        statusBarConfig().titleBar(R.id.view).init();
    }

    private void setBanner() {
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是"是"。
        banner.isAutoPlay(true);
        //设置不能手动影响 默认是手指触摸 轮播图不能翻页
        banner.setViewPagerIsScroll(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
//                .setOnBannerListener((OnBannerListener) this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}