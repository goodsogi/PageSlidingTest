package com.seriouscompany.pageslidingtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    boolean isPageOpen = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonListener();
    }

    private void addButtonListener() {
        Button openButton01 = (Button) findViewById(R.id.openButton01);
        openButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen) {
                    startRightAnimation();
                } else {
                    showSlidingPage();
                    startLeftAnimation();
                }
            }
        });
    }

    private void showSlidingPage() {
        LinearLayout slidingPage01 = (LinearLayout) findViewById(R.id.slidingPage01);
        slidingPage01.setVisibility(View.VISIBLE);
    }

    private void startRightAnimation() {
        LinearLayout slidingPage01 = (LinearLayout) findViewById(R.id.slidingPage01);
        slidingPage01.startAnimation(getRightAnimation());
    }

    private Animation getRightAnimation() {
        Animation rightAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        rightAnimation.setAnimationListener(new Animation.AnimationListener() {


            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handleAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return rightAnimation;
    }

    private void handleAnimationEnd() {
        Log.d("animationtest", "ispageopen: " + isPageOpen);
        if(isPageOpen) {
            hideSlidingPage();
            changeButtonLabel("Open");
            isPageOpen = false;
        } else {
            changeButtonLabel("Close");
            isPageOpen = true;
        }
    }

    private void changeButtonLabel(String label) {
        Button openButton01 = (Button) findViewById(R.id.openButton01);
        openButton01.setText(label);
    }

    private void hideSlidingPage() {
        LinearLayout slidingPage01 = (LinearLayout) findViewById(R.id.slidingPage01);
        slidingPage01.setVisibility(View.INVISIBLE);
    }

    private void startLeftAnimation() {
        LinearLayout slidingPage01 = (LinearLayout) findViewById(R.id.slidingPage01);
        slidingPage01.startAnimation(getLeftAnimation());
    }

    public Animation getLeftAnimation() {

        Animation leftAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        leftAnimation.setAnimationListener(new Animation.AnimationListener() {


            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handleAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return leftAnimation;
    }
}
