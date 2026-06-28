package com.packt.cardatabase.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerID;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String userName;

    private String userPassword;

    @ManyToMany
    @JoinTable(
            name = "car_owner",
            joinColumns = @JoinColumn(name = "ownerID"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Car> ownedCars;

    private Role role;

    public Owner() {
    }

    public Owner(long ownerID, String firstName, String lastName, String userName, String userPassword, Set<Car> ownedCars, Role role) {
        this.ownerID = ownerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.ownedCars = ownedCars;
        this.role = role;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Car> getOwnedCars() {
        return ownedCars;
    }

    public void setOwnedCars(Set<Car> ownedCars) {
        this.ownedCars = ownedCars;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
