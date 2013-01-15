/**
 * http://www.androidaspect.com/2012/12/android-splash-screen-tutorial.html
 */
/**
 * background: http://www.vogella.com/blog/2011/07/19/android-shapes/
 */
package com.flashback.calcestv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity{

	private long ms = 0;
	private long splashTime = 3500;
	private boolean splashActive = true;
	private boolean paused = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		 //Hides the titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if(!paused)
                            ms=ms+100;
                        sleep(100);
                    }
                } catch(Exception e) {}
                finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();
    }
}
