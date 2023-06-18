package Model;

public enum GetSpec {
    Cat, Dog, Hamster;

    public static GetSpec getSpec (int id){
        return switch (id) {
            case 1 -> GetSpec.Cat;
            case 2 -> GetSpec.Dog;
            case 3 -> GetSpec.Hamster;
            default -> null;
        };
    }
}