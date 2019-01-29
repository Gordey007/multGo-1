package com.multGo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;


@Entity
@Table(name = "cartoons")
public class Cartoon {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_cartoon;

    int season;
//    @Temporal(TemporalType.DATE)
    //private Date release_date;
    private Integer ratung;
    private String name_episode;
    private String name_cartoon_rus;
    @Column
    private String name_cartoon;
    private Integer episode;
    private String description;
    private String abbreviation;


    public Integer getId_cartoon() {
        return id_cartoon;
    }

    public void setId_cartoon(int id_cartoon) {
        this.id_cartoon = id_cartoon;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setId_cartoon(Integer id_cartoon) {
        this.id_cartoon = id_cartoon;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

//    public Date getRelease_date() {
//        return release_date;
//    }
//
//    public void setRelease_date(Date release_date) {
//        this.release_date = release_date;
//    }

    public int getRatung() {
        return ratung;
    }

    public void setRatung(int ratung) {
        this.ratung = ratung;
    }

    public String getName_episode() {
        return name_episode;
    }

    public void setName_episode(String name_episode) {
        this.name_episode = name_episode;
    }

    public String getName_cartoon_rus() {
        return name_cartoon_rus;
    }

    public void setName_cartoon_rus(String name_cartoon_rus) {
        this.name_cartoon_rus = name_cartoon_rus;
    }

    public String getName_cartoon() {
        return name_cartoon;
    }

    public void setName_cartoon(String name_cartoon) {
        this.name_cartoon = name_cartoon;
    }
}
