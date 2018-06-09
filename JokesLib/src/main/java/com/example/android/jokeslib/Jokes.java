package com.example.android.jokeslib;

import java.util.Random;

public class Jokes {
    private static Random random = new Random();
    private static String[] jokes = {"What's brown and sticky? Sticks!",
                                    "I invented a new word today.\n" +
                                            "\n" +
                                            "Plagiarism",
                                    "Q: Why was six scared of seven? \n" +
                                            "A: Because seven \"ate\" nine.",
                                    "Q: What starts with E, ends with E, and has only 1 letter in it? \n" +
                                            "A: Envelope."};
    public static String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
