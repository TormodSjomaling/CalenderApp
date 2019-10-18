import java.time.LocalDate;
import java.util.HashMap;

/**
 * Represents the register which has handles all actions
 * done in the application.
 *
 * @author Tormod Lysvold Sjømæling
 */
public class CalendarRegister {
    private HashMap<LocalDate, String> listOfEntries;

    /**
     * Constructor for objects of class CalendarRegister
     */
    public CalendarRegister(){
        this.listOfEntries = new HashMap<LocalDate, String>();
    }

    /**
     * Adds a calenderEntry to the register
     * @param calendarEntry contrains the date and event
     */
    public void addCalendarEntry(CalendarEntry calendarEntry) {
        LocalDate date = calendarEntry.getDate();
        String event = calendarEntry.getEvent();

        listOfEntries.put(date, event);
    }

    /**
     * Deletes a calenderEntry from the register
     * @param date LocalDate that user entered
     * @return true if entry got deleted from hashmap, else false
     */
    public boolean deleteCalendarEntry(LocalDate date) {
        if (listOfEntries.containsKey(date)) {
            listOfEntries.remove(date);

            return true;
        }

        return false;
    }

    /**
     * Returns the list of calendar entries
     * @return the list of calendar entries
     */
    public HashMap<LocalDate, String> getAllCalendarEntries() {
        return listOfEntries;
    }
}
