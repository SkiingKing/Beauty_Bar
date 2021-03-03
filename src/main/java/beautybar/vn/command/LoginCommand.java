package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Role;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginCommand implements Command {

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start");

        String errorMessage;
        String forward = Path.PAGE__ERROR_PAGE;

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        log.trace("Email: "+ email);
        String password = request.getParameter("password");
        log.trace("Password: "+ password);


        DaoFactory factory = DaoFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();

        // check user in BD
        User user = userDAO.getUser(email, password);
        if (user == null) {
            errorMessage = "User not found,check your email or password!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }else {
            // get role
            Role userRole = Role.getRole(user);
            session.setAttribute("userRole", userRole);
            log.trace("Set the session attribute: userRole --> " + userRole);
            session.setAttribute("user", user);
        }

        return Path.PAGE__MAIN;
    }


}

