package pl.szymongierszewski.znalazlemzgube.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FoundObject {

    @NotEmpty
    @Size(max = 100)
    private String description;
}