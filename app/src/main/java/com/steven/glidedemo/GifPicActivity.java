package com.steven.glidedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GifPicActivity extends AppCompatActivity {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_pic);
        mContext=this;
        findView();
        loadGlidePic();
    }

    private void findView() {
        iv1= (ImageView) findViewById(R.id.gif1);
        iv2= (ImageView) findViewById(R.id.gif2);
        iv3= (ImageView) findViewById(R.id.gif3);
    }


    private void loadGlidePic() {
        //GIF图加载偏久
        Glide.with(mContext)
                .load("http://s1.dwstatic.com/group1/M00/93/D6/e509b5e43b6001ab695d71800e55dd8e.gif")
                .placeholder(R.mipmap.icon_progress_bar)
                .into(iv1);
        Glide.with(mContext)
                .load("http://s1.dwstatic.com/group1/M00/93/D6/e509b5e43b6001ab695d71800e55dd8e.gif")
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .listener(new RequestListener<String, GifDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//
//                        return false;
//                    }
//                })
                .into(iv2);
        Glide.with(mContext)
                .load("http://s1.dwstatic.com/group1/M00/93/D6/e509b5e43b6001ab695d71800e55dd8e.gif")
                .asBitmap()
                .into(iv3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Glide.with(this).resumeRequests();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Glide.with(this).pauseRequests();
    }
}
