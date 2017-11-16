package com.team1.caro.minigamecaro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.team1.caro.minigamecaro.R;

/**
 * CSIT 5510 (L1)
 * CHENG Mingxin, 20387442, mchengaa@connect.ust.hk
 * CHEN Kangle, 20403480, kchenam@connect.ust.hk
 * WANG Ziwei, 20402072, zwangcp@connect.ust.hk
 */

/**
 * Created by chengmx on 2016/11/12.
 */

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button settingButton;
    private Button ruleButton;
    private Button playAIButton;
    private Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.newGameButton);//sai
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SingleGameActivity.class);
                //startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        playAIButton = (Button) findViewById(R.id.newGameButton);//sai
        playAIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AIGameActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        profileButton = (Button) findViewById(R.id.newGameButton);//sai
        profileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        settingButton = (Button) findViewById(R.id.newGameButton);//sai
        settingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        ruleButton = (Button) findViewById(R.id.newGameButton);//sai
        ruleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameRuleActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}