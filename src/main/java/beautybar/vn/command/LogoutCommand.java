package beautybar.vn.command;

import beautybar.vn.Path;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    private static final Logger log = Logger.getLogger(LogoutCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        log.debug("Command start!");
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        log.debug("Command end!");
        return Path.PAGE__LOGIN;
        }

}
