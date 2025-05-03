package com.example.joystick_backend.DTO;

public class MotorPowerDTO {
    private int frontLeft;
    private int frontRight;
    private int backLeft;
    private int backRight;

    public MotorPowerDTO() {}

    public MotorPowerDTO(int fl, int fr, int bl, int br) {
        this.frontLeft = fl;
        this.frontRight = fr;
        this.backLeft = bl;
        this.backRight = br;
    }

    public int getFrontLeft() {
        return frontLeft; }

    public int getFrontRight() {
        return frontRight;
    }

    public int getBackLeft() {
        return backLeft;
    }
    public int getBackRight() {
        return backRight;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }
    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public void setBackLeft(int backLeft) {
        this.backLeft = backLeft;
    }
    public void setBackRight(int backRight) {
        this.backRight = backRight;
    }
}