package com.example.top_bottomnav;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.top_bottomnav.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        DrawerLayout drawerLayout=findViewById(R.id.main);
        ImageView imageView=findViewById(R.id.nav_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer((GravityCompat.START));
            }
        });
        NavigationView navigationView=findViewById(R.id.slider);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.item1){
                    Toast.makeText(MainActivity.this, "Click Item 1", Toast.LENGTH_SHORT).show();
                }
                if (id==R.id.item2){
                    Toast.makeText(MainActivity.this, "Click Item 2", Toast.LENGTH_SHORT).show();
                }
                if (id==R.id.item3){
                    Toast.makeText(MainActivity.this, "Click Item 3", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int value=item.getItemId();
                if (value==R.id.home){
                    ReplaceTab(new HomeFragment());
                } else if (value==R.id.classes){
                    ReplaceTab(new ClassFragment());
                } else if (value==R.id.group) {
                    ReplaceTab(new GroupsFragment());
                }
                return false;
            }
        });
    }
    private void ReplaceTab(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}