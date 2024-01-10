package com.DKSoftware.BeFit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Animation up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splashLogo);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);

        textView = findViewById(R.id.splashTxt);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        },3500);
    }
}