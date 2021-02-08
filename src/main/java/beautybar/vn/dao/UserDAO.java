package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Role;
import beautybar.vn.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO extends DBManager {
    private static UserDAO instance;

    private Set<User> allUsers;


    private static final String ADD__USER =
            "INSERT INTO users (email, password, nameandsurname,role_role_id) VALUES (?,?,?,?)";
    private static final String MAX_ID =
            "SELECT MAX(id) FROM users";
    private static final String GET__ALL__USERS =
            "SELECT * FROM users";
    private static final String GET__USER =
            "SELECT id,role_role_id FROM users WHERE password = ? AND email = ?";

    private UserDAO() {
        allUsers = new HashSet<User>();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public int addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultAdded = 0;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD__USER);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNameAndSurname());
            statement.setInt(4, user.getRoleId());

            resultAdded = statement.executeUpdate();

            ResultSet rs = statement.executeQuery(MAX_ID);
            rs.next();
            int userId = rs.getInt(1);
            user.setId(userId);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultAdded;
    }

    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<User>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET__ALL__USERS);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name_and_surname");
                String password = rs.getString("password");
                int role = rs.getInt("role");

                User user = new User();
                user.setId(id);
                user.setEmail(name);
                user.setPassword(password);
                user.setRoleId(role);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUser(String name, String password) {
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET__USER);

            statement.setString(1,password);
            statement.setString(2,name);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                int role_id = rs.getInt(2);
                user = new User();
                user.setId(id);
                user.setEmail(name);
                user.setPassword(password);
                user.setRoleId(role_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
