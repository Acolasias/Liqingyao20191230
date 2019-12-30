package com.bawei.lqy.model;

import com.bawei.lqy.contract.IMainContract;
import com.bawei.lqy.model.bean.GsonBean;
import com.bawei.lqy.utile.NetUtile;
import com.google.gson.Gson;

/**
 * Time:2019/12/30 0030上午 08:59201912
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class MainModel implements IMainContract.IModel {
    @Override
    public void onMainData(final IModelCallback iModelCallback) {
        NetUtile.getInstance().onJsonGet("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtile.MyCallback() {
            @Override
            public void onGetJson(String json) {
                iModelCallback.onMainSueccess(json);
            }

            @Override
            public void onError(Throwable throwable) {

                iModelCallback.onMainFailure(throwable);
            }
        });
    }
}
