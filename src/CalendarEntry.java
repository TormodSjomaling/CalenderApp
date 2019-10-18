import java.time.LocalDate;

/**
 * Represents the CalendarEntry class which stores information
 * about a single calendar entry
 *
 * @author Tormod Lysvold Sjømæling
 */
public class CalendarEntry {

    private LocalDate date;
    private String event;

    /**
     * Constructor
     * */
    public CalendarEntry(LocalDate date, String event){
        this.date = date;
        this.event = event;
    }

    /**
     * Returns the date
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the event
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the event of the
     * @param event
     */
    public void setEvent(String event) {
        this.event = event;
    }
}
