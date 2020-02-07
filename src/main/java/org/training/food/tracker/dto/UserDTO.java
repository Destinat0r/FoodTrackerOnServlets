package org.training.food.tracker.dto;

import org.training.food.tracker.model.Lifestyle;
import org.training.food.tracker.model.Sex;
import org.training.food.tracker.model.Role;

import java.math.BigDecimal;

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private BigDecimal age;
    private Sex sex;
    private BigDecimal weight;
    private BigDecimal height;
    private Lifestyle lifestyle;
    private BigDecimal dailyNorm;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UserDTO userDTO;

        public Builder() {
            this.userDTO = new UserDTO();
        }

        public Builder id(Long id) {
            userDTO.setId(id);
            return this;
        }

        public Builder username(String username) {
            userDTO.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            userDTO.setPassword(password);
            return this;
        }

        public Builder firstName(String firstName) {
            userDTO.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            userDTO.setLastName(lastName);
            return this;
        }

        public Builder email(String email) {
            userDTO.setEmail(email);
            return this;
        }

        public Builder role(Role role) {
            userDTO.setRole(role);
            return this;
        }

        public Builder age(BigDecimal age) {
            userDTO.setAge(age);
            return this;
        }

        public Builder sex(Sex sex) {
            userDTO.setSex(sex);
            return this;
        }

        public Builder height(BigDecimal height) {
            userDTO.setHeight(height);
            return this;
        }

        public Builder weight(BigDecimal weight) {
            userDTO.setWeight(weight);
            return this;
        }

        public Builder lifestyle(Lifestyle lifestyle) {
            userDTO.setLifestyle(lifestyle);
            return this;
        }

        public Builder dailyNorm(BigDecimal dailyNorm) {
            userDTO.setDailyNorm(dailyNorm);
            return this;
        }

        public UserDTO build() {
            return userDTO;
        }
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public BigDecimal getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(BigDecimal dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}