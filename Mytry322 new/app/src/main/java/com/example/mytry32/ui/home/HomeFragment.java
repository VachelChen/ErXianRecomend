package com.example.mytry32.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mytry32.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment implements TabLayout.OnTabSelectedListener{

    private HomeViewModel homeViewModel;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> mTitle ;
    private List<Fragment> mFragment ;
    private  Tab1 t1 =new Tab1();
    private Tab2 t2 = new Tab2();
    private Tab3 t3 = new Tab3();

    private boolean isGetData = false;

    public View onCreateView(LayoutInflater inflater,
                             @NonNull ViewGroup container,@NonNull  Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);

           View root = inflater.inflate(R.layout.fragment_home, container, false);

           if(!isGetData) {
               mTitle = new ArrayList<>();
               mFragment = new ArrayList<>();

               tabLayout = root.findViewById(R.id.tableLayout);
               viewPager = root.findViewById(R.id.viewPager);

               mFragment.add(t1);
               mFragment.add(t2);
               mFragment.add(t3);


               mTitle.add("闲置");
               mTitle.add("拼单");
               mTitle.add("组队");


               MyAdapter adapter = new MyAdapter(getChildFragmentManager(), mTitle, mFragment);

               viewPager.setAdapter(adapter);

               viewPager.setCurrentItem(0);
               //为TabLayout设置ViewPager
               tabLayout.setupWithViewPager(viewPager);

               // 使用ViewPager的适配器
               tabLayout.setTabsFromPagerAdapter(adapter);
           }
           else{
               isGetData = false;
           }


        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}