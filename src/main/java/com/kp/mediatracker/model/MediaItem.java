package com.kp.mediatracker.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="MediaItems")
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String genre;
    private String category;

    @Column(name = "watched_on")
    private Date watchedOn;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @Column(name = "release_year")
    private int releaseYear;

    public MediaItem() {
    }

    public MediaItem(long id, String name, String genre, String category, Date watchedOn, boolean isFavorite, int releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.category = category;
        this.watchedOn = watchedOn;
        this.isFavorite = isFavorite;
        this.releaseYear = releaseYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getWatchedOn() {
        return watchedOn;
    }

    public void setWatchedOn(Date watchedOn) {
        this.watchedOn = watchedOn;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", category='" + category + '\'' +
                ", watchedOn=" + watchedOn +
                ", isFavorite=" + isFavorite +
                ", releaseYear=" + releaseYear +
                '}';
    }
}



