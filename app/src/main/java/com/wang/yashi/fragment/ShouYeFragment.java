package com.wang.yashi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wang.yashi.Gson.LoadJson;
import com.wang.yashi.Gson.Navigator;
import com.wang.yashi.R;

import java.util.List;

public class ShouYeFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Navigator> data;
    private String[] mStrings = {"推荐","科技","游戏","影视","体育","搞笑"};


    public static ShouYeFragment newInstance(){
        return new ShouYeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setBackgroundResource(R.color.lightPink);
        init();
        View view = inflater.inflate(R.layout.shouye_fragment,container,false);
        mTabLayout = view.findViewById(R.id.shouye_tab);
        mViewPager = view.findViewById(R.id.shouye_view);
        for (int i = 0; i < mStrings.length; i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(mStrings[i]));
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        


        return view;
    }

    private void init(){
//        LoadJson loadJson = new LoadJson(this);
//        this.data = loadJson.getNavigator("title.json");
    }

}
