import java.util.*;

public class Person {

    private final Map<Integer, String> historyOfFirstNames;
    private final Map<Integer, String> historyOfLastNames;

    public Person() {
        historyOfFirstNames = new HashMap<Integer, String>();
        historyOfLastNames = new HashMap<Integer, String>();
    }

    void changeFirstName(int year, String first_name) {
        if (!historyOfFirstNames.containsKey(year)) {
            historyOfFirstNames.put(year, first_name);
        }
    }

    void changeLastName(int year, String last_name) {
        if (!historyOfLastNames.containsKey(year)) {
            historyOfLastNames.put(year, last_name);
        }
    }

    String getFullName(int year) {
        if (historyOfFirstNames.containsKey(year) || historyOfLastNames.containsKey(year)) {

            if (historyOfFirstNames.containsKey(year) && historyOfLastNames.containsKey(year)) {
                return historyOfFirstNames.get(year) + " " + historyOfLastNames.get(year);
            } else if (historyOfFirstNames.containsKey(year) && !historyOfLastNames.containsKey(year)) {
                return historyOfFirstNames.get(year) + " with unknown last name";
            } else {
                return historyOfLastNames.get(year) + " with unknown first name";
            }

        } else {
            return "Incognito";
        }

    }

    private void setNames(List<Integer> keyOfName, List<String> resNames, Map<Integer, String> historyNames) {
        for (int i = 0; i < keyOfName.size(); i++) {
            if (i == 0) {
                resNames.add(historyNames.get(keyOfName.get(i)));
            } else if (historyNames.get(keyOfName.get(i)) != resNames.get(i - 1)) {
                resNames.add(historyNames.get(keyOfName.get(i)));
            }
        }
    }

    String getFullNameWithHistory(int year) {

        List<Integer> keysOfFirstNames = new ArrayList<Integer>();
        List<Integer> keysOfLastNames = new ArrayList<Integer>();

        historyOfFirstNames.keySet().stream().sorted((Integer a, Integer b) -> b.compareTo(a)).filter(x -> x < year).forEach(x -> keysOfFirstNames.add(x));
        historyOfLastNames.keySet().stream().sorted((Integer a, Integer b) -> b.compareTo(a)).filter(x -> x < year).forEach(x -> keysOfLastNames.add(x));

        List<String> firstNames = new ArrayList<String>();
        List<String> lastNames = new ArrayList<String>();

        setNames(keysOfFirstNames, firstNames, historyOfFirstNames);

        setNames(keysOfLastNames, lastNames, historyOfLastNames);

        String[] fullName = this.getFullName(year).split(" ");

        String oldFirstNames = "";
        String oldLastNames = "";

        for (String first : firstNames) {
            oldFirstNames += ", " + first;
        }

        for (String last : lastNames) {
            oldLastNames += ", " + last;
        }

        oldFirstNames = oldFirstNames.replaceFirst(", ", "");
        oldLastNames = oldLastNames.replaceFirst(", ", "");

        if (fullName.length == 2) {
            return fullName[0] + " ( " + oldFirstNames + " ) " + fullName[1] + " ( " + oldLastNames + " )";
        } else if (fullName.length == 1) {
            return "( " + oldFirstNames + " ) " + "( " + oldLastNames + " )";
        } else if (fullName[fullName.length - 2].equals("last")) {
            return fullName[0] + " ( " + oldFirstNames + " )" + " ( " + oldLastNames + " )";
        } else if (fullName[fullName.length - 2].equals("first")) {
            return "( " + oldFirstNames + " ) " + fullName[0] + " ( " + oldLastNames + " )";
        } else {
            return "";
        }
    }


    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getFullNameWithHistory(2005));
        System.out.println(person.getFullName(2005));
        person.changeFirstName(2001, "firstName2001");
        person.changeFirstName(2000, "firstName2000");
        person.changeFirstName(2005, "firstName2005");
        person.changeFirstName(1999, "firstName1999");
        person.changeLastName(1999, "lastName1999");
        person.changeLastName(2005, "lastName2005");
        person.changeLastName(2001, "lastName2001");
        person.changeFirstName(2011, "firstName2011");
        person.changeFirstName(2009, "firstName2009");
        System.out.println(person.getFullNameWithHistory(2005));
    }
}
