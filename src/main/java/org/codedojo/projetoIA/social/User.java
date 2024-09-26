package org.codedojo.projetoIA.social;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final String nameUser;
    private final List<String> timeline;
    private final Set<User> following;
    private final List<String> mentions;
    private final List<String> directMessages;

    public User(String name) {
        this.nameUser = name;
        this.timeline = new ArrayList<>();
        this.following = new HashSet<>();
        this.mentions = new ArrayList<>();
        this.directMessages = new ArrayList<>();
    }

    public void postMessage(String message) {
        timeline.add(message + '\n');
    }

    public List<String> viewTimeline() {
        List<String> aggregatedTimeline = new ArrayList<>(timeline);
        aggregatedTimeline.add("<------- Timeline ------->\n");
        for (User user : following) {
            aggregatedTimeline.addAll(user.timeline);
        }
        aggregatedTimeline.add("<------- Fim Timeline ------->\n");
        return aggregatedTimeline;
    }

    public void followUser(User user) {
        System.out.println("Eu:" + this.getName() + " Seguindo User: " + user.getName());
        following.add(user);
    }

    public void mentionUser(User user, String message) {
        user.mentions.add(message);
    }

    public void sendDirectMessage(User user, String message) {
        user.directMessages.add(message);
    }

    public String getName() {
        return nameUser;
    }
}
