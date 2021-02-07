package beautybar.vn.dao;

import beautybar.vn.database.DBManager;


import beautybar.vn.entity.Services;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ServicesDao extends DBManager {

    private static ServicesDao instance;

    private Set<Services> allServices;

    private static final String FIND_SERVICE =
            "SELECT name,price,estimat_time FROM services WHERE id=?";

    private ServicesDao() {
        allServices = new HashSet<Services>();
    }

    public static ServicesDao getInstance() {
        if (instance == null) {
            instance = new ServicesDao();
        }
        return instance;
    }

    public Services getService(int id) {
        Services services = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(FIND_SERVICE);

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int service_id = rs.getInt(1);
                String service_name = rs.getString(2);
                int price = rs.getInt(3);
                Time estimat_time = rs.getTime(4);

                services = new Services();
                services.setId(service_id);
                services.setName_of_services(service_name);
                services.setPrice(price);
                services.setTime_of_service(estimat_time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

}
