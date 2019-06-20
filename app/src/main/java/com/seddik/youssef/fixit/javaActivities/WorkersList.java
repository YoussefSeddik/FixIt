package com.seddik.youssef.fixit.javaActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import com.seddik.youssef.fixit.Apicall;
import com.seddik.youssef.fixit.R;
import com.seddik.youssef.fixit.RetrofitInstance;
import com.seddik.youssef.fixit.modelClasses.WorkerClass;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class WorkersList extends AppCompatActivity {
    public RecyclerView recyclerView;
    public Apicall apiCalls;
    public RecyclerAdapter recyclerAdapter;
    List<WorkerClass> workers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers_list);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(WorkersList.this));
        recyclerView.setHasFixedSize(true);


        apiCalls = RetrofitInstance.getRetrofitInstance().create(Apicall.class);
        retrofit2.Call<List<WorkerClass>> call = apiCalls.getWorkers();

        call.enqueue(new Callback<List<WorkerClass>>() {
            @Override
            public void onResponse(retrofit2.Call<List<WorkerClass>> call, Response<List<WorkerClass>> response) {
                workers = response.body();
                recyclerAdapter = new RecyclerAdapter(workers,WorkersList.this);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<WorkerClass>> call, Throwable t) {

            }
        });
    }
}
