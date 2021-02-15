package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Services;
import beautybar.vn.entity.User;


import java.sql.*;
import java.sql.Date;
import java.time.LocalTime;
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
    private static final String START_TIME_BY_MASTER_AND_DATE =
            "SELECT start_time FROM record WHERE master_name =? AND date =?";
    private static final String ENDING_TIME_BY_MASTER_AND_DATE =
            "SELECT ending_time FROM record WHERE master_name =? AND date=?";
    private static final String TIME_BY_SERVICE =
            "SELECT name,estimat_time FROM services";


    private RecordDao() {
        allrecord = new HashSet<Record>();
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDao();
        }
        return instance;
    }

    public List<Time> getStartTimeByMasterAndDate(String master_name,Date date) {
        Connection connection = null;
        PreparedStatement statement = null;

        List<Time> list = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(START_TIME_BY_MASTER_AND_DATE);

            statement.setString(1,master_name);
            statement.setDate(2,date);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Time time = rs.getTime(1);
                LocalTime l = time.toLocalTime();
                time = Time.valueOf(l.minusMinutes(120));
                list.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Time> getEndingTimeByMasterAndDate(String master_name,Date date) {
        Connection connection = null;
        PreparedStatement statement = null;

        List<Time> list = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ENDING_TIME_BY_MASTER_AND_DATE);

            statement.setString(1,master_name);
            statement.setDate(2,date);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Time time = rs.getTime(1);
                LocalTime l = time.toLocalTime();
                time = Time.valueOf(l.minusMinutes(120));
                list.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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

    public HashMap<String,Long> getTimeByService() {
        Connection connection = null;
        PreparedStatement statement = null;
        HashMap<String,Long> map = new HashMap<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(TIME_BY_SERVICE);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               String service = rs.getString(1);
               Long time_in_minute = rs.getLong(2);

                map.put(service,time_in_minute);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;

    }

    public void addRecord(Record record) {
        Connection connection = null;
        PreparedStatement statement = null;
        long a = 120;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD__RECORD);

           statement.setLong(1,record.getUser_id());
           statement.setDate(2,record.getDate());
           statement.setBoolean(3,record.isStage());
           statement.setBoolean(4,record.isStatus_for_admin());
           statement.setTime(5, Time.valueOf(record.getStarting_time().toLocalTime().plusMinutes(a)));
           statement.setTime(6,Time.valueOf(record.getEnding_time().toLocalTime().plusMinutes(a)));
           statement.setString(7,record.getService());
           statement.setString(8,record.getMaster_name());

           statement.executeUpdate();

            ResultSet rs = statement.executeQuery(MAX_ID);
            rs.next();
            Long recordID = rs.getLong(1);
            record.setId(recordID);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
