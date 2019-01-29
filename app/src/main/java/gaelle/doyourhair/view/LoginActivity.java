package gaelle.doyourhair.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import gaelle.doyourhair.R;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    // Propriétés
    private EditText editEmail;
    private  EditText editMdp;
    private Button btnConnexion;


    public static void launch (Context context){
        context.startActivity(new Intent(context , LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText) findViewById(R.id.edit_email);
        editMdp = (EditText) findViewById(R.id.edit_mdp);
        btnConnexion = (Button) findViewById(R.id.btn_connexion);

        Location location = getUserLocation();
        Toast.makeText(this, location.getLatitude()+" : "+location.getLongitude(), Toast.LENGTH_SHORT).show();

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Login Clicked");
                if(!validateForm()){
                    Log.d(TAG, "Invalid form");
                    return;
                }

                showProgressDialog();
                String email = editEmail.getText().toString();
                String password = editMdp.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "Is user creation successful ? "+ task.isSuccessful());
                                hideProgressDialog();
                                //Si l'inscription est réussi on va ajouter l'utilisateur dans la base
                                if(task.isSuccessful()){
                                    HomeActivity.Launch(LoginActivity.this);
                                    finish();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Connexion échoué. Veuillez réessayer", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }

    /**
     * Teste si les champs sont bien renseignés
     * @return boolean
     */
    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("Requis");
            result = false;
        } else {
            editEmail.setError(null);
        }

        if (TextUtils.isEmpty(editMdp.getText().toString())) {
            editMdp.setError("Requis");
            result = false;
        } else {
            editMdp.setError(null);
        }

        return result;
    }
}
