package service;

import java.time.LocalDateTime;

public interface INote {
    LocalDateTime getDateTime();

    String getDescription();
}