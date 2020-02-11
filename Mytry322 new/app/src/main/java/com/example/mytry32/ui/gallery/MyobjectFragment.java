package com.example.mytry32.ui.gallery;

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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytry32.R;
import com.example.mytry32.adapter.MyCommodityAdapter;
import com.example.mytry32.bean.Commodity;
import com.example.mytry32.using;
import com.example.mytry32.util.CommodityDbHelper;

import java.util.ArrayList;
import java.util.List;

public class MyobjectFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    ListView lvMyCommodity;
    List<Commodity> myCommodities = new ArrayList<>();
    TextView tvStuId;

    CommodityDbHelper dbHelper;

    MyCommodityAdapter adapter;

    String name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myobject, container, false);

        name= using.userid;

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvStuId = getView().findViewById(R.id.tv_stu_id);
        tvStuId.setText(name);
        lvMyCommodity = getView().findViewById(R.id.lv_my_commodity);
        adapter = new MyCommodityAdapter(getContext());
        dbHelper = new CommodityDbHelper(getContext(),CommodityDbHelper.DB_NAME,null,1);
        myCommodities = dbHelper.readMyCommodities(tvStuId.getText().toString());
        adapter.setData(myCommodities);
        lvMyCommodity.setAdapter(adapter);
        //长按点击事件
        lvMyCommodity.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //注意,这里的content不能写getApplicationContent();
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("提示:").setMessage("确认删除此商品项吗?").setIcon(R.drawable.icon_user).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //根据商品名称,商品描述和价格执行删除操作
                        Commodity commodity = (Commodity) adapter.getItem(position);
                        dbHelper.deleteMyCommodity(commodity.getTitle(),commodity.getDescription(),commodity.getPrice());
                        //数据一样,可以直接用,关联删除
                        //dbHelper2.deleteMyCollection(commodity.getTitle(),commodity.getDescription(),commodity.getPrice());
                        Toast.makeText(getActivity(),"删除成功!",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                return false;
            }
        });

    }
}