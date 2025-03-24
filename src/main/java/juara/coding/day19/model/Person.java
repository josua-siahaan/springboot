package juara.coding.day19.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MstPerson")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDGroup")
    private Long id;

    @Column(name = "username",nullable = false, length = 50,unique = true)
    private String username;

    @Column(name = "password",nullable = false, length = 100,unique = true)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
