package com.example.mytry32.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytry32.R;

public class Adapter_3 extends RecyclerView.Adapter<Adapter_3.myViewHolder> {

    private Context context;


    public Adapter_3(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public Adapter_3.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Adapter_3.myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_3,parent,false));
    }



    @Override
    public void onBindViewHolder(@NonNull Adapter_3.myViewHolder holder, int position) {
        //设置内容
        if(position<3){
            holder.tv.setText("全美数学建模比赛");
            holder.tvx.setText("现有两名数学专业17级队员，求一位信息学院大佬！！！！！！");

        }
        else if( position<6){
            holder.tv.setText("大学生创新创业比赛");
        }
        else{
            holder.tv.setText("共享杯组队");
        }
        holder.date3.setText("截至日期: "+ "12月21日");
        //加入监听！！！点击跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Xq_3.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;//data.lenth
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private TextView tvx;
        private TextView date3;
        public myViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.thir_item_tv);
            tvx = itemView.findViewById(R.id.thir_item_tvx);
            date3=itemView.findViewById(R.id.date3);
        }
    }
}