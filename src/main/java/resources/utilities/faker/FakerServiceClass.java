package resources.utilities.faker;

import com.github.javafaker.Faker;


public final class FakerServiceClass {
    private FakerServiceClass() {
    }

    private static final Faker faker = new Faker();


    static String generateRandomCharacter() {
        return faker.rickAndMorty().character();

    }

    static int generateRandom() {
        return faker.number().randomDigit();

    }

    static int generateRandomYear() {
        return faker.date().birthday().getYear();

    }

    static String generateRandomName() {
        return faker.name().name();
    }

    static String generateRandomBook() {
        return faker.book().title();
    }

    static String generateRandomID(int start, int end) {
        return String.valueOf(faker.number().numberBetween(start, end));
    }
    static int generateRandomisbn(int start, int end) {
        return faker.number().numberBetween(start, end);
    }
}
