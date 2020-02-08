package com.example.mytry32.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytry32.R;

public class Xq_1 extends AppCompatActivity {

    private Button connect=null;
    private TextView title=null;
    private TextView sm=null;
    private ImageView image1=null;
    private ImageView image2=null;
    private ImageView image3=null;
    private ImageView image4=null;
    private ImageView image5=null;
    private TextView fbr=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq_1);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle("详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        title=findViewById(R.id.title3);
        connect = findViewById(R.id.butt3);
        fbr=findViewById(R.id.fbr3);
        sm=findViewById(R.id.sm3);

        //从intent和相关数据类获取相关数据！！！！！
        title.setText("     "+"出售闲置索尼耳机100 Abn   8成新");
        sm.setText("     "+"出售闲置索尼耳机100 Abn   8成新，去年11月购买，很好用。1900购入，现在由于要换新耳机，出售500r");
        image1.setImageResource(R.mipmap.erji);
        //fbr.setText("");  //发布人
        fbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText (Xq_1.this,"转去发布人个人信息页面",Toast.LENGTH_LONG).show ();
                //这里跳转界面！！少一个静态界面，秒秒钟
            }
        });

       connect.setOnClickListener(new View.OnClickListener() {//监听
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Xq_1.this);
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
