package com.example.joystick_backend.controller;

import com.example.joystick_backend.DTO.AttitudeDTO;
import com.example.joystick_backend.DTO.JoyStickDTO;
import com.example.joystick_backend.DTO.MotorPowerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/joystick")
public class JoyStickController {
    @PostMapping
    public ResponseEntity<MotorPowerDTO> receivedInfo(@RequestBody JoyStickDTO joyStickDTO) {
        System.out.println("Received Input -> X: " + joyStickDTO.getX() +
                ", Y: " + joyStickDTO.getY() +
                ", Direction: " + joyStickDTO.getDirection() +
                ", Power: " + joyStickDTO.getPower());

        MotorPowerDTO output = calculateMotorPower(
                joyStickDTO.getDirection(), joyStickDTO.getPower()
        );

        return ResponseEntity.ok(output);
    }


    private MotorPowerDTO calculateMotorPower(String direction, int power) {
        if (direction == null) direction = "center";

        int fl = power, fr = power, bl = power, br = power;

        switch (direction.toLowerCase()) {
            case "up":
                fl -= 20; fr -= 20; bl += 20; br += 20; break;
            case "down":
                fl += 20; fr += 20; bl -= 20; br -= 20; break;
            case "left":
                fl -= 20; bl -= 20; fr += 20; br += 20; break;
            case "right":
                fl += 20; bl += 20; fr -= 20; br -= 20; break;
            default:
        }

        fl = Math.max(0, Math.min(100, fl));
        fr = Math.max(0, Math.min(100, fr));
        bl = Math.max(0, Math.min(100, bl));
        br = Math.max(0, Math.min(100, br));

        return new MotorPowerDTO(fl, fr, bl, br);
    }

    @PostMapping("/attitude")
    public ResponseEntity<String> controlAttitude(@RequestBody AttitudeDTO payload) {
        System.out.println("Attitude: " + payload.getDirection() + " Power: " + payload.getPower());
        return ResponseEntity.ok("Attitude command received");
    }

}
