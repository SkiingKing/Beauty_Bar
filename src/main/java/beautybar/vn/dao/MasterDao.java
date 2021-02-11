package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;
import beautybar.vn.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterDao extends DBManager {

    private static MasterDao instance;

    private Set<Master> allMasters;

    private List<String> master_by_service;

    private static final String FIND_MASTER =
            "SELECT name FROM masters ";
    private static final String FIND_MASTER_BY_SERVICE =
            "SELECT name FROM masters WHERE services=?";

    private MasterDao() {
        allMasters = new HashSet<Master>();
    }

    public static MasterDao getInstance() {
        if (instance == null) {
            instance = new MasterDao();
        }
        return instance;
    }


    public List<String> getMasters() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<String> list = new ArrayList<>();


        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_MASTER);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String master_name = rs.getString("name");

                Master master = new Master();
                master.setName(master_name);
                list.add(master_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<String> getMasterByService(String service) {
        Master master;
        Connection connection = null;
        PreparedStatement statement = null;

        List<String> list = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_MASTER_BY_SERVICE);

            statement.setString(1,service);


            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);

                master = new Master();
                master.setName(name);
                list.add(name);
                master.setMastersByService(list);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
