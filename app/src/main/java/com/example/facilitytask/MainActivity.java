package com.example.facilitytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.facilitytask.model.FacilityResponse;
import com.example.facilitytask.repository.FacilityResponseListener;
import com.example.facilitytask.viewmodel.MainViewModel;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private FacilityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        MainViewModel viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainViewModel.class);
        viewModel.getFacilities(new FacilityResponseListener() {
            @Override
            public void onSuccess(FacilityResponse response) {
                adapter = new FacilityAdapter(MainActivity.this, response.getFacilities());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
               Log.d(TAG, t.getMessage());
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}