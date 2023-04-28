package com.example.iscany;

public class CustomModel {
    String name;
    String mobNo;

    CustomModel(String name, String mobNo){
        this.name = name;
        this.mobNo = mobNo;
    }

    CustomModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
