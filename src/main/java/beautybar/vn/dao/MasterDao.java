package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MasterDao extends DBManager {

    private static MasterDao instance;

    private Set<Master> allMasters;

    private static final String FIND_MASTER =
            "SELECT name FROM masters WHERE id=?";

    private MasterDao() {
        allMasters = new HashSet<Master>();
    }

    public static MasterDao getInstance() {
        if (instance == null) {
            instance = new MasterDao();
        }
        return instance;
    }


    public Master getMaster(int id) {
        Master master = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_MASTER);

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int master_id = rs.getInt(1);
                master = new Master();
                master.setId(master_id);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return master;
    }
}
