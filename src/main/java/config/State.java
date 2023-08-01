package config;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

    public static Statement getStatement() {
        return statement;
    }

    private static Statement statement;

    public State() {
        try {
            makeState();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Statement makeState() throws SQLException {
        Connect c;
        c = new Connect();
        Connection con = c.newConnection();
        statement = con.createStatement();
        return statement;
    }

    @Test
    public void selectAll() throws SQLException {
       ResultSet set = statement.executeQuery("SELECT * FROM sys.table_info;");
       while (set.next()) {
           System.out.println(set.getString("id") + ' ' + set.getString("name"));
       }
    }

    public List<Map<String, String>> getRows() throws SQLException {
        ResultSet set = statement.executeQuery("SELECT * FROM sys.table_info");
        List<Map<String, String>> list = new ArrayList<>();
        while (set.next()) {
            Map<String, String> map = new HashMap<>();

            map.put("id", set.getString("id"));
            map.put("name", set.getString("name"));
            map.put("address", set.getString("address"));
            map.put("date", set.getString("date"));
            map.put("description", set.getString("description"));

            list.add(map);
        }
        return list;
    }
}
