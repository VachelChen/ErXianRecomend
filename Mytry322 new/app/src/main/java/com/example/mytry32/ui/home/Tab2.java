package com.example.mytry32.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2 extends Fragment {


    public Tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView=null;
        View vv=inflater.inflate(R.layout.layout2, container, false);
        recyclerView = (RecyclerView) vv.findViewById(R.id.recycler_2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//本来是this 但是framgment没有this

        Adapter_2 adapter_2 = new Adapter_2(getContext());//还没有传参数！！！
        recyclerView.setAdapter(adapter_2);
        return vv;
    }

}