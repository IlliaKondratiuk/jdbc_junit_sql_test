import org.junit.Test;
import work.Person;
import work.SQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMYSQL {

    @Test
    public void testFindNameByID() throws SQLException {
        SQuery query = new SQuery();
        System.out.println(query.getPersonNameById("4"));
    }

    @Test
    public void testFindAllWithAddress() throws SQLException {
        SQuery query = new SQuery();
        List<Person> people = new ArrayList<>(query.selectAllWithSameAddress("Kyiv"));
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}
