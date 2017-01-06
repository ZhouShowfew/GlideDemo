package com.steven.glidedemo;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by Steven on 2017/1/5.
 */

public class MyGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder
                //.setBitmapPool(new LruBitmapPool(50*1024*1024))//让各尺寸的bitmap被复用
                .setDiskCache(new ExternalCacheDiskCacheFactory(context,50*1024*1024))//可设置内外部存储，缓存目录，缓存最大值
                //.setMemoryCache(new LruResourceCache((int) Runtime.getRuntime().maxMemory()/4))//Glide默认会考虑该设备大小，可用内存来计算出一个合理的默认值
                .setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);

//        builder.setDiskCache(new DiskCache.Factory() {
//            @Override
//            public DiskCache build() {
//                File cacheLoc=new File("缓存路径");
//                cacheLoc.mkdirs();
//                return DiskLruCacheWrapper.get(cacheLoc,缓存大小);
//            }
//        });
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
