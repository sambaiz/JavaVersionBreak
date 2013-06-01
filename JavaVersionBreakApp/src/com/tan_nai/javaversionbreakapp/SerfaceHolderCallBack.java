package com.tan_nai.javaversionbreakapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;

public class SerfaceHolderCallBack implements SurfaceHolder.Callback, Runnable{

 private SurfaceHolder holder = null;
 private Thread thread = null;
 private boolean isAttached = true;
private Bitmap sougen;
 
public SerfaceHolderCallBack(Context context){
  Resources res = context.getResources();
  sougen = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
  }

 @Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
 }

 @Override
 public void surfaceCreated(SurfaceHolder holder) {
 	this.holder = holder;
 	thread = new Thread(this);
 	thread.start(); //スレッドを開始
 }

 @Override
 public void surfaceDestroyed(SurfaceHolder holder) {
  isAttached = false;
  thread = null; //スレッドを終了
 }

 @Override
 public void run() {
 	// メインループ（無限ループ）
 	while( isAttached ){
 	 long t1 = System.currentTimeMillis();

 	 //描画処理を開始
 	 Canvas canvas = holder.lockCanvas();
 	 canvas.drawColor(0,PorterDuff.Mode.CLEAR );
 	 Paint paint = new Paint();
  paint.setColor(Color.WHITE);

  canvas.drawBitmap(sougen, 100, 0, paint);


 	 //描画処理を終了
 	 holder.unlockCanvasAndPost(canvas);

 	 // スリープ
 	 long t2 = System.currentTimeMillis();
 	 if(t2 - t1 < 16){ // 1000 / 60 = 16.6666
 	 try {
 	 Thread.sleep(16 - (t2 - t1));
 	 } catch (InterruptedException e) {
 	 }
 	 }
 	 }
 	}
 }