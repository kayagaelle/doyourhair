package gaelle.doyourhair;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gaelle.doyourhair.model.User;

public class CoiffeuseAdapter extends RecyclerView.Adapter<CoiffeuseAdapter.CoiffeuseHolder> {
    private List<User> users;

    public void resetData(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoiffeuseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coiffeuse, parent, false);

        CoiffeuseHolder coiffeuseHolder = new CoiffeuseHolder(view);

        return coiffeuseHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoiffeuseHolder holder, int position) {
        User user = users.get(position);
        holder.setData(user);
    }

    @Override
    public int getItemCount() {
        if(users == null)
            return 0;
        else
            return users.size();
    }

    class CoiffeuseHolder extends RecyclerView.ViewHolder{
        public TextView txvName;
        public TextView txvAdresse;
        public ImageView imvUser;

        public CoiffeuseHolder(View itemView) {
            super(itemView);

            txvName = itemView.findViewById(R.id.txv_name);
            txvAdresse = itemView.findViewById(R.id.txv_adresse);
            imvUser = itemView.findViewById(R.id.imv_user);
        }

        public void setData(User user){
            txvAdresse.setText(user.getAdresse());
            txvName.setText(user.getNom());
        }
    }
}
