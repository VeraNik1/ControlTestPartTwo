package UI;

import java.util.Scanner;

import Core.MVP.View;
import Core.Models.Animal;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in, "ibm866");
    }

    @Override
    public String setClass() {
        System.out.println("1 - Кошка");
        System.out.println("2 - Собака");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Лошадь");
        System.out.println("5 - Верблюд");
        System.out.println("6 - Осел");
        System.out.printf("Введите номер вида животного: ");
        return in.nextLine();
    }

    @Override
    public String getName() {
        System.out.printf("Имя: ");
        return in.nextLine();
    }

    @Override
    public void setName(String value) {
        System.out.printf("Имя: %s\n", value);
    }

    @Override
    public String getBirthday() {
        System.out.printf("Дата рождения: ");
        return in.nextLine();
    }
    @Override
    public void setBirthday(String value) {
        System.out.printf("Дата рождения: %s\n", value); 
    }

    @Override
    public String getCommands() {
        System.out.printf("Добавить команду: ");
        return in.nextLine();
    }

    @Override
    public void setCommands(String value) {
        System.out.printf("Команды: %s\n", value);
    }

    @Override
    public void setAnimal(int id, String name, String birthday, String commands) {
        System.out.printf("ID: %d Имя: %-10.10s Дата рождения: %-10.10s Команды: %s \n", id, name, birthday, commands);
    }

    

    
}
