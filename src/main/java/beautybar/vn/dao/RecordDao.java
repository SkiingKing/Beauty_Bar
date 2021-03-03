package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Record;



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

    private static final String START_TIME_BY_MASTER_AND_DATE =
            "SELECT start_time FROM record WHERE master_name =? AND date =?";

    private static final String ENDING_TIME_BY_MASTER_AND_DATE =
            "SELECT ending_time FROM record WHERE master_name =? AND date=?";

    private static final String TIME_BY_SERVICE =
            "SELECT name,estimat_time FROM services";

    private static final String GET_ALL_RECORDS =
            "SELECT * FROM record WHERE status_for_admin = 0 limit 10";

    private static final String GET_ALL_RECORDS_L =
            "SELECT * FROM record WHERE status_for_admin = 0 LIMIT ";

    private static final String GET_ALL_RECORDS_BY_MASTER =
            "SELECT * FROM record WHERE stage = 0 AND master_name=? limit ";

    private static final String FIND_RECORD_BY_ID =
            "SELECT * FROM record WHERE record_id=?";

    private static final String DELETE_RECORD =
            "DELETE FROM record WHERE record_id=?";

    private static final String UPDATE_STATUS =
            "UPDATE record SET status_for_admin = 1 WHERE record_id=?";

    private static final String UPDATE_STAGE =
            "UPDATE record SET stage= 1 WHERE record_id=?";

    private static final String UPDATE_TIMESLOT =
            "UPDATE record SET start_time =? , ending_time =? WHERE record_id=?";

    private static final String NUMBER_OF_ROWS =
            "SELECT count(record_id) FROM record";

    private static final String FIND_USER_ID_BY_RECORD =
            "SELECT users_id FROM record WHERE record_id = ?";

    private static final String FIND_MASTER_BY_RESPONSE =
            "SELECT master_name FROM record WHERE users_id = ?";


    private RecordDao() {
        allrecord = new HashSet<Record>();
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDao();
        }
        return instance;
    }

    /**
     * Find record by id.
     *
     * @param id
     * @return record
     */

    public Record findRecordById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        Record record = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_RECORD_BY_ID);

            statement.setInt(1,id);


            ResultSet rs = statement.executeQuery();


            if (rs.next()) {

                Long record_id = rs.getLong("record_id");
                Integer user_id = rs.getInt("users_id");
                Date date = rs.getDate("date");
                boolean stage = rs.getBoolean("stage");
                boolean status_for_admin = rs.getBoolean("status_for_admin");
                Time start_time = rs.getTime("start_time");
                Time ending_time = rs.getTime("ending_time");
                String service = rs.getString("service");
                String master_name  = rs.getString("master_name");

                record = new Record();

                record.setId(record_id);
                record.setUser_id(user_id);
                record.setDate(date);
                record.setStage(stage);
                record.setStatus_for_admin(status_for_admin);
                record.setStarting_time(start_time);
                record.setEnding_time(ending_time);
                record.setService(service);
                record.setMaster_name(master_name);

                return record;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return record;

    }



    /**
     * Returns all records.
     *
     * @return List of records.
     * @param currentPage
     * @param recordsPerPage
     */

    public List<Record> getAllRecords(int currentPage,int recordsPerPage){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Record> list  = new ArrayList<>();
       // int start = currentPage * recordsPerPage - recordsPerPage;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_RECORDS_L+(currentPage * recordsPerPage - recordsPerPage)+", "+recordsPerPage);

            ResultSet rs = statement.executeQuery();


            while (rs.next()) {
                Record record = new Record();

                Long record_id = rs.getLong("record_id");
                Integer user_id = rs.getInt("users_id");
                Date date = rs.getDate("date");
                boolean stage = rs.getBoolean("stage");
                boolean status_for_admin = rs.getBoolean("status_for_admin");
                Time start_time = rs.getTime("start_time");
                Time ending_time = rs.getTime("ending_time");
                String service = rs.getString("service");
                String name_master = rs.getString("master_name");

                record.setId(record_id);
                record.setUser_id(user_id);
                record.setDate(date);
                record.setStage(stage);
                record.setStatus_for_admin(status_for_admin);
                record.setStarting_time(Time.valueOf(start_time.toLocalTime().minusMinutes(180)));
                record.setEnding_time(Time.valueOf(ending_time.toLocalTime().minusMinutes(180)));
                record.setService(service);
                record.setMaster_name(name_master);

                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     * Returns all records by master.
     *
     * @return List of records.
     */
    public List<Record> getAllRecordsByMaster(String name,int currentPage,int recordsPerPage){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Record> list  = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_RECORDS_BY_MASTER+(currentPage-1)+","+recordsPerPage);

            statement.setString(1,name);


            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Record record = new Record();

                Long record_id = rs.getLong("record_id");
                Integer user_id = rs.getInt("users_id");
                Date date = rs.getDate("date");
                boolean stage = rs.getBoolean("stage");
                boolean status_for_admin = rs.getBoolean("status_for_admin");
                Time start_time = rs.getTime("start_time");
                Time ending_time = rs.getTime("ending_time");
                String service = rs.getString("service");


                record.setId(record_id);
                record.setUser_id(user_id);
                record.setDate(date);
                record.setStage(stage);
                record.setStatus_for_admin(status_for_admin);
                record.setStarting_time(Time.valueOf(start_time.toLocalTime().minusMinutes(180)));
                record.setEnding_time(Time.valueOf(ending_time.toLocalTime().minusMinutes(180)));
                record.setService(service);


                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     *
     * @param master_name
     * @param date
     * @return list of starting time by master on the specified date
     */

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
                time = Time.valueOf(l.minusMinutes(180));
                list.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param master_name
     * @param date
     * @return list of ending time by master on the specified date
     */

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
                time = Time.valueOf(l.minusMinutes(180));
                list.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * Return service and it's durations
     *
     * @return HashMap<String,Long>
     */
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

    /**
     * Add new record
     *
     * @param record
     */

    public void addRecord(Record record) {
        Connection connection = null;
        PreparedStatement statement = null;
        long a = 180;

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

    /**
     * Update status of record(calculate).
     * @param id
     */
    public void updateAdminStatus(int id) {
        Connection conn = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_STATUS);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Change record timeslot.
     * @param id
     * @param start
     * @param end
     */
    public void updateAdminRecord(int id,Time start,Time end) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_TIMESLOT);
            statement.setTime(1, Time.valueOf(start.toLocalTime().plusMinutes(180)));
            statement.setTime(2, Time.valueOf(end.toLocalTime().plusMinutes(180)));
            statement.setInt(3, id);
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public Integer findUserByRecordId(int record_id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_USER_ID_BY_RECORD);

            statement.setInt(1,record_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt("users_id");
                return idd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFindMasterByResponse(int user_id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_MASTER_BY_RESPONSE);

            statement.setInt(1,user_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String master_name = rs.getString("master_name");
                return master_name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Delete record(for admin).
     * @param id
     */

    public void deleteRecord(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(DELETE_RECORD);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Master update status of record.
     * @param id
     */
    public void updateMasterStatus(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_STAGE);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Return number of record rows.
     * @return Integer
     */
    public Integer getNumberOfRows() {
        Connection connection = null;
        PreparedStatement statement = null;
        Integer numOfRows = 0;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(NUMBER_OF_ROWS);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return numOfRows;
    }


}
