package com.example.mytry32.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;
import com.example.mytry32.bean.Commodity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapter_1 extends RecyclerView.Adapter<Adapter_1.myViewHolder> {

    private Context context;
    private List<Commodity> data;

    private LayoutInflater layoutInflater;

    private List<Commodity> commodities = new ArrayList<>();
    //对每一个item保存其位置
    HashMap<Integer,View> location = new HashMap<>();


    public Adapter_1(Context context,List<Commodity> data){
        this.context = context;
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_1,parent,false));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }//data.len()


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //设置内容
        holder.tvTitle.setText(data.get(position).getTitle());//这里需要一个List<data1>  用于存放数据  Class Data1 是数据类
        holder.tvDescription.setText("商品介绍："+data.get(position).getDescription());
        holder.tvPrice.setText("价格："+data.get(position).getPrice());

        byte[] picture = data.get(position).getPicture();
        Bitmap img = BitmapFactory.decodeByteArray(picture,0,picture.length);
        holder.ivCommodity.setImageBitmap(img);

        //加入监听！！！点击跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Xq_1.class);
                //跳转如何携带信息 ， 调用position 进入相关页面！！！数据流如何！！？
                context.startActivity(intent);
            }
        });

    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCommodity;
        private TextView tvTitle,tvDescription,tvPrice;
        public myViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivCommodity = itemView.findViewById(R.id.iv_commodity);

        }
    }

}
