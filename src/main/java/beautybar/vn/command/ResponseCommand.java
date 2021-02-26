package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.ReviewDao;
import beautybar.vn.entity.Review;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ResponseCommand implements Command{

    private static final Logger log = Logger.getLogger(ResponseCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");

        DaoFactory factory = DaoFactory.getInstance();
        ReviewDao reviewDao = factory.getReviewDao();

        List<Review> allreview = reviewDao.getAllReview();
        log.info("Allreview -->"+allreview);

        session.setAttribute("allreview",allreview);
        session.setAttribute("user",user);


        log.debug("Command end!");
        return Path.PAGE__RESPONSE;
    }
}
