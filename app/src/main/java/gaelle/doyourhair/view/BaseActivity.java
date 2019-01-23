package gaelle.doyourhair.view;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import gaelle.doyourhair.model.User;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    protected DatabaseReference database; //objet Firebase pour gérer la base de données
    protected FirebaseAuth firebaseAuth; //Objet Firebase pour gérer les connexion/inscriptions


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Instancier les objets firebases
        database = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    /**
     * Ecriture dans la base
     * @param userId
     * @param name
     * @param email
     */
    protected void writeNewUser(String userId, String name, String prenom, String email) {
        User user = new User(userId, email, name, prenom);

        database.child("users").child(userId).setValue(user);
    }

}
