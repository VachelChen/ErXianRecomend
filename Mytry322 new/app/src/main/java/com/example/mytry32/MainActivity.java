package com.example.mytry32;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mytry32.ui.home.Fb_1;
import com.example.mytry32.ui.home.Fb_2;
import com.example.mytry32.ui.home.Fb_3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    int ide=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerLayout = navigationView.getHeaderView(0);

        final Bundle bundle = this.getIntent().getExtras();
        final TextView tvStuNumber = headerLayout.findViewById(R.id.daohang_username);
        String name ="";
        if (bundle != null) {
            name = bundle.getString("username");
        }
        tvStuNumber.setText(name);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleDialog();
//                Snackbar.make(view, "Replace with your own", Snackbar.LENGTH_LONG)//
//                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own", Snackbar.LENGTH_LONG)//
//                        .setAction("Action", null).show();
            }
        });



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void showSingleDialog(){

        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerLayout = navigationView.getHeaderView(0);
        final Bundle bundle = this.getIntent().getExtras();
        final TextView tvStuNumber = headerLayout.findViewById(R.id.daohang_username);
        String name ="";
        if (bundle != null) {
            name = bundle.getString("username");
        }
        tvStuNumber.setText(name);
        final String strNum = tvStuNumber.getText().toString();


        final String[] stars = {"闲置","拼单" ,"组队"};
        final AlertDialog.Builder dialog4 = new AlertDialog.Builder (this)
                .setTitle ("选择你要发布的类型:")
                //参数1：选项。参数2：默认选项。参数3：选中时的事件
                .setSingleChoiceItems (stars, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText (MainActivity.this,"你选择了："+stars[which],Toast.LENGTH_LONG).show ();
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // Toast.makeText (MainActivity.this,"你选择了："+stars[ide],Toast.LENGTH_LONG).show ();

                        if(ide==0){
                            Intent intent= new Intent(MainActivity.this , Fb_1.class);
                            if (bundle != null) {
                                //获取学生学号
                                bundle.putString("user_id", strNum);
                                intent.putExtras(bundle);
                            }
                            startActivity(intent);
                        }else if(ide==1){
                            Intent intent= new Intent(MainActivity.this , Fb_2.class);
                            if (bundle != null) {
                                //获取学生学号
                                bundle.putString("user_id", strNum);
                                intent.putExtras(bundle);
                            }
                            startActivity(intent);
                        }else{
                            Intent intent= new Intent(MainActivity.this , Fb_3.class);
                            if (bundle != null) {
                                //获取学生学号
                                bundle.putString("user_id", strNum);
                                intent.putExtras(bundle);
                            }
                            startActivity(intent);
                        }

                        //

                    }
                });   //点击确定后对话框消失，并且打印所选内容

        dialog4.show ();
    }
}
