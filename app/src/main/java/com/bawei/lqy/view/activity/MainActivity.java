package com.bawei.lqy.view.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lqy.R;
import com.bawei.lqy.base.BaseActivity;
import com.bawei.lqy.contract.IMainContract;
import com.bawei.lqy.model.bean.GsonBean;
import com.bawei.lqy.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IView {


    @BindView(R.id.test)
    TextView test;

    @Override
    protected void initData() {
        mPresenter.onMainData();
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected MainPresenter providerPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMainSueccess(String bean) {

        test.setText(bean);
        Toast.makeText(this, "请求成功"+bean, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMainFailure(Throwable throwable) {

        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }


}
