package gaelle.doyourhair.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gaelle.doyourhair.R;

public class LoginActivity extends AppCompatActivity {

    // Propriétés
    private EditText email;
    private  EditText mdp;
    private Button btnConnexion;


    public static void launch (Context context){
        context.startActivity(new Intent(context , LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.edit_email);
        mdp = (EditText) findViewById(R.id.edit_mdp);
        btnConnexion = (Button) findViewById(R.id.btn_connexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Appel la méthode Launch de  HomeActivity
            }
        });


    }
}
