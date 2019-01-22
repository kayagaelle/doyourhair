package gaelle.doyourhair.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gaelle.doyourhair.R;
import gaelle.doyourhair.database.DyhDatabase;
import gaelle.doyourhair.model.User;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.launch(SplashScreenActivity.this);
            }
        },2000
        );


    }
}
