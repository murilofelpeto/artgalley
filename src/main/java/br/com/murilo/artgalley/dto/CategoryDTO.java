package br.com.murilo.artgalley.dto;

import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    private String name;

    public CategoryDTO(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
