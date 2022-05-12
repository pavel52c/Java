package HashSet;

public class Word {
    private final String letters;
    
    public Word() {
        letters = "";
    }
    
    public Word(String str) {
        letters = str;
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
        return other.letters.equals(this.letters);
    }
//
//    @Override
//    public int hashCode() {
//        return (int)letters.charAt(0) - (int)letters.charAt(letters.length() - 1);
//    }
    
    @Override
    public String toString() {
        return letters;
    }
    
    @Override
    public int hashCode() {
        return letters.length();
    }
    
}
