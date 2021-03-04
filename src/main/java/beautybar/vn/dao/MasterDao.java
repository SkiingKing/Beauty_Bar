package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Master;



import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterDao {

    private static MasterDao instance;

    private static final String FIND_MASTER =
            "SELECT name,rate,services FROM masters ";
    private static final String FIND_MASTER_BY_SERVICE =
            "SELECT name FROM masters WHERE services=?";




    public static MasterDao getInstance() {
        if (instance == null) {
            instance = new MasterDao();
        }
        return instance;
    }

    /**
     * Returns all masters.
     *
     * @return  List<Master>
     */
    public List<Master> getMasters() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Master> list = new ArrayList<>();

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_MASTER);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String master_name = rs.getString("name");
                int rate = rs.getInt("rate");
                String service = rs.getString("services");

                Master master = new Master();

                master.setName(master_name);
                master.setRate(rate);
                master.setServices(service);

                list.add(master);
            }
        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }

        return list;
    }

    /**
     * Returns name of master by service.
     *
     * @param service
     * @return List<String>
     */
    public List<Master> getMasterByService(String service) {
        Master master;
        Connection connection = null;
        PreparedStatement statement = null;

        List<Master> list = new ArrayList<>();

        try {
            connection = DBManager.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_MASTER_BY_SERVICE);

            statement.setString(1,service);


            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString(1);

                master = new Master();
                master.setName(name);
                list.add(master);
                master.setMastersByService(master.getMasterByService());

            }

        } catch (SQLException ex) {
            DBManager.getInstance().rollbackAndClose(connection);
            ex.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(connection);
        }
        return list;
    }





}
