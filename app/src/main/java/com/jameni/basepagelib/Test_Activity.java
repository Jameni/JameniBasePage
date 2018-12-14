package com.jameni.basepagelib;

import com.jameni.basepage_lib.baseactivity.ModelActiviy;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.page_test)
public class Test_Activity extends ModelActiviy {


    @AfterViews
    void initPage() {
        setPageTitle("测试");
    }

    @Click
    void btnBack() {

        tip("return back");
        finish();

    }



    @Click
    void tv0() {
        //设置标题
        setPageTitle(tvPageTitle.getText().toString()+"123");

    }

    @Click
    void tv1() {
        //设置右上方文本

        setRightText(tvRight.getText().toString()+"123");
    }

    @Click
    void tv2() {
        //设置右上方图片

        setRightImage(R.mipmap.logo_lib_set);

    }


}
