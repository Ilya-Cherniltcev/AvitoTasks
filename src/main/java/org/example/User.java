package org.example;

import java.util.Objects;

public class User {
    private Long id;
    private Integer steps;

    public User(Long id, Integer steps) {
        this.id = id;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", steps=" + steps +
                '}';
    }
}
