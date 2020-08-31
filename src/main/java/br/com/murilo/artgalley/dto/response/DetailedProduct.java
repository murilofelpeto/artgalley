package br.com.murilo.artgalley.dto.response;

import br.com.murilo.artgalley.dto.CategoryDTO;
import java.util.List;
import java.util.UUID;

public class DetailedProduct {

    private UUID id;
    private String name;
    private List<String> imagesUrl;
    private String artist;
    private Integer year;
    private String techinique;
    private String size;
    private String description;
    private String weight;
    private List<CategoryDTO> categories;

    public DetailedProduct(final UUID id,
                           final String name,
                           final List<String> imagesUrl,
                           final String artist,
                           final Integer year,
                           final String techinique,
                           final String size,
                           final String description,
                           final String weight,
                           final List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.imagesUrl = imagesUrl;
        this.artist = artist;
        this.year = year;
        this.techinique = techinique;
        this.size = size;
        this.description = description;
        this.weight = weight;
        this.categories = categories;
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

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(final List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public String getTechinique() {
        return techinique;
    }

    public void setTechinique(final String techinique) {
        this.techinique = techinique;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(final String weight) {
        this.weight = weight;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(final List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
