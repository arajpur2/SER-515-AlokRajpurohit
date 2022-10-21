/**
 * Visitor Design pattern
 * Facade Design Pattern
 * The client of the visitor pattern. This class will use the visitor to visit all the products and trading of a given user
 */

@SuppressWarnings("all")
public class Reminder {
    private String reminderName;

    private String reminderDescription;

    private String reminderDeadline;

    public Reminder(String reminderName, String reminderDescription, String reminderDeadline) {
        this.reminderName = reminderName;
        this.reminderDescription = reminderDescription;
        this.reminderDeadline = reminderDeadline;
    }

    public String getReminderName() {
        return reminderName;
    }

    public String getReminderDescription() {
        return reminderDescription;
    }

    public String getReminderDeadline() {
        return reminderDeadline;
    }

    public void showReminder(){
        System.out.println("NEW REMINDER CREATED SUCCESSFULLY!");
    }
}
