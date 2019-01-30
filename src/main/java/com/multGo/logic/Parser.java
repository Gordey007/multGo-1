package com.multGo.logic;

import com.multGo.entity.Cartoon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    String URL;
    Document doc = null;
    Cartoon cartoon;
    ArrayList<Cartoon> cartoonArray;

    public Parser(String URL) {
        this.URL = URL;
    }

    public ArrayList<Cartoon> startParser(){
        cartoonArray = new ArrayList<>();

        try {
            doc = Jsoup
                    .connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 5000)
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String name = "Rick and Morty";
        String nameRUS = "Рик и Морти";
        int season = 3;


        Element table = doc.select("table").get(2); //select the first table.
        Elements rows = table.select("tr");

        int ep = 1;
        for (int i = 0; i < rows.size(); i++) {
            cartoon = new Cartoon();
            cartoon.setName_cartoon(name);
            cartoon.setName_cartoon_rus(nameRUS);
            try {
                System.out.println(rows.get(i).select("a").get(1).text());
                cartoon.setName_episode(rows.get(i).select("a").get(1).text());
            } catch (Exception e) {
                System.out.println(rows.get(i).select("td").first().text());
                cartoon.setEpisode(ep++);
                cartoon.setDescription(rows.get(i).select("td").first().text());
                cartoonArray.add(cartoon);
            }
        }
        return cartoonArray;
    }


}
