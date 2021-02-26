package beautybar.vn.entity;

public enum Role {

    GUEST,USER,ADMIN,MASTER;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        return Role.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }

    }
