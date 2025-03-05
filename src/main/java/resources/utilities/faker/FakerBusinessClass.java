package resources.utilities.faker;

public final class FakerBusinessClass {
    public static String generatetTitle(){
    return FakerServiceClass.generateRandomCharacter();
    }
    public static int generateID(){
       return FakerServiceClass.generateRandomID(3,80);
    }
}
