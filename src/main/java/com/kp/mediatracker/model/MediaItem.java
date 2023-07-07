package com.kp.mediatracker.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    // Date will be stored on sql table in format: YYYY-MM-DD
    @Column(name = "watched_on")
    @Temporal(TemporalType.DATE)
    private Date watchedOn;

    private boolean favorite;

    @Column(name = "release_year")
    private int releaseYear;

    public MediaItem() {
    }

    public MediaItem(long id, String name, String genre, String category, Date watchedOn, boolean favorite, int releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.category = category;
        this.watchedOn = watchedOn;
        this.favorite = favorite;
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

    public void setWatchedOn(String watchedOn) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.watchedOn = simpleDateFormat.parse(watchedOn);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", category='" + category + '\'' +
                ", watchedOn=" + watchedOn +
                ", favorite=" + favorite +
                ", releaseYear=" + releaseYear +
                '}';
    }
}



