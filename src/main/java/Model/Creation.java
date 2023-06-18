package Model;

public class Creation {
    public Animal creation(String n)
    {
        return switch (n) {
            case "1" -> new Cat();
            case "2" -> new Dog();
            case "3" -> new Hamster();
            default -> null;
        };
    }
}
