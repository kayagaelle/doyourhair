package gaelle.doyourhair;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {


    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText mdp;

    public static void launch (Context context){
        context.startActivity(new Intent(context , SignUpActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nom = (EditText) findViewById(R.id.edit_nom);
        prenom = (EditText) findViewById(R.id.edit_prenom);
        email = (EditText) findViewById(R.id.edit_email);
        mdp = (EditText) findViewById(R.id.edit_mdp);
    }
}
