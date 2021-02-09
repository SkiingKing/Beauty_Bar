package beautybar.vn.entity;

public class Master {

    private int id;

    private String name;

    private String email;

    private String services;

    private int rate;

    public void setServices(String services) {
        this.services = services;
    }
    public String getServices() {
        return services;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRate() {
        return rate;
    }




}
