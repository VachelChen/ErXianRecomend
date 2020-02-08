package com.example.mytry32.ui.gallery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytry32.R;

import java.util.ArrayList;
import java.util.List;

public class MyobjectFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myobject, container, false);

        ListView listView=(ListView)root.findViewById(R.id.myitems);

        //从相应数据类抽取的数据！！！
        List<String> list = new ArrayList<String>();
        list.add("闲置：闲置出售样例 1");//测试样例
        list.add("闲置：闲置出售样例 2");
        list.add("拼拼：品奶茶");
        list.add("组队：大学生创新创业比赛");
        ///可以一直添加，在真机运行后可以下拉列表

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText (getContext(),position+"你选择了："+id,Toast.LENGTH_LONG).show ();
               showNormalDialog1(position);//弹出对话框！！
           }
       } );

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


        return root;
    }

    private void showNormalDialog1(int pos) {
        AlertDialog.Builder dialog = new AlertDialog.Builder (getContext());
        dialog.setMessage ("要撤回发布嘛？");
        dialog.setPositiveButton ("确定", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //业务处理！！！
            }
        });
        //如果取消，就什么都不做，关闭对话框
        dialog.setNegativeButton ("取消",null);
        dialog.show ();
    }
}