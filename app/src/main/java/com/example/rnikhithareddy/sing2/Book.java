package com.example.rnikhithareddy.sing2;

/**
 * Created by R NIKHITHA REDDY on 4/7/2018.
 */

public class Book {


    String authr;
    String tit;
    String genre;

    Book(){
        authr="null";
        tit="null";
        genre="null";
    }
    Book(String a,String t,String g){
        authr=a;
        tit=t;
        genre=g;

    }

    public String getAuthr() {
        return authr;
    }

    public void setAuthr(String authr) {
        this.authr = authr;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
