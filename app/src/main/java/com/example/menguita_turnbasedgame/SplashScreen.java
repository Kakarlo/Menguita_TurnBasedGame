package com.example.menguita_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    //Animation
    Animation leftRight,rightLeft;
    //ImageView
    ImageView mtitle1,mtitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Removes action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash_screen);

        //Animation Call
        leftRight = AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        leftRight.setStartOffset(500);
        rightLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        rightLeft.setStartOffset(500);

        //ImageView Call
        mtitle1 = findViewById(R.id.title1);
        mtitle2 = findViewById(R.id.title2);

        //Animating
        mtitle1.setAnimation(leftRight);
        mtitle2.setAnimation(rightLeft);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        },3000);

    }
}