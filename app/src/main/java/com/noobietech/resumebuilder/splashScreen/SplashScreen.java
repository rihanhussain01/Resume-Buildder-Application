package com.noobietech.resumebuilder.splashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noobietech.resumebuilder.MainActivity;
import com.noobietech.resumebuilder.R;
import com.noobietech.resumebuilder.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    CardView cardView;
    ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreen.this , R.color.grey));
        getWindow().setNavigationBarColor(ContextCompat.getColor(SplashScreen.this , R.color.grey));

        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashScreen.this , MainActivity.class));
                finish();
            }
        });



    }
}