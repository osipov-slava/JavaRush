package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    Controller controller;
    private final String filePath = "./4.JavaCollections/src/"
            + this.getClass().getPackage().getName().replace('.', '/')
            + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {

        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> list) {

        Document document = null;
        try {
            document = getDocument();

            if (document == null) throw new NullPointerException();

            Element template = document.getElementsByClass("template").first();
            Element patternElement = template.clone();
            patternElement.removeAttr("style");
            patternElement.removeClass("template");
            Elements divs = document.select("tr.vacancy");

            if( !divs.isEmpty() )
            {
                for(Element vac : divs)
                {
                    if (!vac.className().equals("vacancy template")) vac.remove();
                }
            }

            for (Vacancy vacancy : list) {
                Element newElement = patternElement.clone();
                newElement.getElementsByClass("city").first().text(vacancy.getCity());
                newElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element a = newElement.getElementsByTag("a").first();
                a.text(vacancy.getTitle());
                a.attr("href", vacancy.getUrl());
                template.before(newElement.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }

    private void updateFile(String data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("file system error");
        }
    }
}
