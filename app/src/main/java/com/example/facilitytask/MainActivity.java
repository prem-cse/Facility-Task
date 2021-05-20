package com.example.facilitytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.facilitytask.model.Facility;
import com.example.facilitytask.model.FacilityResponse;
import com.example.facilitytask.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FacilityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        FacilityResponse response = viewModel.getFacilities();
        Toast.makeText(this, response.getFacilities().size() > 0 ? "true":"false",Toast.LENGTH_LONG).show();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FacilityAdapter(this, response.getFacilities());
        recyclerView.setAdapter(adapter);
    }
}