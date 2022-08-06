package com.company.dataadapter;

import com.company.CustomArrayList;
import com.company.db.DatabaseHelper;
import com.company.enums.ReactionType;
import com.company.model.Account;
import com.company.model.Reaction;
import com.company.utility.DateUtility;
import com.company.utility.QueryUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class ReactionDataAdapter {

    public static final String TABLE_NAME = "reactions";

    DatabaseHelper dbHelper;


    public ReactionDataAdapter() throws SQLException {
        this.dbHelper = new DatabaseHelper();
//        dbHelper.connect();
    }


    public CustomArrayList<Reaction> find(String contentType, int contentId) throws SQLException, ParseException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = String.format("select * from %s where  reactions.content_type ='%s' and reactions.content_id='%d'", TABLE_NAME, contentType, contentId);

        ResultSet rs = dbHelper.select(sql);

        CustomArrayList<Reaction> reactions = new CustomArrayList<>(Reaction::new);

        while (rs.next()) {

            Reaction reaction = new Reaction();
            reaction.setId(rs.getInt("id"));
            reaction.setReactedAt(DateUtility.parseStringToLocalDateTime(rs.getString("reacted_at")));
            reaction.setSender(new Account(rs.getInt("sender_id")));
            switch (rs.getInt("reaction")) {
                case 1:
                    reaction.setType(ReactionType.LAUGH);
                    break;

                case 2:
                    reaction.setType(ReactionType.HEART);
                    break;

                case 3:
                    reaction.setType(ReactionType.LIKE);
                    break;

                case 4:
                    reaction.setType(ReactionType.DISLIKE);
                    break;

                case 5:
                    reaction.setType(ReactionType.POKER_FACE);
                    break;

                case 6:
                    reaction.setType(ReactionType.RAGE);
                    break;

                case 7:
                    reaction.setType(ReactionType.CRY);
                    break;

                case 8:
                    reaction.setType(ReactionType.DISGUSTING);
                    break;

                case 9:
                    reaction.setType(ReactionType.FIRE);
                    break;


            }


            reaction.setContentType(contentType);

            reactions.add(reaction);

        }
        return reactions;
    }

    public Reaction insert(int accountId, String contentType, int contentId, Reaction reaction) throws SQLException {
        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sqlDelete = String.format("DELETE from %s WHERE sender_id='%d' and content_type='%s' and content_id='%d'", TABLE_NAME, accountId, contentType, contentId);
        dbHelper.execute(sqlDelete);

        String sql = String.format(
                "INSERT INTO %s (sender_id,content_type,content_id,reaction) VALUES  ('%d', '%s','%d','%s')",
                TABLE_NAME,
                accountId,
                contentType,
                contentId,
                reaction.getType().getId()
        );

        int id = dbHelper.insert(sql);
        reaction.setId(id);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
        return reaction;

    }

    public void delete(Reaction reaction) {

    }

    public void delete(String[][] where) throws SQLException {

        if (!dbHelper.isConnected()) {
            dbHelper = new DatabaseHelper();
            dbHelper.connect();
        }

        String sql = "DELETE from " + TABLE_NAME + " " + QueryUtility.createWhereClause(where);
        dbHelper.execute(sql);
        dbHelper.disconnect();
        dbHelper.setConnection(null);
    }

    public Account update(Reaction reaction) {
        return null;
    }

    public ArrayList<Reaction> findAll() {
        return null;
    }
}
