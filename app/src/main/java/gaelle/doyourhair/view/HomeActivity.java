package gaelle.doyourhair.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gaelle.doyourhair.R;

public class HomeActivity extends AppCompatActivity {

    public static void Launch(Context context){
        context.startActivity(new Intent(context , HomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}