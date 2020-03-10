package com.robertory.stockpot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ImageView ivLogo=(ImageView)findViewById(R.id.imageView);
        Animation fade_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        ivLogo.setAnimation(fade_in);
        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,
                        LoginActivity.class));
                MainActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
