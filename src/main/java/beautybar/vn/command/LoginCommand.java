package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Role;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class LoginCommand implements Command {

    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        String name = request.getParameter("email");
        String password = request.getParameter("password");


        DaoFactory factory = DaoFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUser(name, password);



        String resultPage = (user == null) ? Path.PAGE__LOGIN : "controller?action=main";
        Role userRole = Role.getRole(user);

        session.setAttribute("userRole", userRole);
        log.trace("Set the session attribute: userRole --> " + userRole);

        if (user == null) {
            request.setAttribute("notExists", "This user not exists");
        } else {
            request.getSession().setAttribute("user", user);
            session.setAttribute("user",user);
        }

        return resultPage;
    }


}

