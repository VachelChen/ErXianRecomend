package com.example.mytry32.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;
import com.example.mytry32.adapter.AllCommodityAdapter;
import com.example.mytry32.bean.Commodity;
import com.example.mytry32.util.CommodityDbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {

    public Tab1() {
        // Required empty public constructor
    }

    //private List<Commodity> data;
    ListView lvAllCommodity;
    List<Commodity> allCommodities = new ArrayList<>();
    ImageButton ibLearning,ibElectronic,ibDaily,ibSports;

    CommodityDbHelper dbHelper;
    AllCommodityAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView recyclerView=null;
        View vv=inflater.inflate(R.layout.layout1, container, false);
        recyclerView = (RecyclerView) vv.findViewById(R.id.recycler_1);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//本来是this 但是framgment没有this
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dbHelper = new CommodityDbHelper(getContext(), CommodityDbHelper.DB_NAME, null, 1);
        allCommodities = dbHelper.readCommodityType("闲置");


        Adapter_1 adapter_1 = new Adapter_1(getContext(),allCommodities);//还没有传参数！！！
        recyclerView.setAdapter(adapter_1);
        return vv;
    }

}