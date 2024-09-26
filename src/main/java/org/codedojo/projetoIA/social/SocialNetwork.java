package org.codedojo.projetoIA.social;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    private final Map<String, User> users;

    public SocialNetwork() {
        this.users = new HashMap<>();
    }

    public void addUser(String name) {
        users.put(name, new User(name));
    }

    public void postMessage(String userName, String message) {
        User user = users.get(userName);
        if (user != null) {
            user.postMessage(message);
        }
    }

    public List<String> viewTimeline(String userName) {
        User user = users.get(userName);
        if (user != null) {
            return user.viewTimeline();
        }
        return Collections.emptyList();
    }

    public void followUser(String followerName, String followeeName) {
        User follower = users.get(followerName);
        User followee = users.get(followeeName);
        if (follower != null && followee != null) {
            follower.followUser(followee);
        }
    }

    public void mentionUser(String userName, String mentionedUserName, String message) {
        User user = users.get(userName);
        User mentionedUser = users.get(mentionedUserName);
        if (user != null && mentionedUser != null) {
            user.mentionUser(mentionedUser, message);
        }
    }

    public void sendDirectMessage(String senderName, String receiverName, String message) {
        User sender = users.get(senderName);
        User receiver = users.get(receiverName);
        if (sender != null && receiver != null) {
            sender.sendDirectMessage(receiver, message);
        }
    }
    
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Adding users
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Mallory");

        // Posting: Alice can publish messages to a personal timeline
        network.postMessage("Alice", "Hello, this is Alice's first post!");
        network.postMessage("Alice", "Check out this link: http://example.com");

        // Reading: Bob can view Alice’s timeline
        System.out.println("Alice's Timeline: " + network.viewTimeline("Alice"));

        // Following: Charlie can subscribe to Alice’s and Bob’s timelines, and view an aggregated list of all subscriptions
        network.followUser("Charlie", "Alice");
        network.followUser("Charlie", "Bob");
        network.postMessage("Bob", "Hello, this is Bob's first post!");
        System.out.println("Charlie's Aggregated Timeline: " + network.viewTimeline("Charlie"));

        // Mentions: Bob can link to Charlie in a message using “@”
        network.mentionUser("Bob", "Charlie", "Hey @Charlie, check this out!");

        // Links: Alice can link to a clickable web resource in a message
        network.postMessage("Alice", "Visit this site: http://example.com");

        // Direct Messages: Mallory can send a private message to Alice
        network.sendDirectMessage("Mallory", "Alice", "Hi Alice, this is a private message from Mallory.");

        // Displaying timelines and messages
        //System.out.println("Alice's Timeline: " + network.viewTimeline("Alice"));
        //System.out.println("Bob's Timeline: " + network.viewTimeline("Bob"));
        //System.out.println("Charlie's Timeline: " + network.viewTimeline("Charlie"));
    }
}
