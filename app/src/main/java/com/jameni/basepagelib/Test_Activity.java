package com.jameni.basepagelib;

import com.jameni.basepage_lib.baseactivity.ModelActiviy;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.page_test)
public class Test_Activity extends ModelActiviy {


    @AfterViews
    void initPage() {
        setPageTitle("测试页面");
    }

    @Click
    void btnBack() {

        tip("return back");
        finish();

    }

    @Click
    void tv0() {
        //设置标题
    }

    @Click
    void tv1() {
        //设置右上方文本
    }

    @Click
    void tv2() {
        //设置右上方图片

    }


}
