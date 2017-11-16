package com.team1.caro.minigamecaro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class NickNameActivity extends Activity {
    private ImageView btnSendData;
    private EditText edtNickname;
    public static final String NICKNAME = "nickname";
    public static final String BUNDLE = "bundel";
    private ImageView btnNo;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nick_name);

        context = this;
        btnSendData = (ImageView) findViewById(R.id.btnYes);
        btnNo = (ImageView) findViewById(R.id.btnNo);
        edtNickname = (EditText) findViewById(R.id.txtNickname);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byBundle();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                // start Main Activity
                startActivity(intent);
            }
        });
    }

    public void byBundle() {
        Intent intent = new Intent(NickNameActivity.this, NewGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NICKNAME, edtNickname.getText().toString());
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }
}