package com.focusx.farsaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    // Splash screen duration in milliseconds
    private static final int SPLASH_TIME_OUT = 3000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Use a Handler to delay the redirection
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This code will run after the timer is up
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
