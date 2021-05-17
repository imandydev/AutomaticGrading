package DTO;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String pass;
    private int role;
    private String key;
    private int hide;

    public UserDTO(int id, String name, String email, String pass, int role, String key, int hide) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.role = role;
        this.key = key;
        this.hide = hide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }
    
}
