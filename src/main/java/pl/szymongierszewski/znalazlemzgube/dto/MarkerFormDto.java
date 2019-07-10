package pl.szymongierszewski.znalazlemzgube.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class MarkerFormDto {

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotBlank
    @Size(min = 3)
    private String name;
    @Email
    private String email;
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    @NotBlank
    @Size(max = 100)
    private String description;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
