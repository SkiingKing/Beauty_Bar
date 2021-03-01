package beautybar.vn.dao;

import beautybar.vn.database.DBManager;
import beautybar.vn.entity.Record;
import beautybar.vn.entity.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReviewDao extends DBManager {

    private static ReviewDao instance;

    private Set<Review> allreview;

    private static final String ALL_REVIEW =
            "SELECT * FROM review";

    private static final String ADD_REVIEW =
            "INSERT INTO review(review_text,date,users_id,name) VALUES (?,?,?,?)";


    private ReviewDao() {
        allreview = new HashSet<Review>();
    }

    public static ReviewDao getInstance() {
        if (instance == null) {
            instance = new ReviewDao();
        }
        return instance;
    }

    /**
     * Add new review.
     *
     * @param review
     */

    public void addReview(Review review) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ADD_REVIEW);

            statement.setString(1,review.getText());
            statement.setDate(2,review.getDate());
            statement.setLong(3,review.getUser_id());
            statement.setString(4,review.getName());


            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Return all reviews.
     *
     * @return List<Review>
     */

    public List<Review> getAllReview(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Review> list  = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(ALL_REVIEW);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Review review = new Review();

                Long id = rs.getLong("id");
                String review_text = rs.getString("review_text");
                Date date = rs.getDate("date");
                Integer user_id = rs.getInt("users_id");
                String name  = rs.getString("name");

                review.setId(id);
                review.setText(review_text);
                review.setDate(date);
                review.setUser_id(user_id);
                review.setName(name);

                list.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }






}
