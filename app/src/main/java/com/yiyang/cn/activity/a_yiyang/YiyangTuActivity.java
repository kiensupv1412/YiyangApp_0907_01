package com.yiyang.cn.activity.a_yiyang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.yiyang.cn.R;
import com.yiyang.cn.app.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YiyangTuActivity extends BaseActivity {

    @BindView(R.id.iv_yiyang_tu)
    ImageView ivYiyangTu;

    @Override
    public int getContentViewResId() {
        return R.layout.a_ayiyang;
    }


    @Override
    public void initImmersion() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.init();
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        tv_title.setTextSize(17);
        tv_title.setTextColor(getResources().getColor(R.color.black));
        mToolbar.setNavigationIcon(R.mipmap.backbutton);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imm.hideSoftInputFromWindow(findViewById(R.id.cl_layout).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                finish();
            }
        });
    }

    @Override
    public boolean showToolBar() {
        return true;
    }

    /**
     * 用于其他Activty跳转到该Activity
     */
    public static void actionStart(Context context, String title, int imgId) {
        Intent intent = new Intent(context, YiyangTuActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("imgId", imgId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        String title = getIntent().getStringExtra("title");
        tv_title.setText(title);
        int imgId = getIntent().getIntExtra("imgId", 0);
        ivYiyangTu.setImageResource(imgId);
    }
}