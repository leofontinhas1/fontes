package com.br.fontinhas.fontes.entity;

public class User2 {

    private String name;

    private String nickname;

    private String password;

    private  Integer age;

    public User2() {}

    public String getName(){
        return this.name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWomanAge(){
//
//        if(age >= 40){
//            return age-10;
//        }
//        return age;

        return age>=40 ? age-10 : age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
