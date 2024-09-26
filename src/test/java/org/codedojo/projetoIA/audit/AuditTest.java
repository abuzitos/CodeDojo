package org.codedojo.projetoIA.audit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuditTest {
    private Audit audit;
    private File visitLogFile;

    @BeforeEach
    public void setUp() {
        visitLogFile = new File("test_visit_log.txt");
        audit = new Audit("Test Visitor", LocalDateTime.now(), visitLogFile);
    }

    @Test
    public void testConstructor() {
        assertEquals("Test Visitor", audit.getVisitorName());
        assertEquals(visitLogFile, audit.getVisitLogFile());
    }

    @Test
    public void testGettersAndSetters() {
        audit.setVisitorName("New Visitor");
        assertEquals("New Visitor", audit.getVisitorName());

        LocalDateTime newTime = LocalDateTime.now().plusDays(1);
        audit.setVisitTime(newTime);
        assertEquals(newTime, audit.getVisitTime());

        File newFile = new File("new_visit_log.txt");
        audit.setVisitLogFile(newFile);
        assertEquals(newFile, audit.getVisitLogFile());
    }

    @Test
    public void testDisplayVisitorInfo() {
        audit.displayVisitorInfo();
        // This test is just to ensure the method runs without errors
    }

    @Test
    public void testSaveAuditRecord() throws IOException {
        audit.saveAuditRecord();
        assertTrue(visitLogFile.exists());
        assertTrue(!Files.readAllLines(visitLogFile.toPath()).isEmpty());
    }

    @Test
    public void testSaveAuditRecordCreatesNewFile() throws IOException {
        for (int i = 0; i < 6; i++) {
            audit.saveAuditRecord();
        }
        File newFile = new File("test_visit_log_1.txt");
        assertTrue(newFile.exists());
    }

    @Test
    public void testCountRecords() throws IOException {
        for (int i = 0; i < 3; i++) {
            audit.saveAuditRecord();
        }
        assertEquals(5, audit.countRecords(visitLogFile));
    }
}