package org.codedojo.projetoIA.social;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {
    private SocialNetwork network;

    @BeforeEach
    public void setUp() {
        network = new SocialNetwork();
    }

    @Test
    public void testAddUser() {
        // Main success flow
        network.addUser("Alice");
        assertFalse(network.viewTimeline("Alice").isEmpty());

        // Alternative success flow
        network.addUser("Bob");
        assertFalse(network.viewTimeline("Bob").isEmpty());

        // Alternative non-success flow
        network.addUser("Alice"); // Adding the same user again
        assertEquals(1, network.viewTimeline("Alice").size());

        // Exception flow
        assertThrows(IllegalArgumentException.class, () -> network.addUser(""));
    }

    @Test
    public void testPostMessage() {
        // Main success flow
        network.addUser("Alice");
        network.postMessage("Alice", "Hello, this is Alice's first post!");
        List<String> timeline = network.viewTimeline("Alice");
        assertEquals(1, timeline.size());
        assertEquals("Hello, this is Alice's first post!", timeline.get(0));

        // Alternative success flow
        network.postMessage("Alice", "Alice's second post!");
        timeline = network.viewTimeline("Alice");
        assertEquals(2, timeline.size());

        // Alternative non-success flow
        network.postMessage("Bob", "This should not be posted"); // Bob does not exist
        timeline = network.viewTimeline("Bob");
        assertTrue(timeline.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.postMessage(null, "This should fail"));
    }

    @Test
    public void testViewEmptyTimeline() {
        // Main success flow
        network.addUser("Alice");
        List<String> timeline = network.viewTimeline("Alice");
        assertTrue(timeline.isEmpty());

        // Alternative success flow
        network.addUser("Bob");
        timeline = network.viewTimeline("Bob");
        assertTrue(timeline.isEmpty());

        // Alternative non-success flow
        timeline = network.viewTimeline("Charlie"); // Charlie does not exist
        assertTrue(timeline.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.viewTimeline(null));
    }

    @Test
    public void testFollowUser() {
        // Main success flow
        network.addUser("Alice");
        network.addUser("Bob");
        network.postMessage("Alice", "Hello, this is Alice's first post!");
        network.followUser("Bob", "Alice");
        List<String> timeline = network.viewTimeline("Bob");
        assertEquals(1, timeline.size());
        assertEquals("Hello, this is Alice's first post!", timeline.get(0));

        // Alternative success flow
        network.addUser("Charlie");
        network.followUser("Charlie", "Alice");
        timeline = network.viewTimeline("Charlie");
        assertEquals(1, timeline.size());

        // Alternative non-success flow
        network.followUser("Bob", "Charlie"); // Charlie has no posts
        timeline = network.viewTimeline("Bob");
        assertEquals(1, timeline.size());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.followUser(null, "Alice"));
    }

    @Test
    public void testMentionUser() {
        // Main success flow
        network.addUser("Alice");
        network.addUser("Bob");
        network.mentionUser("Alice", "Bob", "Hey @Bob, check this out!");
        List<String> timeline = network.viewTimeline("Bob");
        assertEquals(1, timeline.size());
        assertEquals("Hey @Bob, check this out!", timeline.get(0));

        // Alternative success flow
        network.mentionUser("Alice", "Bob", "Another mention @Bob!");
        timeline = network.viewTimeline("Bob");
        assertEquals(2, timeline.size());

        // Alternative non-success flow
        network.mentionUser("Alice", "Charlie", "Hey @Charlie!"); // Charlie does not exist
        timeline = network.viewTimeline("Charlie");
        assertTrue(timeline.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.mentionUser(null, "Bob", "This should fail"));
    }

    @Test
    public void testSendDirectMessage() {
        // Main success flow
        network.addUser("Alice");
        network.addUser("Bob");
        network.sendDirectMessage("Alice", "Bob", "Hi Bob, this is a private message from Alice.");
        // Assuming there's a method to view direct messages
        // List<String> messages = network.viewDirectMessages("Bob");
        // assertEquals(1, messages.size());
        // assertEquals("Hi Bob, this is a private message from Alice.", messages.get(0));

        // Alternative success flow
        network.sendDirectMessage("Alice", "Bob", "Another private message.");
        // messages = network.viewDirectMessages("Bob");
        // assertEquals(2, messages.size());

        // Alternative non-success flow
        network.sendDirectMessage("Alice", "Charlie", "Hi Charlie!"); // Charlie does not exist
        // messages = network.viewDirectMessages("Charlie");
        // assertTrue(messages.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.sendDirectMessage(null, "Bob", "This should fail"));
    }

    @Test
    public void testNullUser() {
        // Exception flow
        assertThrows(NullPointerException.class, () -> network.postMessage(null, "This should fail"));
        assertThrows(NullPointerException.class, () -> network.followUser(null, "Alice"));
        assertThrows(NullPointerException.class, () -> network.mentionUser(null, "Bob", "This should fail"));
        assertThrows(NullPointerException.class, () -> network.sendDirectMessage(null, "Bob", "This should fail"));
    }

    @Test
    public void testEmptyUserName() {
        // Exception flow
        assertThrows(IllegalArgumentException.class, () -> network.addUser(""));
        assertThrows(IllegalArgumentException.class, () -> network.postMessage("", "This should fail"));
        assertThrows(IllegalArgumentException.class, () -> network.followUser("", "Alice"));
        assertThrows(IllegalArgumentException.class, () -> network.mentionUser("", "Bob", "This should fail"));
        assertThrows(IllegalArgumentException.class, () -> network.sendDirectMessage("", "Bob", "This should fail"));
    }

    @Test
    public void testUnfollowUser() {
        // Main success flow
        network.addUser("Alice");
        network.addUser("Bob");
        network.followUser("Bob", "Alice");
        network.unfollowUser("Bob", "Alice");
        List<String> timeline = network.viewTimeline("Bob");
        assertTrue(timeline.isEmpty());

        // Alternative success flow
        network.followUser("Bob", "Alice");
        network.postMessage("Alice", "Hello, this is Alice's post!");
        network.unfollowUser("Bob", "Alice");
        timeline = network.viewTimeline("Bob");
        assertTrue(timeline.isEmpty());

        // Alternative non-success flow
        network.unfollowUser("Charlie", "Alice"); // Charlie does not exist
        timeline = network.viewTimeline("Charlie");
        assertTrue(timeline.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.unfollowUser(null, "Alice"));
    }

    @Test
    public void testViewAggregatedTimeline() {
        // Main success flow
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.postMessage("Alice", "Alice's post!");
        network.postMessage("Bob", "Bob's post!");
        network.followUser("Charlie", "Alice");
        network.followUser("Charlie", "Bob");
        List<String> timeline = network.viewAggregatedTimeline("Charlie");
        assertEquals(2, timeline.size());

        // Alternative success flow
        network.postMessage("Alice", "Another post from Alice!");
        timeline = network.viewAggregatedTimeline("Charlie");
        assertEquals(3, timeline.size());

        // Alternative non-success flow
        timeline = network.viewAggregatedTimeline("Mallory"); // Mallory does not exist
        assertTrue(timeline.isEmpty());

        // Exception flow
        assertThrows(NullPointerException.class, () -> network.viewAggregatedTimeline(null));
    }
}
