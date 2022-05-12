package TreeSet;

import java.util.Comparator;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
        TreeSet<Words> words = new TreeSet();

        words.add(new Words("one"));
        words.add(new Words("two"));
        words.add(new Words("three"));
        words.add(new Words("four"));
        words.add(new Words("five"));

        System.out.println(words);

        Comparator<Words> comparator = new Comparator<Words>() {
            public int compare(Words w1, Words w2) {
                int code1 = 0, code2 = 0;
                for (char c : w1.getWord().toCharArray()) code1 += c;
                for (char c : w2.getWord().toCharArray()) code2 += c;
                return Integer.compare(code1, code2); // (code1 < code2) ? -1 : ((code1 == code2) ? 0 : 1)
            }
        };



        TreeSet<Words> words2 = new TreeSet(comparator);
        words2.add(new Words("one"));
        words2.add(new Words("eno"));
        words2.add(new Words("three"));
        words2.add(new Words("four"));

        System.out.println(words2);
    }

}
