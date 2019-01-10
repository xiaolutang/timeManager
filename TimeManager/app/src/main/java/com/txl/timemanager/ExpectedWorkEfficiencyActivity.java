package com.txl.timemanager;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.txl.time_manager.R;
import com.txl.timemanager.base.BaseActivity;
import com.txl.timemanager.data.WorkData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/9/14
 * description：预计工作效率设计界面
 */

public class ExpectedWorkEfficiencyActivity extends BaseActivity implements NumberPicker.OnValueChangeListener, View.OnClickListener {

    private final int total = 100;
    private int efficientTime;
    private int wasteTime;
    private int restTime;

    private WorkData workData;

    @BindView( R.id.np_efficient_time )
    NumberPicker efficientTimeView;
    @BindView( R.id.np_waste_time )
    NumberPicker wasteTimeView;
    @BindView( R.id.np_rest_time )
    NumberPicker restTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        ButterKnife.bind( this );
        initViews();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_expected_work_efficiency;
    }

    private void initViews() {
        efficientTimeView.setMaxValue( 100 );
        efficientTimeView.setOnValueChangedListener( this );
        efficientTimeView.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        wasteTimeView.setMaxValue( 100 );
        wasteTimeView.setOnValueChangedListener( this );
        wasteTimeView.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        restTimeView.setMaxValue( 100 );
        restTimeView.setOnValueChangedListener( this );
        restTimeView.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        switch (picker.getId()){
            case R.id.np_efficient_time:
                efficientTime = newVal;
                if(total-newVal -wasteTime > 0){
                    restTimeView.setValue( total-newVal -wasteTime);
                }else {
                    restTimeView.setValue( 0);
                }
                break;
            case R.id.np_waste_time:
                wasteTime = newVal;
                if(total > (efficientTime+wasteTime)){
                    restTimeView.setValue( total-efficientTime-wasteTime );
                }else {
                    restTimeView.setValue( 0 );
                }
                break;
            case R.id.np_rest_time:
                restTime = newVal;
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
    }



    @Override
    public void onClick(View v) {
        int count = efficientTime + wasteTime + restTime;
        if( count > total){
            Toast.makeText( this,"当前总的百分比为100，您的设计不合理请重新设置", Toast.LENGTH_SHORT ).show();
            return;
        }
        workData  = new WorkData();
        workData.setRestTime( restTime );
        workData.setWorkTime( efficientTime );
        workData.setWasteTime( wasteTime );
        Intent intent = new Intent(  );
        intent.putExtra( "workEfficiency", (Parcelable) workData );
        setResult( 1,intent );
        finish();
    }
}
