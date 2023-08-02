package Core.MVP;

import Core.Infrastructure.Commands;
import Core.Models.Animal;
import Core.Models.PackAnimal;
import Core.Models.Pet;
import Exceptions.UncorrectDataException;

import java.util.Objects;
import java.util.Scanner;
public class Presenter {

    private final Model model;
    private final View view;
    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void addAnimal() {
        System.out.println("Добавление животного:\n");
        String classNumber = view.setClass();
        System.out.print("\033[H\033[J");
        switch (classNumber) {
            case "1", "2", "3" -> {
                Animal newAnimal = new Pet(view.getName(), view.getBirthday(),
                        new Commands().addCommand(view.getCommands()));
                newAnimal.setId(model.currentBook().count()+1);
                model.currentBook().add(newAnimal
                        );
            }
            case "4", "5", "6" -> {
                Animal newAnimal = new PackAnimal(view.getName(), view.getBirthday(),
                        new Commands().addCommand(view.getCommands()));
                newAnimal.setId(model.currentBook().count()+1);
                model.currentBook().add(newAnimal
                );
            }
            default -> System.out.println("Такх животных нет в питомнике");
        }
    }


    public void addCommand() {
        while (true){
        try {
            int id = findAnimalById().getId();
            for (Animal animal: model.currentBook().getAnimals()) {
                if (animal.getId() == (id)) {
                    System.out.println(animal);
                    animal.getCommands().add(view.getCommands());
                    System.out.println("Команда успешно добавлена!");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("такого id нет, попробуйте еще раз");
        }
        }
    }
    public Animal findAnimalById() {
        Scanner in_finder = new Scanner(System.in);
        System.out.println("Введите id питомца для поиска:\n");
        int id = in_finder.nextInt();
        return model.currentBook().getAnimal(id);
    }
    public Animal findAnimalByName() {
        Scanner in_finder = new Scanner(System.in);
        System.out.println("Введите имя питомца для поиска:\n");
        String name = in_finder.next();
        for (Animal animal: model.currentBook().getAnimals()) {
            if (Objects.equals(animal.getName(), name)) {
                return animal;
            }
        }
        return null;
    }

    public int findAnimal() {
        Scanner in_choice = new Scanner(System.in);
        System.out.println("Для поиска по id нажмите 1:");
        System.out.println("Для поиска по имени нажмите 2:");
        String keyFinder = in_choice.next();
        Animal result = null;
        switch (keyFinder) {
            case "1" -> {
                result = findAnimalById();
                if (result != null){
                System.out.println(result.toString());
                return result.getId();}
                else {System.out.println("Животное с указанным id не найдено");
                return -2;}
            }
            case "2" -> {
                result = findAnimalByName();
                if (result != null){
                System.out.println(result.toString());
                return result.getId();}
                else {System.out.println("Животное с указанным именем не найдено");
                    return -2;}
            }
            default -> {System.out.println("Такой команды нет!");
            return -1;}
        }
    }

    public void remove() {
            Scanner inremove = new Scanner(System.in);
            System.out.println("Введите id питомца для удаления:\n");
            int id = inremove.nextInt();
            if (model.currentBook().getAnimal(id)!= null) {
                System.out.println("вы действительно хотите удалить" +
                        model.currentBook().getAnimal(id).toString()+"?");
                System.out.println("Нажмите 1 для подтверждения удаления");
                System.out.println("Нажмите любую клавишу, кроме 1, для отмены удаления");
                String finalChoice = inremove.next();
                if (finalChoice.equals("1")) {
                    model.currentBook().remove(id);
                    System.out.println("Удаление успешно выполнено");
                }
                else{System.out.println("Удаление отменено");}
            }
            else System.out.println("Id отсутствует в списке, удаление отменено");
        }

    public void saveToFile() {
        model.saveToCSV();
    }

    public void loadFromFile() {
        model.loadFromCSV();
    }


    public void viewAll() {
        System.out.print("\033[H\033[J");
        if (model.currentBook().getAnimals().isEmpty()){
            System.out.print("Записи о животных в базе данных отсутствуют" +
                    ", необходимо добавить животных");
        }
        else {
        for (Animal animal : model.currentBook().getAnimals()) {
            view.setAnimal(animal.getId(), animal.getName(), animal.getBirthday(), model.commandsAct.commandsToString(animal.getCommands()));
        }}
    }

}
