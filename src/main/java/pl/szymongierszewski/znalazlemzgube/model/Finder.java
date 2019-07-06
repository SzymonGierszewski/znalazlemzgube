package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Finder {

    @NotBlank
    @Size(min = 3)
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}")
    private String phoneNo;
}
