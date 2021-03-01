package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.RecordDao;
import beautybar.vn.dao.ReviewDao;
import beautybar.vn.dao.UserDAO;
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
        Integer user_id = user.getId();

        DaoFactory factory = DaoFactory.getInstance();
        ReviewDao reviewDao = factory.getReviewDao();
        RecordDao recordDao = factory.getRecordDAO();
        UserDAO userDAO = factory.getUserDAO();
        Review review = new Review();

        review.setText(text);
        review.setDate(date);
        review.setUser_id(user_id);
        review.setName(userDAO.findMasterByEmail(user.getEmail()));
        review.setName_of_master(recordDao.getFindMasterByResponse(user_id));

        session.setAttribute("master_name",recordDao.getFindMasterByResponse(user_id));

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
