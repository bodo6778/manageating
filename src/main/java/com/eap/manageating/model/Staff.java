package com.eap.manageating.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstaff")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "nume")
    private String firstName;

    @Column(name = "prenume")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "nrcomlivrate")
    private int nrComLivrate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;


    @OneToMany(mappedBy = "staff")
    private List<Comanda> comenzi;

    public Staff() {
    }

    public Staff(int id, String userName, String password, String firstName, String lastName, String email, int nrComLivrate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nrComLivrate = nrComLivrate;
    }

    public Staff(int id, String userName, String password, String firstName, String lastName, String email, int nrComLivrate, Collection<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nrComLivrate = nrComLivrate;
        this.roles = roles;
    }

    public Staff(int id, String userName, String password, String firstName, String lastName, String email, int nrComLivrate, List<Comanda> comenzi) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nrComLivrate = nrComLivrate;
        this.comenzi = comenzi;
    }

    public Staff(int id, String userName, String password, String firstName, String lastName, String email, int nrComLivrate, Collection<Role> roles, List<Comanda> comenzi) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nrComLivrate = nrComLivrate;
        this.roles = roles;
        this.comenzi = comenzi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrComLivrate() {
        return nrComLivrate;
    }

    public void setNrComLivrate(int nrComLivrate) {
        this.nrComLivrate = nrComLivrate;
    }

    public void addNrComLivrateOne() { this.nrComLivrate++; }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }


}
