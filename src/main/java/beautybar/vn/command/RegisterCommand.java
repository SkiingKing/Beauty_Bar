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
import javax.validation.*;
import java.util.Set;

public class RegisterCommand implements Command {

    private static final Logger log = Logger.getLogger(RegisterCommand.class);
    @Override
    public String execute(HttpServletRequest request) {


        HttpSession session =request.getSession();


        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name_and_surname = request.getParameter("nameandsurname");

        User user = new User();


        user.setEmail(email);
        user.setPassword(password);
        user.setNameAndSurname(name_and_surname);
        user.setRoleId(1);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<User>> validations = validator.validate(user);
        for(ConstraintViolation<User> violation: validations) {
            if (validations.size() > 0) {
                log.error("Error validation:" + violation.getMessage() + violation.getInvalidValue());
                request.setAttribute("error_message",violation.getMessage());
                return Path.PAGE__ERROR_PAGE_RECORD;
            }
        }

        validatorFactory.close();

        DaoFactory factory = DaoFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        Set<User> users = userDAO.getAllUsers();
        int add = 0;

        if (!users.contains(user)) {
            add = userDAO.addUser(user);
            session.setAttribute("user",user);
            System.out.println(add + " size " + userDAO.getAllUsers().size());
        }

        if (add == 0) {
            request.setAttribute("notAdd", "This user exists");
        } else {
            session.setAttribute("user", user);
        }

        Role userRole = Role.USER;

        session.setAttribute("userRole", userRole);

        String result = (add == 0) ? Path.PAGE__REGISTER : "controller?action=main";
        return result;

    }

}

