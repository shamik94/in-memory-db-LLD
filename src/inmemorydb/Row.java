package inmemorydb;

import java.util.HashMap;
import java.util.Map;

public class Row {

    private String rowId;
    private Map<String, Column> columnMap;

    public Row (String rowId, Map<String, Column> columnMap) {
        this.rowId = rowId;
        this.columnMap = columnMap;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Map<String, Column> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(HashMap<String, Column> columnMap) {
        this.columnMap = columnMap;
    }

    public boolean doesRowExist(String columnName, Column column) {
        return columnMap.containsKey(columnName) && columnMap.get(columnName).equals(column);
    }
}
