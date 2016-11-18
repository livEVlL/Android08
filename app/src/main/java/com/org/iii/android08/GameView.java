package com.org.iii.android08;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameView extends View {
    private Resources res; //抓專案的資源
    private int viewW, viewH;
    private boolean isInit;
    private Bitmap bmpBall;
    private Context context;
    private Matrix matrix;
    private float ballW, ballH;


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        res = context.getResources();
        //setBackgroundColor(Color.GREEN);
        matrix = new Matrix();


    }

    private void init(){
        viewW = getWidth(); viewH = getHeight();
        Log.v("brad", viewW + "x" +viewH);

        bmpBall = BitmapFactory.decodeResource(res,R.drawable.p2);
        ballW = viewW / 12f; ballH = ballW;
        bmpBall = resizeBmp(bmpBall, ballW, ballH);


        isInit = true;
    }

    Bitmap resizeBmp(Bitmap src, float width, float height){
        matrix.reset();
        matrix.postScale(width/src.getWidth(), height/src.getHeight());
        return Bitmap.createBitmap(src,0,0,src.getWidth(),src.getHeight(),matrix,false);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawBitmap(bmpBall,0,0,null);
    }
}