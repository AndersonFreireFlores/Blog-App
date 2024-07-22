package andersonfflores.blogapp.Models;

import andersonfflores.blogapp.Models.Enum.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String country;
    private String password;
    private UserRole role;

    public User() {
    }

    public User(UUID id, String name, String email, String country, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
        this.role = role;
    }

    public User(String name, String email, String country, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getCountry() {
        return country;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
