package com.example.recyclerviewfeature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button buttonYugi;
    Button buttonJoey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_home);

        buttonYugi = findViewById(R.id.buttonYugiCards);
        buttonJoey = findViewById(R.id.buttonJoeyCards);

        buttonYugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYugiCardActivity();
            }
        });

        buttonJoey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoeyCardActivity();
            }
        });

    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }

    public void openYugiCardActivity() {
        Intent intent = new Intent(this, YugiCardActivity.class);
        startActivity(intent);
    }

    public void openJoeyCardActivity() {
        Intent intent = new Intent(this, JoeyCardActivity.class);
        startActivity(intent);
    }

}