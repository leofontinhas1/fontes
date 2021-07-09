package com.br.fontinhas.fontes.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String username;

    private String password;

    private User(Builder builder){
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
    }

    private User(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public interface IUserName {
        IUserUsername withName(String name);
    }

    public interface IUserUsername {
        IUserPassword withUsername(String username);
    }

    public interface IUserPassword {
        IUserCreator withPassword(String password);
    }
    public interface IUserCreator {
        User build();
    }

    public static class Builder implements IUserName, IUserUsername, IUserPassword, IUserCreator{

        private String name;

        private String username;

        private String password;

        private Builder(){
        }

        public static IUserName aUser(){
            return new Builder();
        }

        @Override
        public IUserUsername withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public IUserPassword withUsername(String username) {
            this.username = username;
            return this;
        }

        @Override
        public IUserCreator withPassword(String password) {
            this.password = password;
            return this;
        }


        @Override
        public User build(){
            return new User(this);
        }

    }
}
