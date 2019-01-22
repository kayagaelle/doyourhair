package gaelle.doyourhair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    //1/ Ecrire la suite des propriétés comme sur MainActivity mais pour SignUpActivity
    private EditText editNom;

    //2/ Crée une fonction static Launch comme celle sur MainActivity mais pour SignUpActivity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //3/ Faire les findViewById correspondant aux propriétés plus haut
    }
}
