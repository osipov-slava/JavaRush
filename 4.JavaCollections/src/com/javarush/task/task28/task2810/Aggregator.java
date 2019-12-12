package com.javarush.task.task28.task2810;


import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();

        Provider provider1 = new Provider(new HHStrategy());
        Provider provider2 = new Provider(new MoikrugStrategy());

        Model model = new Model(view, provider1, provider2);

        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();

    }
}
