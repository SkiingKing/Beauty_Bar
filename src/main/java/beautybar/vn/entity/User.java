package beautybar.vn.entity;

public class User {

    private long id;


    private String email;

    private String password;


    private String NameAndSurname;

    private int roleId;

    public User() {
    }

    public User(int id, String email, String password, int roleId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public String getNameAndSurname() {
        return NameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        NameAndSurname = nameAndSurname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", NameAndSurname='" + NameAndSurname + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
