package com.company.enums;

public enum SqlCommandType {
    SELECT("SELECT %s FROM %s "),
    SELECT_DISTINCT("SELECT DISTINCT %s FROM %s "),
    INSERT("INSERT INTO %s "),
    UPDATE("UPDATE %s SET "),
    DELETE("DELETE FROM %s "),
    CREATE_TABLE("CREATE TABLE %s "),
    DROP_TABLE("DROP TABLE %s "),
    TRUNCATE_TABLE("TRUNCATE TABLE %s ");

    final String value;

    @Override
    public String toString() {
        return value;
    }

    SqlCommandType(String value) {
        this.value = value;
    }
}
