package com.team1.caro.minigamecaro.popup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.team1.caro.minigamecaro.NewGameActivity;
import com.team1.caro.minigamecaro.NickNameActivity;
import com.team1.caro.minigamecaro.R;

public class WinActivity extends Activity {

    private Button btnRestart;
    private TextView txtHighScore;
    private TextView txtTitle;
    private ImageView icon;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(height*.7));

        txtHighScore = (TextView) findViewById(R.id.popupScore);
        txtTitle = (TextView) findViewById(R.id.popupTitle);
        icon = (ImageView) findViewById(R.id.image);
        intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(NewGameActivity.BUNDLE);
            if (bundle != null) {
                txtHighScore.setText(bundle.getString(NewGameActivity.POPUP_HIGHSCORE));
                txtTitle.setText(bundle.getString(NewGameActivity.POPUP_TITLE));
                String my_image = bundle.getString(NewGameActivity.POPUP_ICON);
                if(my_image.equals("game_over")){
                    icon.setImageResource(R.drawable.icon_gameover);
                }

            }
        }
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WinActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }
}
