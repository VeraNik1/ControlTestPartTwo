package Core.Models;

import java.util.ArrayList;

public abstract class Animal {

    private int id;
    private String name;
    private String birthday;
    private ArrayList<String> commands;

    public Animal(String name, String birthday, ArrayList<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else return this.getName().equals(((Animal) obj).getName());
    }
    @Override
    public String toString() {
        return "id: " + this.getId() + " " + "имя: " + this.getName()
                + " " + "дата рождения: " + this.getBirthday()+ " "
                + "команды: " + this.getCommands().toString();
    }
}
