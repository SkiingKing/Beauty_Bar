package beautybar.vn.command;

import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("email");
        String password = request.getParameter("password");

        DaoFactory factory = DaoFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUser(name, password);

        String resultPage = (user == null) ? "login.jsp" : "controller?action=main";

        if (user == null) {
            request.setAttribute("notExists", "This user not exists");
        } else {
            request.getSession().setAttribute("user", user);
        }

        return resultPage;
    }
}

