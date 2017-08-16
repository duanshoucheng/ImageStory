package com.shoucheng.imagestory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;
    private  HomeFragment mHomeFragment;
    private  CircleFragment mCircleFragment;
    private  SettingFragment mSettingFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTabSelection(0);
                    return true;
                case R.id.navigation_dashboard:
                    setTabSelection(1);
                    return true;
                case R.id.navigation_notifications:
                    setTabSelection(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragment();
        setTabSelection(0);
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mCircleFragment = new CircleFragment();
        mSettingFragment = new SettingFragment();

        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.add(R.id.content, mHomeFragment, "home").hide(mHomeFragment);
        mTransaction.add(R.id.content, mCircleFragment, "circle").hide(mCircleFragment);
        mTransaction.add(R.id.content, mSettingFragment, "setting").hide(mSettingFragment);

        mTransaction.commitAllowingStateLoss();
    }

    public void setTabSelection(int index) {
        mTransaction = mFragmentManager.beginTransaction();
        hideFragments(mTransaction);
        switch (index) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    mTransaction.add(R.id.container, mHomeFragment);
                } else {
                    mTransaction.show(mHomeFragment);
                }

                break;
            case 1:
                if (mCircleFragment == null) {
                    mCircleFragment = new CircleFragment();
                    mTransaction.add(R.id.container, mCircleFragment);
                } else {
                    mTransaction.show(mCircleFragment);
                }
                break;
            case 2:
                if (mSettingFragment == null) {
                    mSettingFragment = new SettingFragment();
                    mTransaction.add(R.id.container, mSettingFragment);
                } else {
                    mTransaction.show(mSettingFragment);
                }
                break;
        }
        mTransaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mCircleFragment != null) {
            transaction.hide(mCircleFragment);
        }
        if (mSettingFragment != null) {
            transaction.hide(mSettingFragment);
        }
    }
}
