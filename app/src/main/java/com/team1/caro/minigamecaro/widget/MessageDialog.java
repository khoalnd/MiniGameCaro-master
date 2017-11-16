package com.team1.caro.minigamecaro.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.team1.caro.minigamecaro.R;

/**
 * CSIT 5510 (L1)
 * CHENG Mingxin, 20387442, mchengaa@connect.ust.hk
 * CHEN Kangle, 20403480, kchenam@connect.ust.hk
 * WANG Ziwei, 20402072, zwangcp@connect.ust.hk
 */

/**
 * Created by chengmx on 2016/11/13.
 */

public class MessageDialog extends Dialog {
    public MessageDialog(Context context, String msg) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.message_dialog, null);
        TextView textView = (TextView)view.findViewById(R.id.msg);
        textView.setText(msg);
        Button ok = (Button)view.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        super.setContentView(view);
    }
}
