package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.SqlCommandType;
import com.company.model.Account;
import com.company.model.Block;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class BlockDataAdaptor {
    public static final String TABLE_NAME = "blocks";

    DatabaseHelper dbHelper;

    public BlockDataAdaptor() throws SQLException {
        this.dbHelper = new DatabaseHelper();
    }

    public Block insert(Block block) throws SQLException {


        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format(
                "INSERT INTO %s (blocker_id,blocked_id) VALUES  ('%d','%d')",
                TABLE_NAME,
                block.getBlocker().getId(),
                block.getBlocked().getId()
        );

        int id = dbHelper.insert(sql);
        block.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return block;
    }


    public void delete(int blockId) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("DELETE from %s WHERE id=%s", TABLE_NAME , blockId);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    public CustomArrayList<Block> find(String[] fields, String[][] joins, String[][] where) throws SQLException, ParseException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }


        String sql = QueryUtility.create(SqlCommandType.SELECT, TABLE_NAME, fields, joins, where);
        ResultSet rs = dbHelper.select(sql);
        CustomArrayList<Block> blocks = new CustomArrayList<>(Block::new);
        while (rs.next()) {
            Block block = new Block();
            block.setId(rs.getInt("id"));
            block.setBlocker(new Account(Integer.parseInt(where[0][1])));
            block.setBlocked(new Account(rs.getInt("account_id"), rs.getString("username")));
            block.setBlockedAt(DateUtility.parseStringToLocalDateTime(rs.getString("blocked_at")));
            blocks.add(block);
        }

        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return blocks;

    }

}
