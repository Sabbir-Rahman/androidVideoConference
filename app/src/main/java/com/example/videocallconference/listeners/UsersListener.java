package com.example.videocallconference.listeners;

import com.example.videocallconference.Models.User;

public interface UsersListener {

    void initiateVideoMeeting (User user);

    void initiateAudioMeeting (User user);

    void onMultipleUsersAction (Boolean isMultipleUserSelected);

}
