package gaelle.doyourhair.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import gaelle.doyourhair.model.User;

public class DyhDatabase {

    private DatabaseReference database;
    private static final String TABLE_USER = "USER";
    private static DyhDatabase constructor;

    public DyhDatabase(){
        database = FirebaseDatabase.getInstance().getReference("USER");
    }

    public static DyhDatabase getInstance(){
        if (constructor == null) {
            constructor = new DyhDatabase();
        }

        return constructor;
    }

    public void WriteUser(User user){
        user.setIdUser(1);
        user.setNom("ADAMA");

        database.child("1").setValue(user);
    }

}
