package com.cars.model.domain.model;

public class CarUpdateRequestModel {

    private String ownerName;

    private String registrationNumber;

    private String newRegistrationNumber;

    private String color;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNewRegistrationNumber() {
        return newRegistrationNumber;
    }

    public void setNewRegistrationNumber(String newRegistrationNumber) {
        this.newRegistrationNumber = newRegistrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
