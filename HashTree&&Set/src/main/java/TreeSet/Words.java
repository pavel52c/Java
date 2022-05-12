package TreeSet;

public class Words implements Comparable<Words> {
    private String word;
    
    public String getWord() {
        return word;
    }
    
    public Words() {
        this.word = "";
    }
    
    public Words(String s) {
        this.word = s;
    }
    
    @Override
    public int compareTo(Words w) {
        return this.word.length() - w.word.length();
    }
    
    @Override
    public String toString() {
        return word;
    }
    
}
