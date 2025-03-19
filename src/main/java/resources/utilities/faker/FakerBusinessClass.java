package resources.utilities.faker;

public final class FakerBusinessClass {
    public static String generatetTitle() {
        return FakerServiceClass.generateRandomCharacter();
    }

    public static String generateID() {
        return FakerServiceClass.generateRandomID(3, 80);
    }
    public static int generateISBN() {
        return FakerServiceClass.generateRandomisbn(3, 80);
    }

    public static int generateViews() {
        return FakerServiceClass.generateRandom();
    }
    public static int generateYear() {
        return FakerServiceClass.generateRandomYear();
    }

    public static String generateName() {
        return FakerServiceClass.generateRandomName();
    }
    public static String generateBook() {
        return FakerServiceClass.generateRandomBook();
    }
}


