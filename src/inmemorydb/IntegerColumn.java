package inmemorydb;

import java.util.Objects;

public class IntegerColumn implements Column{

    String columnName;
    Integer value;

    public IntegerColumn(String columnName, int value) throws Exception {
        if (value < -1024 || value > 1024) {
            throw new Exception("Error! Integer column size exceeded");
        }
        this.columnName = columnName;
        this.value = value;
    }

    public IntegerColumn(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) throws Exception {
        if (value < -1024 || value > 1024) {
            throw new Exception("Error! Integer column size exceeded");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerColumn that = (IntegerColumn) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
