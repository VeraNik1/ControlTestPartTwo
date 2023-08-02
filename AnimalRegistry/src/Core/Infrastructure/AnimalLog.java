package Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Core.Models.Animal;

public class AnimalLog {

    private final List<Animal> animals;
    
    public AnimalLog() {
        animals = new ArrayList<Animal>();
    }

    // Добавление животного
    public boolean add(Animal animal) {
        boolean flag = false;
        if (!animals.contains(animal)) {
            animals.add(animal);
            flag = true;
        }
        return flag;
    }

    // Вывод животного
    public Animal getAnimal(int id) {
        for (Animal animal:
             animals) {
            if (animal.getId() == id){
                return animal;
            }
          }
        return null;
    }

    // Удаление животного
    public boolean remove(int id) {
        boolean flag = false;
        if (getAnimal(id) != null) {
            animals.remove(id - 1);
            flag = true;
        }
        return flag;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public int count() {
        return animals.size();
    }

}
