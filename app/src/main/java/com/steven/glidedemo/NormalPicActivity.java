package com.steven.glidedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class NormalPicActivity extends AppCompatActivity {

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_pic);
        mContext=this;
        findView();
        loadGlidePic();
    }

    private void findView() {
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv3= (ImageView) findViewById(R.id.iv3);
        iv4= (ImageView) findViewById(R.id.iv4);
        iv5= (ImageView) findViewById(R.id.iv5);
        iv6= (ImageView) findViewById(R.id.iv6);
    }


    private void loadGlidePic() {
        //普通图片
        Glide.with(mContext)
                .load("http://mvimg1.meitudata.com/5689edd0af01c649.jpg")
                .placeholder(R.mipmap.icon_placeholder)
                .crossFade(500)
                .into(iv1);
        //1080p http://pic1.win4000.com/wallpaper/c/53d715df6274d.jpg
        Glide.with(mContext)
                .load("http://pic1.win4000.com/wallpaper/c/53d715df6274d.jpg")
                .placeholder(R.mipmap.icon_placeholder)
                .thumbnail(0.2f)
                .into(iv2);
        //错误图片
        Glide.with(mContext)
                .load("http://pic1.win4000.com/wallpaper/715df6274d.jpg")
                .placeholder(R.mipmap.icon_placeholder)
                .error(R.mipmap.icon_failure)
                .into(iv3);
        //圆形裁剪
        Glide.with(mContext)
                .load("http://img5.duitang.com/uploads/item/201603/12/20160312100201_Hhm43.thumb.700_0.jpeg")
                .bitmapTransform(new CropCircleTransformation(this))
                .into(iv4);
        //圆角处理
        Glide.with(this)
                .load("http://img5.duitang.com/uploads/item/201603/12/20160312100201_Hhm43.thumb.700_0.jpeg")
                .bitmapTransform(new RoundedCornersTransformation(this,30,0, RoundedCornersTransformation.CornerType.ALL))
                .into(iv5);
        //灰度处理
        Glide.with(this)
                .load("http://img5.duitang.com/uploads/item/201603/12/20160312100201_Hhm43.thumb.700_0.jpeg")
                .bitmapTransform(new GrayscaleTransformation(this))
                .into(iv6);
    }

    private static class MyTransformation extends BitmapTransformation{

        public MyTransformation(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            //对bitmap进行各种变换处理
            return null;
        }

        @Override
        public String getId() {
            // 返回代表该变换的唯一Id，会作为cache key的一部分。
            // 注意：最好不要用getClass().getName()，因为容易受混淆影响。如果变换过程不影响缓存数据，可以返回空字符串
            return null;
        }
    }
}
