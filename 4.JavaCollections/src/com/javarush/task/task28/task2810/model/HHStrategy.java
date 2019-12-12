package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int i=0;
        do {
            try {
                Document document = getDocument(searchString,i++);
                Elements vacs = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (vacs.size()==0) break;
                for (Element src : vacs) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(src.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(src.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(src.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text().trim());
                    vacancy.setSalary(src.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vacancy.setSiteName("http://hh.ua");

                    Element link = src.select("a").first();
                    vacancy.setUrl(link.attr("abs:href"));
                    vacancies.add(vacancy);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        try {
            Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                    .referrer("")
                    .get();
            String s = document.html();
            return document;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
