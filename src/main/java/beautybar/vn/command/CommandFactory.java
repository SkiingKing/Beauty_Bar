package beautybar.vn.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Logger log = Logger.getLogger(CommandFactory.class);

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
        // common commands
        comands.put("register", new RegisterCommand());
        comands.put("logout", new LogoutCommand());
        comands.put("main", new MainCommand());
        comands.put("login", new LoginCommand());

        //user commands
        comands.put("select",new SelectCommand());
        comands.put("record", new RecordCommand());
        comands.put("service",new ServiceCommand());

        //master commands
        comands.put("master_timetable",new TimetableCommand());
        comands.put("master",new MasterCommand());
        comands.put("sort",new SortCommand());
        comands.put("update_master_status",new UpdateMasterStatus());

        //admin commands
        comands.put("admin_list",new AdminListCommand());
        comands.put("deleteRecord",new DeleteRecord());
        comands.put("update_admin_status",new UpdateSatusForAdmin());
        comands.put("edit",new EditCommand());
        comands.put("AdminListCommand",new AdminListCommand());

    }

    /**
     * Returns command object with the given name.
     * @param request
     * @return
     */
    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        log.trace("Command not found, name --> " + action);
        Command command = comands.get(action);
        return command;
    }

}
