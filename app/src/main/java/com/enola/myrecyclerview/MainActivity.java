package com.enola.myrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.enola.myrecyclerview.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<String> items = List.of("One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecycler();
    }

    private void initRecycler() {
        MainAdapter mainAdapter = new MainAdapter();
        mainAdapter.setItems(items);

        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
    //    binding.rvItems.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        binding.rvItems.setAdapter(mainAdapter);

    }
}