package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Services;


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
            "INSERT INTO record (data ," +
                                "stage," +
                                "satus_for_admin," +
                                "start_time," +
                                "ending_time," +
                                "price," +
                                "services_id," +
                                "services_master_id) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
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
        Master master = new Master();
        Services services = new Services();


        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD__RECORD);

           statement.setDate(1,record.getDate());
           statement.setBoolean(2,record.isStage());
           statement.setBoolean(3,record.isStatus_for_admin());
           statement.setTime(4,record.getStarting_time());
           statement.setTime(5,record.getEnding_time());
           statement.setInt(6,record.getPrice());
           statement.setInt(7,master.getId());
           statement.setInt(8,services.getId());

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
