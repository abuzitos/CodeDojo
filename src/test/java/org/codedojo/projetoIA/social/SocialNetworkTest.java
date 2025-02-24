package org.codedojo.projetoIA.social;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {
    private SocialNetwork network;

    @BeforeEach
    public void setUp() {
        network = new SocialNetwork();
    }

    @Test
    public void testAddUser() {
        network.addUser("Alice");
        assertTrue(network.viewTimeline("Alice").isEmpty());    
    }
}
