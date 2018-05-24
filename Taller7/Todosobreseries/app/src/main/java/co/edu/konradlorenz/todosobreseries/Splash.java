package co.edu.konradlorenz.todosobreseries;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private Transition transition;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //supportRequestWindowFeature ( Window.FEATURE_NO_TITLE );
        Animation rotation = AnimationUtils.loadAnimation(this,R.anim.fromrad);
        ImageView imagen = (ImageView)findViewById(R.id.imageView);
        imagen.setAnimation(rotation);
        Slide slideBottom = new Slide(Gravity.BOTTOM);
        slideBottom.setDuration(1000);
        slideBottom.setInterpolator(new DecelerateInterpolator());
        getWindow().setAllowReturnTransitionOverlap(false);
        getWindow().setReenterTransition(slideBottom);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transition = new Slide(Gravity.TOP);
                transition.setDuration(1000);
                transition.setInterpolator(new DecelerateInterpolator());
                getWindow().setExitTransition(transition);
                Intent intent = new Intent ( Splash.this, MainActivity.class );
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(Splash.this).toBundle());
            }
        });

        new Handler (  ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                transition = new Slide(Gravity.LEFT);
                transition.setDuration(1000);
                transition.setInterpolator(new DecelerateInterpolator());
                getWindow().setExitTransition(transition);
                Intent intent = new Intent ( Splash.this, MainActivity.class );
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(Splash.this).toBundle());
            }
        },4000);
    }
}
