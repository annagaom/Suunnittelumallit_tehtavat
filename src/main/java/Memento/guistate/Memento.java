package Memento.guistate;

import java.time.LocalDateTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected, LocalDateTime timestamp) {
        this.options = options.clone(); // Clone to ensure immutability
        this.isSelected = isSelected;
        this.timestamp = timestamp;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of the options
    }

    public boolean isSelected() {
        return isSelected;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMetadata() {
        return "Options: [" + options[0] + ", " + options[1] + ", " + options[2] + "], Selected: " + isSelected + ", Timestamp: " + timestamp.toString();
    }
}
