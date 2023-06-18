package Model;

public class CreateAnimal extends Creation {

    public Animal createAnimal(String id, String name, String bday, String color)
    {
        Animal newAnimal = creation(id);
        newAnimal.setName(name);
        newAnimal.setBday(bday);
        newAnimal.setColor(color);
        return newAnimal;
    }
}
