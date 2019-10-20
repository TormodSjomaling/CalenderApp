import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Map;

/**
 * The test class of CalendarRegister
 *
 * @author Tormod Lysvold Sjømæling
 */
public class CalendarRegisterTest {

    private CalendarRegister testRegister;
    private CalendarEntry testEntry;

    private Map<LocalDate, String> testListOfEntries;

    String date = "2019-10-20";
    LocalDate parsedDate = LocalDate.parse(date);
    String event = "something is happening this day";

    /**
     * Default constructor for test class CalendarRegister
     */
    public CalendarRegisterTest() {
    }

    /**
     * Sets up the test fixture
     * Called before every test case method
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        testRegister = new CalendarRegister();
        testListOfEntries = new HashMap<LocalDate, String>();
    }

    /**
     * Tests the addCalendarEntry method
     */
    @Test
    public void addCalendarEntry () {
        testListOfEntries.put(parsedDate, event);
        assertEquals(event, testListOfEntries.get(parsedDate));
        assertNotEquals("nothing special this day", testListOfEntries.get(parsedDate));
    }

    /**
     * Tests if object that got written to file actually
     * got written to file, by reading the file.
     *
     * This test kind of tests my getAllCalenderEntries also.
     *
     * @throws Exception
     */
    @Test
    public void appendToFile() throws Exception{
        File file = new File("EntriesTest.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(testListOfEntries);

        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);

        HashMap<LocalDate, String> mapInFile= (HashMap<LocalDate, String>)ois.readObject();

        assertTrue(mapInFile.isEmpty());
    }
}
