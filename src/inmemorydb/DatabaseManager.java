package inmemorydb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {

    private String dbName;
    private Map<String, Table> tableMap;

    public DatabaseManager(String dbName) {
        this.dbName = dbName;
        tableMap = new HashMap<>();
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Map<String, Table> getTableMap() {
        return tableMap;
    }

    public void setTableMap(Map<String, Table> tableMap) {
        this.tableMap = tableMap;
    }

    public void createTable(String tableName, List<Column> columns) {
        if (tableMap.containsKey(tableName)) {
            System.out.println("Table Already Exists");
        } else {
            Table table = new Table(tableName, columns);
            tableMap.put(tableName, table);
            System.out.println("Table " + tableName + " created successfully with the following columns.");
            for (Column c : columns) {
                System.out.println(c.getColumnName());
            }
        }
    }
}
