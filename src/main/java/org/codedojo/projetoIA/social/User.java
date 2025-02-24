package org.codedojo.projetoIA.social;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String nameUser;
    private final List<String> timeline;
    private final List<User> followees;
    private final List<String> mentions;
    private final List<String> directMessages;
    private final List<User> blockedUsers;



    public User(String name) {
        this.nameUser = name;
        this.timeline = new ArrayList<>();
        this.followees = new ArrayList<>();
        this.mentions = new ArrayList<>();
        this.directMessages = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public void postMessage(String message) {
        timeline.add(message + '\n');
    }

    public List<String> viewTimeline() {
        return new ArrayList<>(timeline);
    }

    public void followUser(User user) {
        System.out.println("Eu:" + this.getName() + " Seguindo User: " + user.getName());
        followees.add(user);
    }

    public void mentionUser(User user, String message) {
        timeline.add(message);
        user.mentions.add(message);
    }

    public void sendDirectMessage(User user, String message) {
        user.directMessages.add(message);
    }

    public String getName() {
        return nameUser;
    }

    public void unfollowUser(User user) {
        followees.remove(user);
    }

    public List<User> getFollowees() {
        return followees;
    }

    public void blockUser(User user) {
        if (!blockedUsers.contains(user)) {
            blockedUsers.add(user);
        }
    }
}
