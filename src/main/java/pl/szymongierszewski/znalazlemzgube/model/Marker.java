package pl.szymongierszewski.znalazlemzgube.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "markers")
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "geolocation")
    private Geolocation geolocation;

    @NotNull
    @Column(name = "finder")
    private Finder finder;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "found_object")
    private FoundObject foundObject;

    public Marker() {
    }

    public Long getId() {
        return id;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public Finder getFinder() {
        return finder;
    }

    public void setFinder(Finder finder) {
        this.finder = finder;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FoundObject getFoundObject() {
        return foundObject;
    }

    public void setFoundObject(FoundObject foundObject) {
        this.foundObject = foundObject;
    }
}
