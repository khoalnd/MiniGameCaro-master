package com.team1.caro.minigamecaro;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private Context context;
    private ImageView image;
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        context = this;
        connectView();

        //mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
        //hideUI();

    }

    private void connectView() {
        image = (ImageView) findViewById(R.id.btnPlay);
        findViewById(R.id.btnPlay).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
//            case R.id.btnOption:
//                option();
//                break;
            case R.id.btnPlay:
                nickname();
                break;
//            case R.id.btnExit:
//                exit();
//                break;
        }
    }

    private void newgame() {
        // create intent to show Option Activity
        Intent intent = new Intent(context, NewGameActivity.class);

        // start NewGame Activity
        startActivity(intent);
    }

    private void nickname() {
        // create intent to show NickName Activity
        Intent intent = new Intent(context, NickNameActivity.class);

        // start NickName Activity
        startActivity(intent);
    }

    private void exit() {
        /*new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .show();
        */
        AlertDialog.Builder buider;
        buider = new AlertDialog.Builder(context);
        buider.setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                System.exit(0);
            }
        })
        .setNegativeButton("No", null)
        .show();
    }

    /*private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (getSupportActionBar() != null && getSupportActionBar().isShowing()) {
                hideUI();
            } else {
                showSystemUI();
            }
            return true;
        }
    }

    private void hideUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_FULLSCREEN | //Full screen mode
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |     //Stable when using multiple flags
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | //avoid artifacts when FLAG_FULLSCREEN
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
*/
}
