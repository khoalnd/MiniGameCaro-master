package com.team1.caro.minigamecaro;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * CSIT 5510 (L1)
 * CHENG Mingxin, 20387442, mchengaa@connect.ust.hk
 * CHEN Kangle, 20403480, kchenam@connect.ust.hk
 * WANG Ziwei, 20402072, zwangcp@connect.ust.hk
 */

/**
 * Created by chengmx on 2016/11/12.
 */

public class RenderThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private DrawView dView;
    private boolean running;

    public RenderThread(SurfaceHolder surfaceHolder, DrawView dView){
        this.surfaceHolder = surfaceHolder;
        this.dView = dView;
    }

    @Override
    public void run() {
        Canvas canvas;
        while(running){
            canvas = null;
            long startTime = System.currentTimeMillis();
            this.dView.update();
            long endTime = System.currentTimeMillis();

            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.dView.render(canvas);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(canvas != null){
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            try{
                if((endTime - startTime) <= 100){
                    sleep(100 - (endTime - startTime));
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
