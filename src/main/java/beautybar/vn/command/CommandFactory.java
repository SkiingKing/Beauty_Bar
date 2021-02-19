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
        comands.put("master_timetable",new TimetableCommand());
        comands.put("master",new MasterCommand());
        comands.put("sort",new SortCommand());
        comands.put("service",new ServiceCommand());
        comands.put("admin_list",new AdminListCommand());
        comands.put("deleteRecord",new DeleteRecord());
        comands.put("update_admin_status",new UpdateSatusForAdmin());
        comands.put("edit",new EditCommand());
        comands.put("update_master_status",new UpdateMasterStatus());
        comands.put("AdminListCommand",new AdminListCommand());


    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = comands.get(action);
        return command;
    }

}
