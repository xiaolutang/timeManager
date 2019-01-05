package com.txl.timemanager.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/9/14
 * description：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        initWindow();
        setContentView( getLayoutResId() );
    }

    private void initWindow() {
        if(isFullScreen()){
            setFullScreen();
        }
        if(!showActionBar()){
            hideActionBar();
        }
    }

    private void setFullScreen() {
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected abstract int getLayoutResId();

    protected boolean isFullScreen(){
        return false;
    }

    protected boolean showActionBar(){
        return false;
    }

    protected void setStatusBarColor(int colorResId){
        if(Build.VERSION.SDK_INT >21){
            getWindow().setStatusBarColor(getResources().getColor( colorResId));
        }
    }

    protected void hideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
