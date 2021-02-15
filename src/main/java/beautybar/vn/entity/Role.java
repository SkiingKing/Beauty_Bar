package beautybar.vn.entity;

public enum Role {

    USER, ADMIN, GUEST,MASTER;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        return Role.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }

    }
