package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "back_up_ServoTest1", group = "backup")
public class ServoTest1 extends LinearOpMode {
  
  private Servo servo1;
  
  @Override
  public void runOpMode() {
    double gamepadA;
    double gamepadB;
    double gamepadX;
    double gamepadY;
    
    servo1 = hardwareMap.get(Servo.class, "servo1");
    
    waitForStart();
    
    if (gamepad2.x) {
    gamepadX = 1;
    servo1.setPosition(1);
    } else if (gamepad2.y) {
    gamepadY = 1;
    servo1.setPosition(0);
    } else {
    gamepadY = 0;
    gamepadX = 0;
  }
}
}
    
    