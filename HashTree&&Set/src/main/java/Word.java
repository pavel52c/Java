import java.util.Objects;

public class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
        this.word = "";
    }

    public int length() {
        return word.length();
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Word obj) {
        if (length() > obj.length())
            return 1;
        else if (length() < obj.length())
            return -1;
        else {
            if (this.equals(obj))
                return 0;
            else
                return word.charAt(0) > obj.getWord().charAt(0) ? 1 : (word.charAt(0) == obj.getWord().charAt(0) ? 0 : -1);
        }
    }

//    @Override
//    public int compareTo(Word o) {
//        if (word.charAt(0) > o.getWord().charAt(0))
//            return 1;
//        else if (word.charAt(0) < o.getWord().charAt(0))
//            return -1;
//        else
//            return 0;
//    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Word other = (Word) obj;
        return other.word.equals(this.word);
    }

    @Override
    public int hashCode() {
        String s = "abcdeif";
        int hash = 0;
        for (String ch : word.split("")) {
            if (s.contains(ch))
                hash += ch.charAt(0);
        }
        return hash;
    }

//    @Override
//    public int hashCode() {
//        if (word.length() != 0) {
//            int hash = 9;
//            for (String s : word.split("")) {
//                for (Character ch : s.toCharArray()) {
//                    hash += ch;
//                }
//            }
//            return hash;
//        }
//        return 0;
//    }

}
