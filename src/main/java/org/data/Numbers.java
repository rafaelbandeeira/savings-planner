package org.data;

import java.util.Random;

public class Numbers {
    public static String getRandomInt(int min, int max) {
        Random random = new Random();
        return String.valueOf(random.nextInt(max - min) + min);
    }
}
