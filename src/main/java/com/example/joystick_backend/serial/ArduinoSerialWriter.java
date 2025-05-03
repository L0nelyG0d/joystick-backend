package com.example.joystick_backend.serial;

import com.example.joystick_backend.DTO.MotorPowerDTO;
import com.fazecast.jSerialComm.SerialPort;

public class ArduinoSerialWriter {

    private static SerialPort serialPort;

    static {
        serialPort = SerialPort.getCommPort("COM7");
        serialPort.setBaudRate(9600);
        serialPort.openPort();
    }

    public static void sendMotorPower(MotorPowerDTO motorPower) {
        String data = motorPower.getFrontLeft() + "," +
                motorPower.getFrontRight() + "," +
                motorPower.getBackLeft() + "," +
                motorPower.getBackRight() + "\n";
        serialPort.writeBytes(data.getBytes(), data.length());
    }
}