package com.bawei.lqy.contract;

import com.bawei.lqy.model.bean.GsonBean;

/**
 * Time:2019/12/30 0030上午 08:47201912
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface IMainContract {
    interface IView{
        void onMainSueccess(String bean);
        void onMainFailure(Throwable throwable);
    }

    interface IPresenter{
        void onMainData();
    }

    interface IModel{
        void onMainData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onMainSueccess(String bean);
            void onMainFailure(Throwable throwable);
        }
    }
}
