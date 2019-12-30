package com.bawei.lqy.utile;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Time:2019/12/30 0030上午 08:49201912
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class NetUtile {
    private static NetUtile netUtile;
    private  Handler handler;
    private  OkHttpClient build;

    private NetUtile() {
        handler = new Handler();
        build = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static NetUtile getInstance() {
        if(netUtile==null){
            synchronized (NetUtile.class){
                if(netUtile==null){
                    netUtile=new NetUtile();
                }
            }
        }
        return netUtile;
    }
    public interface MyCallback{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }

    public void onJsonGet(String httpUrl, final MyCallback myCallback){
        final Request request = new Request.Builder()
                .get()
                .url(httpUrl)
                .build();
        Call call = build.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response != null && response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.onGetJson(string);
                        }
                    });
                }
            }
        });
    }

    public void onJsonPost(String httpUrl, Map<String,String> map, final MyCallback myCallback){
        FormBody.Builder builder = new FormBody.Builder();
        for (String key:map.keySet()){
            String value = map.get(key);
            builder.add(key,value);
        }
        FormBody build = builder.build();
        final Request request = new Request.Builder()
                .post(build)
                .url(httpUrl)
                .build();
        Call call = this.build.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response != null && response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.onGetJson(string);
                        }
                    });
                }
            }
        });
    }
}
