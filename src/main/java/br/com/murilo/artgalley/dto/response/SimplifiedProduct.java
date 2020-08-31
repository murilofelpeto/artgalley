package br.com.murilo.artgalley.dto.response;

import java.util.UUID;

public class SimplifiedProduct {

    private UUID id;
    private String name;
    private String artist;

    public SimplifiedProduct(final UUID id, final String name, final String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
