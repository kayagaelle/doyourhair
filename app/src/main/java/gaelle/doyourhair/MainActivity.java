package gaelle.doyourhair;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //propriétés
    private Button btnConnexion;
    private Button btnInscription;
    private Button btnCoinCoiffeuse;


    // a faire a chaque page
    public static void launch (Context context){
        context.startActivity(new Intent(context , MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnexion = (Button) findViewById(R.id.btn_connexion);
        btnCoinCoiffeuse = (Button) findViewById(R.id.btn_coin_coiffeuse);
        btnInscription = (Button) findViewById(R.id.btn_inscription);


        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Appel la méthode Launch de LoginActivity
               LoginActivity.launch(view.getContext());
            }
        });

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Appel la méthode Launch de SignUpActivty
                SignUpActivity.launch(view.getContext());
            }
        });
    }
}
