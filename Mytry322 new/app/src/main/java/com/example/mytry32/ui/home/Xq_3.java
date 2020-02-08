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

public class Xq_3 extends AppCompatActivity {

    private Button commit=null;
    private TextView title=null;
    private TextView sm=null;
    private TextView ry=null;
    private  TextView time=null;
    private TextView fbr=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq_3);
        getSupportActionBar().setTitle("详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

        commit = findViewById(R.id.butt1);
        title=findViewById(R.id.title1);
        sm=findViewById(R.id.sm1);
        ry=findViewById(R.id.ryyq);
        time=findViewById(R.id.time1);
        fbr=findViewById(R.id.fbr1);

        //下面进行数据初始化！！ 我这里先编一个
        title.setText("全国大学生程序设计竞赛蓝桥杯组队");
        sm.setText("2020年蓝桥杯程序设计团队赛组队，现有一个森林人的物联网项目，项目中已有成员3人均来自信息学院，需要一名艺术学院的大佬来做美工");
        ry.setText("需要一名艺术设计学院或有美工能力的大佬");
        time.setText("2020/1/20");


        fbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText (Xq_3.this,"转去发布人个人信息页面",Toast.LENGTH_LONG).show ();
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {//监听
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Xq_3.this);
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
