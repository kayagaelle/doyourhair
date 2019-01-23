package gaelle.doyourhair.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gaelle.doyourhair.CoiffeuseAdapter;
import gaelle.doyourhair.R;
import gaelle.doyourhair.model.User;

public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    private RecyclerView listeCoiffeuse;
    private CoiffeuseAdapter adapter;
    private List<User> users = new ArrayList<>();
    private ValueEventListener eventListener;

    public static void Launch(Context context){
        context.startActivity(new Intent(context , HomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listeCoiffeuse = findViewById(R.id.liste_coiffeuse);

        adapter = new CoiffeuseAdapter();
        listeCoiffeuse.setAdapter(adapter);
        listeCoiffeuse.setLayoutManager(new LinearLayoutManager(this));
        listeCoiffeuse.setHasFixedSize(true);


        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    User user = data.getValue(User.class);
                    if(user.isCoiffeuse()) {
                        Log.d(TAG, "user récupéré : " + user.getIdUser());
                        users.add(user);
                    }
                }

                adapter.resetData(users);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };

    }

    @Override
    protected void onStart() {
        super.onStart();

        database.child("users").addListenerForSingleValueEvent(eventListener);
    }
}
