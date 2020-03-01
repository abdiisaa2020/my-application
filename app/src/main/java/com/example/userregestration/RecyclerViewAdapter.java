package com.example.userregestration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> {
    List<Users> user;
    Context context;

    RecyclerViewAdapter(List<Users> user, Context context) {
        this.user = user;
        this.context=context;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView userName, fullName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            userName = itemView.findViewById(R.id.u_name);
            fullName = itemView.findViewById(R.id.fulName);

        }
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Users listItem = user.get(position);
        holder.userName.setText(listItem.getUsername());
        holder.fullName.setText(listItem.getFullname());

    }

    public void onAttachedToRecylerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

    @Override
    public int getItemCount() {

        return user.size();
    }


}

class Users {

    public String fullname;
    public String username;

    public Users(String fullname, String username) {
        this.fullname = fullname;
        this.username = username;

    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }
}
