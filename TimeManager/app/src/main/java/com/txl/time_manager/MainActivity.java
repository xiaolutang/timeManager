package com.txl.time_manager;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.txl.time_manager.base.BaseActivity;
import com.txl.time_manager.time.statistics.TimeStatisticsFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = MainActivity.class.getSimpleName();


    private TimeStatisticsFragment statisticsFragment;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        initView();
        setStatusBarColor( R.color.solar_background );
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    private void initView(){
        fragmentManager = getSupportFragmentManager();
        statisticsFragment = (TimeStatisticsFragment) fragmentManager.findFragmentById( R.id.fragment_TimeStatistics );
        radioGroup = (RadioGroup) findViewById( R.id.radio_group );
        radioGroup.setOnCheckedChangeListener( this );
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        Log.d( TAG,"onCheckedChanged  id:"+checkedId );
        switch (checkedId){
            case R.id.rb_time_statistics:
                Log.d( TAG,"onCheckedChanged  id: rb_time_statistics");
        }
    }
}
