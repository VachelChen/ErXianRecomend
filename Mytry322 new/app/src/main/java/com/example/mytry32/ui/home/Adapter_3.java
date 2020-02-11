package com.example.mytry32.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;
import com.example.mytry32.bean.Commodity;
import com.example.mytry32.using;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapter_3 extends RecyclerView.Adapter<Adapter_3.myViewHolder> {

    private Context context;
    private List<Commodity> data;

    private LayoutInflater layoutInflater;

    private List<Commodity> commodities = new ArrayList<>();
    //对每一个item保存其位置
    HashMap<Integer,View> location = new HashMap<>();


    public Adapter_3(Context context,List<Commodity> data){
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
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_3,parent,false));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }//data.len()


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder,final int position) {
        //设置内容
        holder.tvTitle.setText(data.get(position).getTitle());//这里需要一个List<data1>  用于存放数据  Class Data1 是数据类
        holder.tvDescription.setText("队伍情况："+data.get(position).getDescription());
        holder.tvPrice.setText("比赛时间："+data.get(position).getPrice());

        byte[] picture = data.get(position).getPicture();
        Bitmap img = BitmapFactory.decodeByteArray(picture,0,picture.length);
        holder.ivCommodity.setImageBitmap(img);

        //加入监听！！！点击跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("position",position);
                bundle3.putByteArray("picture",data.get(position).getPicture());
                bundle3.putString("title",data.get(position).getTitle());
                bundle3.putString("description",data.get(position).getDescription());
                bundle3.putString("price",data.get(position).getPrice());
                bundle3.putString("phone",data.get(position).getPhone());
                bundle3.putString("stuId", using.userid);
                Intent intent=new Intent(context, Xq_3.class);
                intent.putExtras(bundle3);
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
