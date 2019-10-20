import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * The test class of CalendarEntry
 *
 * @author Tormod Lysvold Sjømæling
 */
public class CalendarEntryTest {

    private CalendarEntry testEntry;

    String date = "2019-10-20";
    LocalDate parsedDate = LocalDate.parse(date);

    /**
     * Default constructor for test class CalendarEntryTest
     */
    public CalendarEntryTest() {
    }

    /**
     * Sets up the test fixture
     * Called before every test case method
     *
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        testEntry = new CalendarEntry(parsedDate, "Doctor appointment");
    }

    /**
     * Tests the CalendarEntry getDate method
     */
    @Test
    public void getDate() {
        assertEquals(parsedDate, testEntry.getDate());
        assertNotEquals("Not even the correct data type", testEntry.getDate());
    }

    /**
     * Tests the CalendarEntry setDate method
     */
    @Test
    public void setDate() {
        testEntry.setDate(parsedDate);
        assertEquals(parsedDate, testEntry.getDate());
        assertNotEquals("Not even the correct data type", testEntry.getDate());
    }

    /**
     * Tests the CalendarEntry getEvent method
     */
    @Test
    public void getEvent() {
        assertEquals("Doctor appointment", testEntry.getEvent());
        assertNotEquals("Not a doctor appointment", testEntry.getEvent());
    }

    /**
     * Tests the CalendarEntry setEvent method
     */
    @Test
    public void setEvent() {
        testEntry.setEvent("Football match");
        assertEquals("Football match", testEntry.getEvent());
        assertNotEquals("Not a football match", testEntry.getEvent());

    }

}
