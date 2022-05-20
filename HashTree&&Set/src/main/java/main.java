import java.util.*;

public class main {
    public static void main(String[] args) {

        String s = "My name is Pavel and i'm living in Rostov on Don";
        String[] splitStr = s.split(" ");

        Set<Word> hashSet = new HashSet<>();

        for (String word : splitStr) {
            hashSet.add(new Word(word));
        }
        for (Word word : hashSet) {
            System.out.println(word + " " + word.hashCode() + " ");
        }
        System.out.println();

        SortedSet<Word> mySet = new TreeSet<>(new Comparator<Word>() {
            public int subChar(Word word) {
                if (word.length() == 0)
                    return 0;
                else if (word.length() == 1)
                    return word.getWord().charAt(0);
                return word.getWord().charAt(0) - word.getWord().charAt(word.length() - 1);
            }

            @Override
            public int compare(Word word1, Word word2) {
                if (subChar(word1) > subChar(word2))
                    return 1;
                else if (subChar(word1) < subChar(word2))
                    return -1;
                else {
                    return 0;
                }
            }
        });

        for (String word : splitStr) {
            mySet.add(new Word(word));
        }

        //сортировка через Comparator
        System.out.println(mySet);
        System.out.println();

        //сортировка через Comparable
        Set<Word> treeSet = new TreeSet<>();
        for (String word : splitStr) {
            treeSet.add(new Word(word));
        }
        System.out.println(treeSet);
    }
}
