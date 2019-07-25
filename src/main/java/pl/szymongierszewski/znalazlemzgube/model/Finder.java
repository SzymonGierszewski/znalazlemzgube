package pl.szymongierszewski.znalazlemzgube.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "finders")
public class Finder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

//    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}")
//    @Column(name = "phone_number")
//    private String phoneNo;


    public Finder() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
