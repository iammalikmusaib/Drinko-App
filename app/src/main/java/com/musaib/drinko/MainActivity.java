package com.musaib.drinko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.musaib.drinko.Adapters.MainAdapter;
import com.musaib.drinko.Modals.MainModal;
import com.musaib.drinko.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModal> list = new ArrayList<>();
        list.add(new MainModal(R.drawable.bottle, "Bottle Small" , "10" , "Order Water Bottle of Volume 1 Litre"));
        list.add(new MainModal(R.drawable.bottlebig, "Bottle Big" ,"20"  , "Water Bottles Half Litre"));
        list.add(new MainModal(R.drawable.cans, "Cans" , "150" , "Get a Big 6L of Water Can"));
        list.add(new MainModal(R.drawable.combo, "Combo" , "200" , "Both Water Bottle and Cans in a combo package"));
        list.add(new MainModal(R.drawable.tanker, "Water Tank" , "2000" , "Big Water Supply Tank"));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                Intent intent = new Intent(MainActivity.this , OrderActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}