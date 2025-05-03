package com.example.joystick_backend.DTO;

public class AttitudeDTO {
    private String direction;
    private int power;

    public AttitudeDTO(){}

    public String getDirection(){
        return direction;
    }

    public int getPower(){
        return power;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public void setPower(int power){
        this.power = power;
    }
}
