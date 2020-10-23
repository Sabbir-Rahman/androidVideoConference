package com.example.videocallconference.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videocallconference.Models.User;
import com.example.videocallconference.R;
import com.example.videocallconference.listeners.UsersListener;

import java.util.List;

public class usersAdapter extends RecyclerView.Adapter<usersAdapter.UserViewHolder> {

    private List<User> users;
    private UsersListener usersListener;

    public usersAdapter(List<User> users, UsersListener usersListener)
    {
        this.users = users;
        this.usersListener = usersListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_user,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView textFirstChar, textUserName, textEmail;
        ImageView imageAudioMeeting,imageVideoMeeting;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textFirstChar = itemView.findViewById(R.id.textFistChar);
            textUserName = itemView.findViewById(R.id.textUserName);
            textEmail = itemView.findViewById(R.id.viewTextEmail);
            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
        }

        void setUserData(User user){
            textFirstChar.setText(user.firstName.substring(0,1));
            textUserName.setText(String.format("%s %s",user.firstName, user.lastName));
            textEmail.setText(user.email);
            imageAudioMeeting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usersListener.initiateAudioMeeting(user);
                }
            });
            imageVideoMeeting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usersListener.initiateVideoMeeting(user);
                }
            });
        }
    }

}
