package Controller;

import Model.*;
import UI.UserInterace;

import java.util.*;


public class Controller {
        Zoo zoo = new Zoo();
        private final List<Animal> zoopark = new ArrayList<>();
        private final UserInterace ui = new UserInterace();

    private final Map<String, String> mainMenu = new HashMap<String, String>() {{
        put("1", "Add an animal.");
        put("2", "Show all animals: ");
        put("3", "Remove an animal: ");
        put("4", "Teach an animal a new trick");
        put("5", "Show tricks animals do");
        put("6", "Exit");
    }};

    private final Map<String, String> listOfAnimals = new HashMap<String, String>() {{
        put("1", "Cat");
        put("2", "Dog");
        put("3", "Hamster");
    }};


    public void programOn() throws Exception {

        String answer;

        try {

            do {
                answer = choice(mainMenu);

                switch (Objects.requireNonNull(answer)) {
                    case "1" -> {
                        zoo.addAnimal(zoopark, listOfAnimals);
                    }
                    case "2" -> zoo.showAnimals(zoopark);
                    case "3" -> {
                        zoo.showAnimals(zoopark);
                        zoo.deleteAnimal(zoopark);
                    }
                    case "4" -> {
                        zoo.showAnimals(zoopark);
                        zoo.teachTrick(zoo.findAnimalById(zoopark), zoopark);
                    }
                    case "5" -> {
                        zoo.showAnimals(zoopark);
                        zoo.showTricks(zoo.findAnimalById(zoopark), zoopark);
                    }
                }

            } while (!answer.equals("6"));;
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException x) {
            System.out.println("Invalid value. Please, try again.");
            programOn();
        }
    }


    private String choice(Map<String, String> n) throws Exception {
        String answer = ui.menuContext(n);
        if (!answer.isEmpty()) {
            return answer;
        } else return null;
    }

}
