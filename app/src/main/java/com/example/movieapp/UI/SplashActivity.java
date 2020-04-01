package com.example.movieapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.UI.Movie.MainActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv = findViewById(R.id.img_splash);
        tv = findViewById(R.id.tv_splash);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytrans); // Initialization of Animation effects
        tv.startAnimation(myanim);  //Apply animation to textview
        iv.startAnimation(myanim);  //Apply Animation To Image View

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);


    }
}
