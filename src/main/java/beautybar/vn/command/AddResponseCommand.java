package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.ReviewDao;
import beautybar.vn.entity.Review;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class AddResponseCommand implements Command{

    private static final Logger log = Logger.getLogger(AddResponseCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        HttpSession session = request.getSession();

        User user = (User) request.getSession().getAttribute("user");
        log.trace("User:" + user);

        String errorMessage;
        String forward = Path.PAGE__ERROR_PAGE;

        String text = request.getParameter("response_text");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTime().getTime());
        Long user_id = user.getId();

        DaoFactory factory = DaoFactory.getInstance();
        ReviewDao reviewDao = factory.getReviewDao();
        Review review = new Review();

        review.setText(text);
        review.setDate(date);
        review.setUser_id(user_id);
        review.setName(user.getNameAndSurname());

        log.trace("Review -->"+ review);

        // check text
        if(text.isEmpty() || text == null){
            errorMessage = "Review field is empty!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }
            // add review
            reviewDao.addReview(review);
            List<Review> allreview = reviewDao.getAllReview();
            session.setAttribute("allreview",allreview);

        log.debug("Command end!");
        return Path.PAGE__RESPONSE;
    }
}
