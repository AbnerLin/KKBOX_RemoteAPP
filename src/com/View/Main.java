package com.View;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.Kernel.Core;

public class Main extends Activity {

	private ImageView playBtn;
	private ImageView pauseBtn;
	private ImageView stopBtn;
	private ImageView volumeupBtn;
	private ImageView previoustrack;
	private ImageView nexttrack;
	private ImageView volumedownBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Core.context = this;
		// Toast.makeText(this, Core.ipAddress, Toast.LENGTH_LONG).show();
		
		findViews();
		setListeners();
	}

	private void findViews() {
		playBtn = (ImageView) findViewById(R.id.playBtn);
		pauseBtn = (ImageView) findViewById(R.id.pauseBtn);
		stopBtn = (ImageView) findViewById(R.id.stopBtn);
		volumeupBtn = (ImageView) findViewById(R.id.volumeupBtn);
		previoustrack = (ImageView) findViewById(R.id.previoustrackBtn);
		nexttrack = (ImageView) findViewById(R.id.nexttrackBtn);
		volumedownBtn = (ImageView) findViewById(R.id.volumedownBtn);
	}
	

	private void setListeners() {
		playBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_MEDIA_PLAY_PAUSE");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		pauseBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_MEDIA_PLAY_PAUSE");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		stopBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					/* check network and send socket APPCOMMAND_MEDIA_STOP */
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_MEDIA_STOP");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		volumeupBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					/* check network and send socket */
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_VOLUME_UP");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		previoustrack.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					/* check network and send socket */
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_MEDIA_PREVIOUSTRACK");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		nexttrack.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					/* check network and send socket */
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_MEDIA_NEXTTRACK");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
		volumedownBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					/* check network and send socket */
					((ImageView) v).setAlpha(100);
					Core.socketObj.setCommand("APPCOMMAND_VOLUME_DOWN");
					Core.socketObj.run();
					break;
				}
				case MotionEvent.ACTION_UP: {
					((ImageView) v).setAlpha(255);
					break;
				}
				}
				return true;
			}
		});
	}

	// private void setListeners() {
	// playBtn.setOnClickListener((android.view.View.OnClickListener)
	// playBtnListener);
	// }
	//
	// private OnClickListener playBtnListener = new OnClickListener() {
	//
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// // TODO Auto-generated method stub
	// Toast.makeText(Main.this, Core.ipAddress, Toast.LENGTH_LONG).show();
	// }
	// };

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

}
