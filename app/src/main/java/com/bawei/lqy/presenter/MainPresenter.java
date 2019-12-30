package com.bawei.lqy.presenter;

import com.bawei.lqy.base.BasePresenter;
import com.bawei.lqy.contract.IMainContract;
import com.bawei.lqy.model.MainModel;
import com.bawei.lqy.model.bean.GsonBean;

/**
 * Time:2019/12/30 0030上午 09:00201912
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class MainPresenter extends BasePresenter<IMainContract.IView> implements IMainContract.IPresenter {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }

    @Override
    public void onMainData() {

        mainModel.onMainData(new IMainContract.IModel.IModelCallback() {
            @Override
            public void onMainSueccess(String bean) {
                view.onMainSueccess(bean);
            }

            @Override
            public void onMainFailure(Throwable throwable) {

                view.onMainFailure(throwable);
            }
        });
    }
}
