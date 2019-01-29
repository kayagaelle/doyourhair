package gaelle.doyourhair.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
    protected void writeNewUser(String userId, String name, String prenom, String email, boolean isCoiffeuse, double latitude, double longitude) {
        User user = new User(userId, email, name, prenom, isCoiffeuse, latitude, longitude);

        database.child("users").child(userId).setValue(user);
    }


    /**
     * Recupère la localisation de l'utilisateur depuis le réseau et non depuis le GPS
     */
    protected Location getUserLocation(){
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location location = null;
        boolean networkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if(networkEnable){
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }catch (SecurityException e){}
        }

        return location;
    }

    LocationListener locationListener =new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {
            double latitude=location.getLatitude();
            double longitude=location.getLongitude();
            Log.d("LocationListener", "New Latitude: "+latitude + "New Longitude: "+longitude);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

}
