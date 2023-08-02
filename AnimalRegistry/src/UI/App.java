package UI;

import java.util.Scanner;

import Core.MVP.Presenter;
import Core.MVP.View;
import Client.Config;
import Core.Infrastructure.Counter;
import Exceptions.UncorrectDataException;
import Core.Infrastructure.Counter;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.loadFromFile();
        Counter count = new Counter();

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nНавигация:");
                System.out.println("1 - показать список всех питомцев");
                System.out.println("2 - добавить питомца");
                System.out.println("3 - удалить питомца");
                System.out.println("4 - поиск питомца");
                System.out.println("5 - добавить команду");
                System.out.println("0 - выход");
                System.out.print("Выберите действие: ");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1" -> {
                        System.out.print("\033[H\033[J");
                        presenter.viewAll();
                    }
                    case "2" -> {
                        System.out.print("\033[H\033[J");
                        try {
                            presenter.addAnimal();
                            count.add();
                            System.out.println("ОК");
                        } catch (UncorrectDataException e) {
                            System.out.println(e.getMessage());
                        }
                        presenter.saveToFile();
                    }
                    case "3" -> {
                        System.out.print("\033[H\033[J");
                        presenter.remove();
                        System.out.print("\033[H\033[J");
                        presenter.saveToFile();
                        presenter.loadFromFile();
                    }
                    case "4" -> {
                        System.out.print("\033[H\033[J");
                        presenter.findAnimal();
                    }
                    case "5" -> {
                        System.out.print("\033[H\033[J");
                        presenter.addCommand();
                        presenter.saveToFile();
                        presenter.loadFromFile();
                    }

                    case "0" -> System.exit(0);
                    default -> System.out.println("Такой команды нет");
                }
            }
        }

    }
}
