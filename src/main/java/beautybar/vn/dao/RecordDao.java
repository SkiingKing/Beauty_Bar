package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Services;
import beautybar.vn.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RecordDao extends DBManager {

    private static RecordDao instance;

    private Set<Record> allrecord;


    private static final String ADD__RECORD =
            "INSERT INTO record (date," +
                                "stage," +
                                "status_for_admin," +
                                "start_time," +
                                "ending_time)" +
                    "VALUES (?,?,?,?,?)";
    private static final String MAX_ID =
            "SELECT MAX(id) FROM record";


    private RecordDao() {
        allrecord = new HashSet<Record>();
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDao();
        }
        return instance;
    }


    public int addRecord(Record record) {

        Connection connection = null;
        PreparedStatement statement = null;
        int resultAdded = 0;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD__RECORD);

           statement.setDate(1,record.getDate());
           statement.setBoolean(2,record.isStage());
           statement.setBoolean(3,record.isStatus_for_admin());
           statement.setTime(4,record.getStarting_time());
           statement.setTime(5,record.getEnding_time());

           resultAdded = statement.executeUpdate();

            ResultSet rs = statement.executeQuery(MAX_ID);
            rs.next();
            int recordID = rs.getInt(1);
            record.setId(recordID);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultAdded;
    }

}
