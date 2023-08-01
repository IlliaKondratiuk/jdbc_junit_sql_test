package work;

import config.State;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQuery extends State {
    public List<Person> selectAllWithSameAddress(String address) throws SQLException {

         ResultSet set = getStatement().executeQuery("SELECT * FROM sys.table_info WHERE address = \"" + address + "\"");
        List<Person> people = new ArrayList<>();
        while (set.next()) {
            people.add(new Person(set));
        }

        return people;
    }

    public String getPersonNameById(String id) throws SQLException {
        ResultSet set = getStatement().executeQuery("SELECT * FROM sys.table_info WHERE id = " + id);
        set.next();
        Person person = new Person(set);

        return person.name;
    }
}