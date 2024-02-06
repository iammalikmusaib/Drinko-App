package com.musaib.drinko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.musaib.drinko.Adapters.OrderAdapter;
import com.musaib.drinko.Modals.OrderModal;
import com.musaib.drinko.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper = new DBHelper(this);

        ArrayList<OrderModal> list = helper.getOrder();

        OrderAdapter  adapter = new OrderAdapter(list, this);
        binding.orderrecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderrecyclerview.setLayoutManager(layoutManager);
    }
}