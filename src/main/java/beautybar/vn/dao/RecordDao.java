package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Services;
import beautybar.vn.entity.User;


import java.sql.*;
import java.sql.Date;
import java.util.*;

public class RecordDao extends DBManager {

    private static RecordDao instance;

    private Set<Record> allrecord;


    private static final String ADD__RECORD =
            "INSERT INTO record (users_id," +
                                "date," +
                                "stage," +
                                "status_for_admin," +
                                "start_time," +
                                "ending_time," +
                                "service," +
                                "master_name)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
    private static final String MAX_ID =
            "SELECT MAX(record_id) FROM record";
    private static final String TIMETABLE =
            "SELECT date,start_time FROM record";


    private RecordDao() {
        allrecord = new HashSet<Record>();
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDao();
        }
        return instance;
    }


    public HashMap<Date,Time> getTimetable() {
        Connection connection = null;
        PreparedStatement statement = null;
        HashMap<Date,Time> map = new HashMap<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(TIMETABLE);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Date date = rs.getDate("date");
                Time start_time = rs.getTime("start_time");

                map.put(date,start_time);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;

    }

    public int addRecord(Record record) {

        Connection connection = null;
        PreparedStatement statement = null;
        int resultAdded = 0;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD__RECORD);



           statement.setLong(1,record.getUser_id());
           statement.setDate(2,record.getDate());
           statement.setBoolean(3,record.isStage());
           statement.setBoolean(4,record.isStatus_for_admin());
           statement.setTime(5,record.getStarting_time());
           statement.setTime(6,record.getEnding_time());
           statement.setString(7,record.getService());
           statement.setString(8,record.getMaster_name());

           resultAdded = statement.executeUpdate();

            ResultSet rs = statement.executeQuery(MAX_ID);
            rs.next();
            Long recordID = rs.getLong(1);
            record.setId(recordID);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultAdded;
    }

}
