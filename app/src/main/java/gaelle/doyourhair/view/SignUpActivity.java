package gaelle.doyourhair.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
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

public class SignUpActivity extends BaseActivity {
    private static final String TAG= "SignUpActivity"; //Pour repéré l'origine des erreurs dans le LogCat (console de debuggage)

    private EditText editNom;
    private EditText editPrenom;
    private EditText editEmail;
    private EditText editMdp;
    private Button btnInscription;

    public static void launch (Context context){
        context.startActivity(new Intent(context , SignUpActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Views
        editNom = (EditText) findViewById(R.id.edit_nom);
        editPrenom = (EditText) findViewById(R.id.edit_prenom);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editMdp = (EditText) findViewById(R.id.edit_mdp);
        btnInscription = (Button) findViewById(R.id.btn_inscription);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "SignUp Clicked"); //Afficher dans les logs ce msg

                //Check si les input utilisateurs sont valides
                if(!validateForm()){
                    Log.d(TAG, "Invalid form");
                    return;
                }

                showProgressDialog();
                String email = editEmail.getText().toString();
                String password = editMdp.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "Is user creation successful ? "+ task.isSuccessful());
                                hideProgressDialog();

                                //Si l'inscription est réussi on va ajouter l'utilisateur dans la base
                                if(task.isSuccessful()){
                                    onSignUpSuccess(task.getResult().getUser());
                                }else{
                                    Toast.makeText(SignUpActivity.this, "Inscription échoué. Veuillez réessayer", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    /**
     * Lorsque la connexion/inscription réussi on appelle cette méthode
     */
    private void onSignUpSuccess(FirebaseUser user){
        String name = editNom.getText().toString();
        String prenom = editPrenom.getText().toString();
        Location location = getUserLocation();
        if(TextUtils.isEmpty(name))
            name = usernameFromEmail(user.getEmail());

        writeNewUser(user.getUid(), name, prenom, user.getEmail(), false, location.getLatitude(), location.getLongitude()); //Si création depuis SignUp c'est que pas coiffeuse

        HomeActivity.Launch(this);
        finish();
    }

    /**
     * Récupère la premiere partie du mail pour retourner un pseudo
     * @param email
     * @return
     */
    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
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
