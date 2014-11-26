package com.xiajinfeng.musicgame.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//³ªÆ¬¶¯»­
	private Animation mPanAnim;
	private LinearInterpolator mPanLin;
	
	private Animation mBarInAnim;
	private LinearInterpolator mBarInLin;
		
	private Animation mBarOutAnim;
	private LinearInterpolator mBarOutLin;
	
	private ImageButton mbtnPlay;
	private ImageView  mViewPan;
	private ImageView mViewPanBar;
	
	private boolean  mIsRunning=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mbtnPlay=(ImageButton)findViewById(R.id.btn_play_start);
		mViewPan=(ImageView)findViewById(R.id.iv_disc);
		mViewPanBar=(ImageView)findViewById(R.id.iv_pin);
		
		mPanAnim=AnimationUtils.loadAnimation(this, R.anim.rotate);
		mPanLin=new LinearInterpolator();
		mPanAnim.setInterpolator(mPanLin);
		mPanAnim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				mViewPanBar.startAnimation(mBarOutAnim);
			}
		});
		
		mBarInAnim=AnimationUtils.loadAnimation(this, R.anim.rotate_45);
		mBarInLin=new LinearInterpolator();
		mBarInAnim.setInterpolator(mBarInLin);
		mBarInAnim.setFillAfter(true);
		
		mBarInAnim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				mViewPan.startAnimation(mPanAnim);
			}
		});
		
		mBarOutAnim=AnimationUtils.loadAnimation(this, R.anim.rotate_45);
		mBarOutLin=new LinearInterpolator();
		mBarOutAnim.setInterpolator(mBarOutLin);
		mBarOutAnim.setFillAfter(true);
		mBarOutAnim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				mIsRunning=false;
				mbtnPlay.setVisibility(View.VISIBLE);
			}
		});
		
		mbtnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				handlePlayButton();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	/**
	 * 
	 */
	private void handlePlayButton(){
		
		if(mViewPanBar!=null){
			if(!mIsRunning)
			{
				/*new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mViewPanBar.startAnimation(mBarInAnim);
					}
				});*/
				mViewPanBar.startAnimation(mBarInAnim);
			
			mIsRunning=true;
			mbtnPlay.setVisibility(View.INVISIBLE);
			}
		}
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		mViewPan.clearAnimation();
		super.onPause();
	}

}
