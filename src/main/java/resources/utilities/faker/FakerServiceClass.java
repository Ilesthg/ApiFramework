package resources.utilities.faker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public final class FakerServiceClass {
    private FakerServiceClass(){

    }
    private static final Faker faker = new Faker();


    public static String generateRandomCharacter() {
        return faker.rickAndMorty().character();

    }

    public static int generateRandomID(int start, int end) {
    return faker.number().numberBetween(start,end);
    }
}
