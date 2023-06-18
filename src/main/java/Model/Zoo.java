package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import UI.UserInterace;

public class Zoo extends CreateAnimal {
    List<Animal> zoopark = new ArrayList<>();
    UserInterace ui = new UserInterace();

    public void addAnimal(List<Animal> zoo, Map<String, String> s)
    {
        System.out.println("Enter id of one of the types: ");
        String str = ui.menuContext(s);
        if (!(str.isEmpty() || str.equals("0"))) {
            Animal an = createAnimal(str,
                    ui.getStr("Enter its name: "),
                    ui.getStr("Enter its birthdate:"),
                    ui.getStr("Enter its color:"));
            zoo.add(an);
        }
        else System.out.println("Your id is invalid. Try again, please.");
    }

    public void deleteAnimal(List<Animal> a)
    {
        if (!a.isEmpty()) {
            try {
                a.remove(findAnimalById(a));
            } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException x) {
                System.out.println("Invalid id. Please, try again.");
            }
        }
    }


    public void showAnimals(List<Animal> an)
    {
        if (!an.isEmpty()) {
            for (Animal s : an) {
                System.out.println("-----------------------------------------------------");
                System.out.println("ID: " + an.indexOf(s) + "\nType: " + s.getClass().getSimpleName() + "\nName: " + s.getName() +
                        "\nBirthdate: " + s.getBday() + "\nColor: " + s.getColor());
                System.out.println("-----------------------------------------------------");
            }
        } else System.out.println("There are no animals so far");

    }

    public Animal findAnimalById(List<Animal> e)
    {
        if (!e.isEmpty()) {
            String id = ui.getStr("Enter id: ");
            int id2 = Integer.parseInt(id);
            if (id.isBlank()) {
                System.out.println("The value is invalid. Please, try again.");
                return null;
            }
            return e.get(id2);
        }
        return null;
    }

    public void teachTrick(Animal a, List<Animal> e)
    {
        if (!e.isEmpty()) {
            try {
                a.commands.add(ui.getStr("What do you want to teach the pet?"));
            } catch (IndexOutOfBoundsException s) {
                System.out.println("Something went wrong.");
            }
        }
    }

    public void showTricks(Animal a, List<Animal> e) {
        try {
            if (!a.commands.isEmpty()) {
                String tricks = String.join(", ", a.commands);
                System.out.println("It can do these tricks: " + tricks);
            } else System.out.println("It can't do tricks yet");
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException x) {
            System.out.println("You can't do that right now.");
        }
    }
}
