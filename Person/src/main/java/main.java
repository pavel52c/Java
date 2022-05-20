public class main {
    public static void main(String[] args) throws Exception{
        Person a = new Person();
        a.changeFirstName(2001,"Nastya");
        a.changeFirstName(2019,"Nastya");
        a.changeFirstName(2021,"Olya");
        a.changeFirstName(2004,"Natasha");
        a.changeFirstName(2016,"Nastya");
        a.changeFirstName(2015,"Nastya");
        a.changeLastName(2004,"Lobova");
        a.changeLastName(2020,"Ivanova");
        a.changeLastName(2016,"Krasnova");
        a.changeLastName(2015,"Olonech");
        a.changeLastName(2001,"Lobova");

        System.out.println(a.getFullName(2021));
        System.out.println(a.getFullNameWithHistory(2030));
    }
}
