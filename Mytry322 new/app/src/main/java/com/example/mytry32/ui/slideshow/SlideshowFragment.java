package com.example.mytry32.ui.slideshow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytry32.R;
import com.example.mytry32.adapter.MyCollectionAdapter;
import com.example.mytry32.bean.Collection;
import com.example.mytry32.using;
import com.example.mytry32.util.MyCollectionDbHelper;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    ListView lvMyCollection;
    List<Collection> myCollections = new ArrayList<>();
    TextView tvStuId;

    MyCollectionDbHelper dbHelper;
    //CommodityDbHelper commodityDbHelper;
    MyCollectionAdapter adapter;

    String name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        name= using.userid;

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvStuId = getView().findViewById(R.id.tv_stuId);
        tvStuId.setText(name);
        lvMyCollection = getView().findViewById(R.id.lv_my_collection);
        dbHelper = new MyCollectionDbHelper(getContext(),MyCollectionDbHelper.DB_NAME,null,1);
        myCollections = dbHelper.readMyCollections(tvStuId.getText().toString());
        adapter = new MyCollectionAdapter(getContext());
        adapter.setData(myCollections);
        lvMyCollection.setAdapter(adapter);
        //设置长按删除事件
        lvMyCollection.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("提示:").setMessage("确定删除此收藏商品吗?").setIcon(R.drawable.icon_user).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Collection collection = (Collection) adapter.getItem(position);
                        //删除收藏商品项
                        dbHelper.deleteMyCollection(collection.getTitle(),collection.getDescription(),collection.getPrice());
                        Toast.makeText(getActivity(),"删除成功!",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                return false;
            }
        });
    }
}