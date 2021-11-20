package com.example.blooddonation.attributes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blooddonation.Mainmodel;
import com.example.blooddonation.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class users_data_adaptar extends FirebaseRecyclerAdapter<Mainmodel, users_data_adaptar.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public users_data_adaptar(@NonNull FirebaseRecyclerOptions<Mainmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Mainmodel model) {
        holder.name.setText(model.getName());
        holder.blood.setText(model.getBlood());
        holder.email.setText(model.getEmail());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_menu,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name , blood, email;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img =(CircleImageView) itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.textname);
            blood = (TextView)itemView.findViewById(R.id.textblood);
            email = (TextView)itemView.findViewById(R.id.textemail);



        }
    }
}
