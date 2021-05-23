package inmemorydb;

import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        DatabaseManager databaseManager = new DatabaseManager("myDB");

        //Create column list
        List<Column> columns = new ArrayList<>();
        Column id = new IntegerColumn("id");
        Column name = new StringColumn("name");
        columns.add(id);
        columns.add(name);

        databaseManager.createTable("employee", columns);

        // insert into table
        Map<String, Column> columnMap = new HashMap<>();
        columnMap.put("id", new IntegerColumn("id", 1));
        columnMap.put("name", new StringColumn("name", "John Doe"));

        Table table = new Table("employee");
        table.createRow(String.valueOf(UUID.randomUUID()), columnMap);


    }
}
