package beautybar.vn.dao;

import beautybar.vn.database.DBManager;


import beautybar.vn.entity.Master;
import beautybar.vn.entity.Services;

import java.sql.*;
import java.util.*;

public class ServicesDao extends DBManager {

    private static ServicesDao instance;

    private Set<Services> allServices;


    private static final String FIND_SERVICE =
            "SELECT name FROM services";

    private ServicesDao() {
        allServices = new HashSet<Services>();
    }

    public static ServicesDao getInstance() {
        if (instance == null) {
            instance = new ServicesDao();
        }
        return instance;
    }

    public List<String> getService() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<String> list = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_SERVICE);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String service_name = rs.getString("name");

                Services services = new Services();
                services.setName_of_services(service_name);
                list.add(service_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
}
