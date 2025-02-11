package model;

import service.INote;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note implements INote {
    private final LocalDateTime dateTime;
    private final String description;

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter) + " - " + description;
    }
}