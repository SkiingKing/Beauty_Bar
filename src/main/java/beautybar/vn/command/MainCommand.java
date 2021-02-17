package beautybar.vn.command;

import beautybar.vn.Path;
import beautybar.vn.dao.DaoFactory;
import beautybar.vn.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory factory = DaoFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
           //викликаєм dao для зареєстрованого користувача
        } else {
            //викликаєм dao для не зареєстрованого користувача
        }

        return Path.PAGE__MAIN;
    }

}
