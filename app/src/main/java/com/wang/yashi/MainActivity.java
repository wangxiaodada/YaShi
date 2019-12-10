package com.wang.yashi;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wang.yashi.Gson.LoadJson;
import com.wang.yashi.Gson.Navigator;
import com.wang.yashi.fragment.FuJinFragment;
import com.wang.yashi.fragment.JiaHaoFragment;
import com.wang.yashi.fragment.ShouYeFragment;
import com.wang.yashi.fragment.WoDeFragment;
import com.wang.yashi.fragment.XiaoXiFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    private ShouYeFragment mShouYeFragment;
    private FuJinFragment mFuJinFragment;
    private JiaHaoFragment mJiaHaoFragment;
    private XiaoXiFragment mXiaoXiFragment;
    private WoDeFragment mWoDeFragment;
    private Fragment[] mFragments;
    private int lastShowFragment;
    private List<Navigator> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                        .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ys_bottombar_shouye:
                        if (lastShowFragment != 0){
                            switchFrament(lastShowFragment,0);
                            lastShowFragment = 0;
                        }
                        return true;
                    case R.id.ys_bottombar_fujin:
                        if (lastShowFragment != 1){
                            switchFrament(lastShowFragment,1);
                            lastShowFragment = 1;
                        }
                        return true;
                    case R.id.ys_bottombar_jiahao:
                        if (lastShowFragment != 2){
                            switchFrament(lastShowFragment,2);
                            lastShowFragment = 2;
                        }
                        return true;
                    case R.id.ys_bottombar_xiaoxi:
                        if (lastShowFragment != 3){
                            switchFrament(lastShowFragment,3);
                            lastShowFragment = 3;
                        }
                        return true;
                    case R.id.ys_bottombar_wode:
                        if (lastShowFragment != 4){
                            switchFrament(lastShowFragment,4);
                            lastShowFragment = 4;
                        }
                        return true;
                }

                return false;
            }
        });


    }
    public void switchFrament(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments[lastIndex]);
        if (!mFragments[index].isAdded()) {
            transaction.add(R.id.main_fragment_layout, mFragments[index]);
        }
        transaction.show(mFragments[index]).commitAllowingStateLoss();
    }

    private void init(){
        mBottomNavigationView = findViewById(R.id.bottom_menu);
        mShouYeFragment = new ShouYeFragment();
        mFuJinFragment = new FuJinFragment();
        mJiaHaoFragment = new JiaHaoFragment();
        mXiaoXiFragment = new XiaoXiFragment();
        mWoDeFragment = new WoDeFragment();
        mFragments = new Fragment[]{mShouYeFragment,mFuJinFragment,mJiaHaoFragment,mXiaoXiFragment,mWoDeFragment};
        lastShowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment_layout,mShouYeFragment)
                .show(mShouYeFragment)
                .commit();
//        LoadJson loadJson = new LoadJson(this);
//        this.data = loadJson.getNavigator("title.json");
//
//        Bundle bundle = new Bundle();
//        bundle.putStringArrayList(this,data);
    }
}

