package com.example.mytry32.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytry32.R;

public class Xq_2 extends AppCompatActivity {

    private TextView title=null;
    private TextView sm=null;
    private TextView rs=null;
    private TextView sj=null;
    private TextView dd=null;
    private Button pin =null;
    private TextView fbr=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq_2);
        getSupportActionBar().setTitle("详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

        title=findViewById(R.id.title2);
        sm=findViewById(R.id.sm2);
        rs=findViewById(R.id.mbrs);
         sj=findViewById(R.id.tim2);
       dd=findViewById(R.id.loc);
       pin=findViewById(R.id.butt2);
       fbr=findViewById(R.id.fbr2);
//
        title.setText("来拼COCO呀！");
        sm.setText("我下午想喝CoCo");
        rs.setText("1");
        sj.setText("下午5点前");
        dd.setText("12号楼");

        fbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText (Xq_2.this,"转去发布人个人信息页面",Toast.LENGTH_LONG).show ();
            }
        });

        pin.setOnClickListener(new View.OnClickListener() {//监听
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Xq_2.this);
                //获取AlertDialog对象
                dialog.setTitle("请尽快联系哦");//设置标题
                dialog.setMessage("对方联系方式："+"18210774540");//设置信息具体内容
                dialog.setCancelable(false);//设置是否可取消
                dialog.setPositiveButton("复制", new DialogInterface.OnClickListener() {
                    @Override//设置ok的事件
                    public void onClick(DialogInterface dialogInterface, int i) {//复制到剪贴板
                        //在此处写入ok的逻辑
                    }
                });
                AlertDialog alertdialog1=dialog.create(); alertdialog1.show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
