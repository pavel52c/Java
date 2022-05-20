import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    Person person = new Person();

    @Test
    public void tests() {

        assertEquals(person.getFullNameWithHistory(2005), "(  ) (  )");
        assertEquals(person.getFullName(2005), "Incognito");

        person.changeFirstName(2011, "firstName2011");
        person.changeFirstName(2009, "firstName2009");
        person.changeFirstName(2005, "firstName2005");
        person.changeFirstName(2001, "firstName2001");
        person.changeFirstName(2000, "firstName2000");
        person.changeFirstName(1999, "firstName1999");

        person.changeLastName(2006, "lastName2006");
        person.changeLastName(2005, "lastName2005");
        person.changeLastName(2001, "lastName2001");
        person.changeLastName(1999, "lastName1999");

        assertEquals("firstName2005 ( firstName2001, firstName2000, firstName1999 ) lastName2005 ( lastName2001, lastName1999 )", person.getFullNameWithHistory(2005));
        assertEquals("firstName2009 ( firstName2005, firstName2001, firstName2000, firstName1999 ) ( lastName2006, lastName2005, lastName2001, lastName1999 )", person.getFullNameWithHistory(2009));
        assertEquals("( firstName2001, firstName2000, firstName1999 ) ( lastName2001, lastName1999 )", person.getFullNameWithHistory(2004));
        assertEquals("firstName2005 lastName2005", person.getFullName(2005));
        assertEquals("firstName2009 with unknown last name", person.getFullName(2009));
        assertEquals(person.getFullName(2006), "lastName2006 with unknown first name", person.getFullName(2006));

    }

}
