package Adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        // Set initial date
        dateAdapter.setYear(2023);
        dateAdapter.setMonth(11);  // November
        dateAdapter.setDay(10);
        System.out.println("Initial date:");
        System.out.printf("%d-%02d-%02d%n", dateAdapter.getYear(), dateAdapter.getMonth(), dateAdapter.getDay());

        // Advance the date by 5 days
        dateAdapter.advanceDays(5);
        System.out.println("Date after advancing 5 days:");
        System.out.printf("%d-%02d-%02d%n", dateAdapter.getYear(), dateAdapter.getMonth(), dateAdapter.getDay());

        // Advance the date by 30 more days
        dateAdapter.advanceDays(30);
        System.out.println("Date after advancing 30 more days:");
        System.out.printf("%d-%02d-%02d%n", dateAdapter.getYear(), dateAdapter.getMonth(), dateAdapter.getDay());
    }
}
