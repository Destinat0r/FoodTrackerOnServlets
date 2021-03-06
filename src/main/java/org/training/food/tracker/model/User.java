package org.training.food.tracker.model;

import java.math.BigDecimal;

public class User  {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Biometrics biometrics;
    private BigDecimal dailyNormCalories;
    private Role role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Biometrics getBiometrics() {
        return this.biometrics;
    }

    public void setBiometrics(Biometrics biometrics) {
        this.biometrics = biometrics;
    }

    public BigDecimal getDailyNormCalories() {
        return dailyNormCalories;
    }

    public void setDailyNormCalories(BigDecimal dailyNormCalories) {
        this.dailyNormCalories = dailyNormCalories;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + ", firstName='"
                       + firstName + '\'' + ", lastName='" + lastName + '\'' + ", dailyNormCalories="
                       + dailyNormCalories + ", role=" + role + '}';
    }
}
