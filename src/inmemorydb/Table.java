package inmemorydb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Table {

    private String tableName;
    private Map<String, Row> rows;
    private List<Column> columns;

    public Table(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
        this.rows = new HashMap<>();
    }

    public Table(String tableName) {
        this.tableName = tableName;
        this.rows = new HashMap<>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Row> getRows() {
        return rows;
    }

    public void setRows(Map<String, Row> rows) {
        this.rows = rows;
    }

    public void createRow(String pKey, Map<String, Column> columnMap) {
        if (rows.containsKey(pKey)) {
            System.out.println("Insertion Failed, Duplicate primary key found.");
            return;
        }
        Row row = new Row(pKey, columnMap);
        rows.put(pKey,row);
        System.out.println("Insert Succeeded for key =" + pKey);
    }

    public List<Row> searchTable(Map<String, Column> columnsToSearch) {
        List<Row> result = new ArrayList<>();
        List<Row> allRows = new ArrayList<>(rows.values());
        for (Map.Entry<String, Column> entry : columnsToSearch.entrySet()) {
            result.addAll(
                    allRows
                            .stream()
                            .filter(row -> row.doesRowExist(entry.getKey(), entry.getValue()))
                            .collect(Collectors.toList())
            );
        }
        return result;
    }

    public void updateRow(String pKey, HashMap<String, Column> columnMap) {
        if (!rows.containsKey(pKey)) {
            System.out.println("Update Failed, no primary key found.");
            return;
        }
        Row row = rows.get(pKey);
        columnMap.forEach((key, value) -> {
            row.getColumnMap().put(key, value);
        });
        System.out.println("Update Succeeded for key =" + pKey);
    }
}
