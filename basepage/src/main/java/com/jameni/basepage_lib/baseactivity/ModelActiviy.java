package com.jameni.basepage_lib.baseactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jameni.basepage_lib.R;


public class ModelActiviy extends FinalActivity implements View.OnClickListener {

    public final static String PROGRESS = "com.jameni.basepage_lib.progress";
    public TextView tvBack, tvRight, tvPageTitle;//回退，标题，右边菜单按钮
    public ImageView imgBack, imgRight;//回退图片
    public RelativeLayout btnRight, headlayout, layoutContent, btnBack;//回退,整个头部
    public ProgressBar pbLoading;
    private boolean IsFront; //用来标记这个ACTIVIy 是否显示在最前面，如果在前面 收到广播 播放LOADING，之前是在ONpause 的时候注销广播 发现再回到页面 收不到广播，所以使用一个变量的方式来减少页面刷新
    public LinearLayout llLoading;
    public TextView tvLoadingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.page_model);
        findView();
        registerBroad();
    }


    private void findView() {
        // 取得页面容器 用于子页面的视图添加

        imgBack = findViewById(R.id.imgBack);
        tvBack = findViewById(R.id.tvBack);
        btnBack = findViewById(R.id.btnBack);

        tvPageTitle = findViewById(R.id.tvPageTitle);

        btnRight = findViewById(R.id.btnRight);
        imgRight = findViewById(R.id.imgRight);
        tvRight = findViewById(R.id.tvRight);

        layoutContent = findViewById(R.id.layoutContent);
        headlayout = findViewById(R.id.headlayout);

        pbLoading = findViewById(R.id.pbLoading);
        llLoading = findViewById(R.id.llLoading);
        tvLoadingText = findViewById(R.id.tvLoadingText);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutContent.addView(View.inflate(this, layoutResID, null), params);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (view == null)
            return;

        layoutContent.addView(view, params);
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    //页面内容是否展示
    public void setContentBackground(int bgColor) {
        layoutContent.setBackgroundColor(getResources().getColor(bgColor));
    }


    //页面内容是否展示
    public void setContentVisible(boolean flag) {

        if (flag)
            layoutContent.setVisibility(View.VISIBLE);
        else
            layoutContent.setVisibility(View.INVISIBLE);
    }

    //公用头部是否展示
    public void setHeadVisible(boolean flag) {

        if (flag)
            headlayout.setVisibility(View.VISIBLE);
        else
            headlayout.setVisibility(View.GONE);
    }


    //是否展示回退按钮
    public void setBackButtonVisible(boolean flag) {

        if (flag)
            btnBack.setVisibility(View.VISIBLE);
        else
            btnBack.setVisibility(View.INVISIBLE);
    }

    //是否展示标题
    public void setTitelVisible(boolean flag) {

        if (flag)
            tvPageTitle.setVisibility(View.VISIBLE);
        else
            tvPageTitle.setVisibility(View.INVISIBLE);
    }

    /**
     * 设置页面标题
     *
     * @param title
     */
    public void setPageTitle(String title) {
        if (tvPageTitle != null) {
            tvPageTitle.setText(TextUtils.isEmpty(title) ? "" : title);
        }
    }

    /**
     * 设置页面标题
     */
    public void setPageTitle(int title_resid) {
        tvPageTitle.setText(getResources().getString(title_resid));
    }


    /**
     * 设置回退按钮图片
     *
     * @param resId
     */
    public void setBackImage(int resId) {
        imgBack.setImageResource(resId);
        imgBack.setVisibility(View.VISIBLE);
        tvBack.setVisibility(View.GONE);
    }


    /**
     * 设置回退按钮文字
     *
     * @param str
     */
    public void setBackText(String str) {
        tvBack.setText(TextUtils.isEmpty(str) ? "" : str);
        tvBack.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);
    }


    /**
     * 设置信息按钮图片
     *
     * @param resId
     */
    public void setRightImage(int resId) {
        imgRight.setImageResource(resId);
        imgRight.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.GONE);
        btnRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置信息按钮文字
     *
     * @param str
     */
    public void setRightText(String str) {
        tvRight.setText(TextUtils.isEmpty(str) ? "" : str);
        tvRight.setVisibility(View.VISIBLE);
        imgRight.setVisibility(View.GONE);
        btnRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置信息按钮文字
     */
    public void setRightText(int resId) {
        tvRight.setText(getResources().getString(resId));
        tvRight.setVisibility(View.VISIBLE);
        imgRight.setVisibility(View.GONE);
    }

    /**
     * 是否显示标题栏右边文字
     *
     * @return
     */
    public void setRightTextIsView(boolean isShow) {
        if (isShow) {
            tvRight.setVisibility(View.VISIBLE);
        } else {
            tvRight.setVisibility(View.GONE);
        }
    }


    /**
     * 设置右边文子的文本
     *
     * @return
     */
    public void setLeftTextContent(String textContent) {
        if (!TextUtils.isEmpty(textContent)) {
            tvRight.setText(textContent);
        }
    }

    public void changeRightIcon(Drawable drawable) {
        imgBack.setImageDrawable(null);
        imgBack.setImageDrawable(drawable);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnBack) {
            finish();
        }
    }


    public String getText(Object obj) {
        String result = "";

        if (isNotNull(obj)) {
            if (obj instanceof TextView) {
                TextView textView = castObject(obj);
                result = textView.getText().toString();
            } else if (obj instanceof EditText) {
                EditText editText = castObject(obj);
                result = editText.getText().toString();
            }
        }
        return result;
    }

    private void registerBroad() {
        registerReceiver(broadcastReceiver, new IntentFilter(PROGRESS));
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(PROGRESS)) {
                if (!IsFront) {
                    return;
                }

                Bundle bundle = intent.getExtras();
                if (bundle.getBoolean("state")) {
                    llLoading.setVisibility(View.VISIBLE);
                } else {
                    llLoading.setVisibility(View.GONE);
                }

            }
        }
    };

    @Override
    protected void onPause() {
        IsFront = false;
        super.onPause();
    }

    @Override
    protected void onResume() {
        IsFront = true;
        super.onResume();
    }
}
