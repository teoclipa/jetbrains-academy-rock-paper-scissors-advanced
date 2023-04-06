package rockpaperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Option {
    private String option;
    private static final Random rand = new Random();

    public static String randomOption(List<String> choices) {

        return choices.get(rand.nextInt(choices.size()));
    }
}