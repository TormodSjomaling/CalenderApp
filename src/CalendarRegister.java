import java.io.*;
import java.util.HashMap;
import java.time.LocalDate;
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
     *
     * @param calendarEntry contrains the date and event
     */
    public void addCalendarEntry(CalendarEntry calendarEntry) {
        LocalDate date = calendarEntry.getDate();
        String event = calendarEntry.getEvent();

        listOfEntries.put(date, event);
        appendToFile(listOfEntries);
    }

    private void appendToFile(Map<LocalDate, String> toAdd) {
        try {
            File file = new File("Entries.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(toAdd);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes a calenderEntry from the register
     *
     * @param date LocalDate that user entered
     * @return true if entry got deleted from HashMap, else false
     */
    public boolean deleteCalendarEntryd(LocalDate date) {
        if (listOfEntries.containsKey(date)) {
            listOfEntries.remove(date);

            return true;
        }

        return false;
    }

    /**
     * Deletes a calenderEntry from the register
     *
     * @param toDelete LocalDate that user entered
     * @return true if entry got deleted from HashMap, else false
     */
    public boolean deleteCalendarEntry(LocalDate toDelete) {
        try {
            Map<LocalDate, String> foundEntries = getAllCalendarEntries();
            if (foundEntries.containsKey(toDelete)) {
                foundEntries.remove(toDelete);

                appendToFile(foundEntries);

                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Puts key value pairs which is between our parameters, fromDate and toDate into a new HashMap
     *
     * @param fromDate LocalDate input from user
     * @param toDate LocalDate input from user
     * @return HashMap being sent to getListOfEntriesSorted()
     */
    public Map<LocalDate, String> getFromToListOfEntriesd(LocalDate fromDate, LocalDate toDate) {
        Map<LocalDate, String> fromToListOfEntries= new HashMap<LocalDate, String>();

        for (Map.Entry<LocalDate, String> entry : listOfEntries.entrySet()) {
                if (entry.getKey().isAfter(fromDate) && entry.getKey().isBefore(toDate)) {
                    fromToListOfEntries.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("getFromTo" + fromToListOfEntries);

        return getListOfEntriesSorted(fromToListOfEntries);
    }

    /**
     * Puts key value pairs which is between our parameters,
     * fromDate and toDate into a new HashMap which gets sent for sorting.
     *
     * @param fromDate LocalDate input from user
     * @param toDate LocalDate input from user
     * @return HashMap being sent to getListOfEntriesSorted()
     */
    public Map<LocalDate, String> getFromToListOfEntries(LocalDate fromDate, LocalDate toDate) {
        Map<LocalDate, String> foundEntries = getAllCalendarEntries();
        Map<LocalDate, String> fromToListOfEntries= new HashMap<LocalDate, String>();

        for (Map.Entry<LocalDate, String> entry : foundEntries.entrySet()) {
            if (entry.getKey().isAfter(fromDate) && entry.getKey().isBefore(toDate)) {
                fromToListOfEntries.put(entry.getKey(), entry.getValue());
            }
        }

        return getListOfEntriesSorted(fromToListOfEntries);
    }

    /**
     * Sorts the HashMap and putting them in a TreeMap
     *
     * @param foundEntries Unsorted HashMap sent from getFromToListOfEntries()
     * @return returns sorted TreeMap to Application.java
     */
    private Map<LocalDate, String> getListOfEntriesSortedd(Map<LocalDate, String> foundEntries) {
        Map<LocalDate, String> treeMap =new TreeMap<LocalDate, String>(foundEntries);

        for (Map.Entry<LocalDate, String> entry: treeMap.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }

        return treeMap;
    }

    /**
     * Sorts the HashMap and put them in a TreeMap
     *
     * @param foundEntries Unsorted HashMap sent from getFromToListOfEntries()
     * @return returns sorted TreeMap to Application.java
     */
    private Map<LocalDate, String> getListOfEntriesSorted(Map<LocalDate, String> foundEntries) {
        Map<LocalDate, String> treeMap =new TreeMap<LocalDate, String>(foundEntries);

        for (Map.Entry<LocalDate, String> entry: treeMap.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }

        return treeMap;
    }

    /**
     * Returns the list of calendar entries
     * @return the list of calendar entries
     */
    public Map<LocalDate, String> getAllCalendarEntriesd() {
        return listOfEntries;
    }

    /**
     * Checks our register (file, Entries.txt) for entries and
     * appends them into mapInFile (HashMap).
     * @return returns a HashMap to Application.java
     */
    public Map<LocalDate, String> getAllCalendarEntries(){
        try{
            File file = new File("Entries.txt");

            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fis);

            HashMap<LocalDate, String> mapInFile= (HashMap<LocalDate, String>)ois.readObject();

            ois.close();
            fis.close();

            return mapInFile;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
