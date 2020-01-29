package org.training.food_tracker.model;

import java.math.BigDecimal;

public class Biometrics {
    private Long id;
    private User owner;
    private BigDecimal age;
    private Sex sex;
    private BigDecimal weight;
    private BigDecimal height;
    private Lifestyle lifestyle;
    private BigDecimal dailyNorm;

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder {
        private Biometrics biometrics;

        Builder() {
            this.biometrics = new Biometrics();
        }

        Builder id(Long id) {
            biometrics.setId(id);
            return this;
        }

        Builder owner(User owner) {
            biometrics.setOwner(owner);
            return this;
        }

        Builder age(BigDecimal age) {
            biometrics.setAge(age);
            return this;
        }

        Builder sex(Sex sex) {
            biometrics.setSex(sex);
            return this;
        }

        Builder weight(BigDecimal weight) {
            biometrics.setWeight(weight);
            return this;
        }

        Builder height(BigDecimal height) {
            biometrics.setWeight(height);
            return this;
        }

        Builder lifestyle(Lifestyle lifestyle) {
            biometrics.setLifestyle(lifestyle);
            return this;
        }

        Biometrics build() {
            return biometrics;
        }
    }

    /**
     * Total energy expenditure calculation using Harris–Benedict equation
     * @return daily norm of calories
     */
    public BigDecimal calculateDailyNorm() {
        if (this.sex == Sex.MALE) {
            return (new BigDecimal(66.5)
                            .add(new BigDecimal(13.75).multiply(weight))
                            .add(new BigDecimal(5.003).multiply(height))
                            .subtract(new BigDecimal(6.755).multiply(age)))
                           .multiply(lifestyle.getCoefficient());
        }
        return (new BigDecimal(655.1)
                        .add(new BigDecimal(9.563).multiply(weight))
                        .add(new BigDecimal(1.850).multiply(height))
                        .subtract(new BigDecimal(4.676).multiply(age)))
                       .multiply(lifestyle.getCoefficient());
    }

    public void setDailyNorm() {
        this.dailyNorm = calculateDailyNorm().setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public BigDecimal getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public BigDecimal getDailyNorm() {
        return dailyNorm;
    }

    public void setDailyNorm(BigDecimal dailyNorm) {
        this.dailyNorm = dailyNorm;
    }
}