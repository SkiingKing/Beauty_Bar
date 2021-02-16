package beautybar.vn.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();

    private Map<String, Command> comands = new HashMap<String, Command>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        comands.put("register", new RegisterCommand());
        comands.put("logout", new LogoutCommand());
        comands.put("main", new MainCommand());
        comands.put("login", new LoginCommand());
        comands.put("select",new SelectCommand());
        comands.put("record", new RecordCommand());
        comands.put("update_status_by_master",new TimetableCommand());

    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = comands.get(action);
        return command;
    }

}
