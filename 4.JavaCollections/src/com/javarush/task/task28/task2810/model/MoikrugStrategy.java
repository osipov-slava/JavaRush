package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int i=0;
        do {
            try {
                Document document = getDocument(searchString,i++);
                Elements vacs = document.getElementsByClass("job");
                if (vacs.size()==0) break;
                for (Element src : vacs) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(src.getElementsByClass("title").first().text());
                    vacancy.setCity(src.getElementsByClass("location").text());
                    vacancy.setCompanyName(src.getElementsByClass("company_name").text());
                    vacancy.setSalary(src.getElementsByClass("salary").text());
                    vacancy.setSiteName("https://moikrug.ru");

                    Element link = src.select("a").first();
                    vacancy.setUrl(vacancy.getSiteName() + src.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());
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
