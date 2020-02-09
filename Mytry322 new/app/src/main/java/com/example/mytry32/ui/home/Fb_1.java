package com.example.mytry32.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytry32.R;
import com.example.mytry32.bean.Commodity;
import com.example.mytry32.util.CommodityDbHelper;

import java.io.ByteArrayOutputStream;

/**
 * 物品发布界面Activity类
 * @author : autumn_leaf
 */
public class Fb_1 extends AppCompatActivity {

    TextView tvStuId;
    ImageView ivPhoto;
    EditText etTitle,etPrice,etPhone,etDescription;
    String spType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_1);
        //选照片
        Button btnBack = findViewById(R.id.btn_back);
        //返回按钮点击事件
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivPhoto = findViewById(R.id.iv_photo);
        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,1);
            }
        });
        tvStuId = findViewById(R.id.tv_student_id);
        final Bundle bundle = this.getIntent().getExtras();
        tvStuId.setText(bundle.getString("username"));
        etTitle = findViewById(R.id.fb_bt1);
        etPrice = findViewById(R.id.fb_jiage1);
        etPhone = findViewById(R.id.fb_lianxifangshi1);
        etDescription = findViewById(R.id.editText17);
        spType = "闲置";
        Button btnPublish = findViewById(R.id.submit2);
        //发布按钮点击事件
        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先检查合法性
                if(CheckInput()) {
                    CommodityDbHelper dbHelper = new CommodityDbHelper(getApplicationContext(), CommodityDbHelper.DB_NAME, null, 1);
                    Commodity commodity = new Commodity();
                    //把图片先转化成bitmap格式
                    BitmapDrawable drawable = (BitmapDrawable) ivPhoto.getDrawable();
                    Bitmap bitmap = drawable.getBitmap();
                    //二进制数组输出流
                    ByteArrayOutputStream byStream = new ByteArrayOutputStream();
                    //将图片压缩成质量为100的PNG格式图片
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byStream);
                    //把输出流转换为二进制数组
                    byte[] byteArray = byStream.toByteArray();
                    commodity.setPicture(byteArray);
                    commodity.setTitle(etTitle.getText().toString());
                    commodity.setCategory(spType);
                    commodity.setPrice(etPrice.getText().toString());
                    commodity.setPhone(etPhone.getText().toString());
                    commodity.setStuId(tvStuId.getText().toString());
                    commodity.setDescription(etDescription.getText().toString());
                    if (dbHelper.AddCommodity(commodity)) {
                        Toast.makeText(getApplicationContext(), "商品信息发布成功!", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "商品信息发布失败!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1) {
            //从相册返回的数据
            if (data != null) {
                //得到图片的全路径
                Uri uri = data.getData();
                ivPhoto.setImageURI(uri);
            }
        }
    }

    /**
     * 检查输入是否合法
     */
    public boolean CheckInput() {
        String title = etTitle.getText().toString();
        String price = etPrice.getText().toString();
        String phone = etPhone.getText().toString();
        String description = etDescription.getText().toString();
        if (title.trim().equals("")) {
            Toast.makeText(this,"商品标题不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (price.trim().equals("")) {
            Toast.makeText(this,"商品价格不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phone.trim().equals("")) {
            Toast.makeText(this,"联系方式不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (description.trim().equals("")) {
            Toast.makeText(this,"商品描述不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
