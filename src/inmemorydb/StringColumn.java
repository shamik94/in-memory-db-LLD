package inmemorydb;

import java.util.Objects;

public class StringColumn implements Column{

    String columnName;
    String value;

    public StringColumn(String columnName, String value) throws Exception {
        if (value.length() > 20) {
            throw new Exception("Error! String column size is greater than 5");
        }
        this.columnName = columnName;
        this.value = value;
    }

    public StringColumn(String columnName)  {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        if (value.length() > 20) {
            throw new Exception("Error! String column size is greater than 5");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringColumn that = (StringColumn) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
