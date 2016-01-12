package com.seliverstov.jokes;

/**
 * Created by a.g.seliverstov on 12.01.2016.
 */
public class Jokes {
    private final static String[] JOKES = new String[]{
            "Nature abhors a vacuum, but not as much as a cat does.",
            "I dressed my dog up as a cat for Halloween. Now he won't come when I call him.",
            "My cat just walked up to the paper shredder and said, \"Teach me everything you know.\"",
            "I bet cats have a secret website where they upload clips of cute humans trying to open DVD packaging and jump-start cars.",
            "The military may have invented the Internet, but not all government schemes have worked as well. In the '60s, the CIA hatched a plan to implant a battery and a microphone in a cat so the furry feline could spy on unsuspecting targets. The program was halted when, after years of research and millions of dollars spent, the spy cat was run over by a cab.",
            "Cats are smarter than dogs. You can't get eight cats to pull a sled through snow.",
            "If someone from the 1950s suddenly appeared, what would be the most difficult thing to explain about life today? One answer: \"I possess a device in my pocket that is capable of accessing the entirety of information known to man. I use it to look at pictures of cats and get into arguments with strangers.\""
    };

    public static String getJoke(int i){
        return (i>=0 && i<JOKES.length)? JOKES[i]: null;
    }

    public static String getRandomJoke(){
        return getJoke((int)Math.floor(Math.random()*JOKES.length));
    }
}
