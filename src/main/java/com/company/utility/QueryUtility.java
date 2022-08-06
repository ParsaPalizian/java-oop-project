package com.company.utility;

import com.company.enums.SqlCommandType;

import java.util.ArrayList;

public class QueryUtility {

    public static String createWhereClause(String[][] where) {
        String sql = "";
        ArrayList<String> keyValues = new ArrayList<>();
        if (where != null && where.length > 0) {
            for (int i = 0; i < where.length; i++) {
                keyValues.add("`" + where[i][0] + "` = '" + where[i][1] + "' ");
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            String whereClause = String.join(" AND ", arrKeyValues);
            sql += " WHERE " + whereClause;
        }

        return sql;
    }

    public static String createExtendedWhereClause(String[][] where) {
        String sql = "";
        ArrayList<String> keyValues = new ArrayList<>();
        if (where != null && where.length > 0) {
            for (int i = 0; i < where.length; i++) {
                keyValues.add("`" + where[i][0] + "`" + where[i][1] + "'" + where[i][2] + "' ");
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            String whereClause = String.join(" AND ", arrKeyValues);
            sql += " WHERE " + whereClause;
        }

        return sql;
    }

    public static String createJoinClause(String[][] joins) {
        String sql = "";
        ArrayList<String> keyValues = new ArrayList<>();
        if (joins != null && joins.length > 0) {
            for (int i = 0; i < joins.length; i++) {
                keyValues.add(String.format(" INNER JOIN %s ON %s = %s ", joins[i][0], joins[i][1], joins[i][2]));
            }
            String[] arrKeyValues = keyValues.toArray(new String[0]);
            return String.join(" ", arrKeyValues);
        }

        return sql;
    }

    public static String create(SqlCommandType command, String table, String[] fields, String[][] joins, String[][] where) {
        String sql = String.format(command.toString(), String.join(",", fields), table);
        String joinClause = createJoinClause(joins);
        String whereClause = createWhereClause(where);
        sql += joinClause + whereClause;
        return sql;

    }

}
