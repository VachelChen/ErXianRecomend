package com.example.mytry32.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;

public class Adapter_1 extends RecyclerView.Adapter<Adapter_1.myViewHolder> {

    private Context context;



    public Adapter_1(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //设置内容
        holder.tv.setText("闲置出售样例    "+ (position+1) );//这里需要一个List<data1>  用于存放数据  Class Data1 是数据类
        holder.tvx.setText("闲置详情    "+ (position+1) );

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

    @Override
    public int getItemCount() {
        return 5;
    }//data.len()

    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private TextView tvx;
        private ImageView tp;
        public myViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.first_item_tv);
            tvx = itemView.findViewById(R.id.first_item_tvx);
            tp= itemView.findViewById(R.id.lst);

        }
    }
}
