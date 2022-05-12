package HashSet;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Word> h = new HashSet<>();

        h.add(new Word("cat"));
        h.add(new Word("dog"));
        h.add(new Word("fish"));
        h.add(new Word("squirrel"));

        System.out.println(h);
        
    }
}
