package com.seddik.youssef.fixit.javaActivities;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seddik.youssef.fixit.R;
import com.seddik.youssef.fixit.modelClasses.WorkerClass;

import java.util.List;

/**
 * Created by youssef on 6/7/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
      public List<WorkerClass> workers;
     public  Context context;
    public RecyclerAdapter(List<WorkerClass> workers, Context context) {

        this.workers=workers;
        this.context=context;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view=LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
    return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_name.setText(workers.get(position).get_Name());
        holder.text_prof.setText(workers.get(position).get_Prof());


    }

    @Override
    public int getItemCount() {
        return workers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text_prof,text_name;
        ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.text_name);
            text_prof = itemView.findViewById(R.id.text_prof);
            imageView = itemView.findViewById(R.id.work_image);
        }
    }
}
