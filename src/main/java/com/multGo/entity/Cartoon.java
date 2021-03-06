package com.multGo.entity;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Table(name = "cartoons")
public class Cartoon {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_cartoon;

    int season;
//    @Temporal(TemporalType.DATE)
    //private Date release_date;
//    private Integer ratung;
     String name_episode;
     String name_cartoon_rus;
     @Column(name = "name_cartoon")
     String name;
     Integer episode;
     String description;
     String abbreviation;
     private final String path = "../img/Rick and Morty/";


    public String getPoster() {

        return path+season+"/"+(episode+(100*season))+".jpg";
    }

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

//    public int getRatung() {
//        return ratung;
//    }

//    public void setRatung(int ratung) {
//        this.ratung = ratung;
//    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
