package work;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    int id;
    String name, address, description, date;

    public Person(ResultSet set) throws SQLException {

        this.id = set.getInt("id");
        this.name = set.getString("name");
        this.address = set.getString("address");
        this.description = set.getString("description");
        this.date = set.getString("date");

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
