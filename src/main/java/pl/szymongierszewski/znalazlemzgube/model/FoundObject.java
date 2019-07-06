package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FoundObject {

    @NotBlank
    @Size(max = 100)
    private String description;
}
