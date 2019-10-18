import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents the register which has handles all actions
 * done in the application.
 *
 * @author Tormod Lysvold Sjømæling
 */
public class CalendarRegister {
    private Map<LocalDate, String> listOfEntries;

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

    public Map<LocalDate, String> getFromToListOfEntries(LocalDate fromDate, LocalDate toDate) {
        Map<LocalDate, String> fromToListOfEntries= new HashMap<LocalDate, String>();
        for (Map.Entry<LocalDate, String> entry : listOfEntries.entrySet()) {
            if (entry.getKey().isAfter(fromDate) && entry.getKey().isBefore(toDate)) {
                fromToListOfEntries.put(entry.getKey(), entry.getValue());
            }
        }

        return getListOfEntriesSorted(fromToListOfEntries);
    }

    private Map<LocalDate, String> getListOfEntriesSorted(Map<LocalDate, String> fromToListOfEntries) {
        Map<LocalDate, String> treeMap =new TreeMap<LocalDate, String>(fromToListOfEntries);

        for (Map.Entry<LocalDate, String> entry: treeMap.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }

        return treeMap;
    }

    /**
     * Returns the list of calendar entries
     * @return the list of calendar entries
     */
    public Map<LocalDate, String> getAllCalendarEntries() {
        return listOfEntries;
    }
}
