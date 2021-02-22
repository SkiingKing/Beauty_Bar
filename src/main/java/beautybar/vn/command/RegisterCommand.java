package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.dao.UserDAO;
import beautybar.vn.entity.Role;
import beautybar.vn.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RegisterCommand implements Command {

    private static final Logger log = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        String errorMessage;
        String forward = Path.PAGE__ERROR_PAGE;
        HttpSession session =request.getSession();


        String email = request.getParameter("email");
        if(email.isEmpty() || email == null || !email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")){
            errorMessage = "Check field email!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }

        String password = request.getParameter("password");
        if(password.isEmpty() || password == null ){
            errorMessage = "Check field Password!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }
        String name_and_surname = request.getParameter("nameandsurname");
        if(name_and_surname.isEmpty() || name_and_surname == null || !name_and_surname.matches("\\w*\\s\\w*")){
            errorMessage = "Check field Name and surname!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        }

        // add data new user
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setNameAndSurname(name_and_surname);
        user.setRoleId(1);

        // check if user contains in BD
        DaoFactory factory = DaoFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        Set<User> users = userDAO.getAllUsers();
        int add = 0;

        if (!users.contains(user)) {
            log.info("Add new user");
            add = userDAO.addUser(user);
            session.setAttribute("user",user);
            log.info(add + " size " + userDAO.getAllUsers().size());
        }

        if (add == 0) {
            errorMessage = "This user existed!";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return forward;
        } else {
            session.setAttribute("user", user);
        }

        // get user role
        Role userRole = Role.USER;
        session.setAttribute("userRole", userRole);

        String result = (add == 0) ? Path.PAGE__REGISTER : "controller?action=main";
        log.debug("Command end!");
        return result;

    }

}

