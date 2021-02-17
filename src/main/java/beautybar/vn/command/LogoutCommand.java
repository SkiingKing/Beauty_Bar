package beautybar.vn.command;

import beautybar.vn.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        return Path.PAGE__LOGIN;
        }

}
