package tests1.demoqa;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class Random {

    @Test
    void RandomEx() {
    String randomString = getRandomString(22);
    System.out.println(randomString);


    String randomMessage = getRandomMessage(22, 100);
    System.out.println(randomMessage);

    int randomInt = getRandomInt (34322, 199999);
    System.out.println(randomInt);
    }
}
