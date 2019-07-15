package com.example.bannerdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Banner mbanner;
    private MyImageLoader myImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        initData();
        initView();
    }

    private void initData(){
        imagePath =new ArrayList<>();
        imageTitle =  new ArrayList<>();
        imagePath.add(R.mipmap.hehe);
        imagePath.add(R.mipmap.haha);
        imagePath.add(R.mipmap.heihei);
        imageTitle.add("hehe");
        imageTitle.add("haha");
        imageTitle.add("heihie");
    }
    private void initView(){
        myImageLoader = new MyImageLoader();
        mbanner = findViewById(R.id.banner);
        //设置 banner样式
        mbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mbanner.setImageLoader(myImageLoader);
        //设置轮播的动画效果
        mbanner.setBannerAnimation(Transformer.ZoomOutSlide);
        //设置图片的文字
        mbanner.setBannerTitles(imageTitle);
        //设置轮播的时间间隔
        mbanner.setDelayTime(3000);
        //设置是否为自动轮播
        mbanner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        mbanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载地址
        mbanner.setImages(imagePath)

                //轮播图的监听
               .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        switch (position){
                            case 0:
                                textView.setText("haha");
                                break;
                            case 1:
                                textView.setText("hehe");
                                break;
                            case 2:
                                textView.setText("heihei");
                                break;
                        }
                    }
                })
        .start();
    }



    public class  MyImageLoader extends ImageLoader{
        @Override
        public void displayImage(Context context,Object path, ImageView imageView){
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }

}
