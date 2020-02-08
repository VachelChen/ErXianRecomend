package com.example.mytry32.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;

public class Adapter_2 extends RecyclerView.Adapter<Adapter_2.myViewHolder> {

    private Context context;


    public Adapter_2(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public Adapter_2.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Adapter_2.myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_2.myViewHolder holder, int position) {
        //设置内容
        holder.tv.setText("拼奶茶");
        holder.date2.setText("截止 ："+"永久有效");
        holder.tp.setImageResource(R.mipmap.nc);
        holder.po.setMax(10);
        holder.po.setProgress(5);
        //加入监听！！！点击跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Xq_2.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;//data.lenth
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private TextView tvx;
        private ImageView tp;
        private TextView date2;
        private ProgressBar po;

        public myViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.second_item_tv);
            tvx = itemView.findViewById(R.id.second_item_tvx);
            tp= itemView.findViewById(R.id.lst2);
            date2=itemView.findViewById(R.id.date2);
            po=itemView.findViewById(R.id.progressBar2);
        }
    }
}