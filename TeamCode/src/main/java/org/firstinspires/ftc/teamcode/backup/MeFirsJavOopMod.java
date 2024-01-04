/*
Copyright 2021 FIRST Tech Challenge Team 16704

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp(name = "back_up_MeFirsJavOopMod", group = "backup")
public class MeFirsJavOopMod extends LinearOpMode {
    private Blinker expansion_Hub_10;
    private Blinker expansion_Hub_2;
    private DcMotor backLeftWheel;
    private DcMotor backRightWheel;
    private ColorSensor colorBack;
    private ColorSensor colorLeft;
    private ColorSensor colorRight;
    private DistanceSensor frontDistance;
    private DcMotor frontLeftWheel;
    private DcMotor frontRightWheel;
    private DcMotor gripper_motor;
    private Gyroscope imu_1;
    private Gyroscope imu;
    private DistanceSensor leftDistance;
    private Servo servo1;
    private Servo servo2;
    private Servo servoGripper1;
    private DcMotor shooter_motor;


    @Override
    public void runOpMode() {
        expansion_Hub_10 = hardwareMap.get(Blinker.class, "Expansion Hub 10");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
        backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
        colorBack = hardwareMap.get(ColorSensor.class, "colorBack");
        colorLeft = hardwareMap.get(ColorSensor.class, "colorLeft");
        colorRight = hardwareMap.get(ColorSensor.class, "colorRight");
        frontDistance = hardwareMap.get(DistanceSensor.class, "frontDistance");
        frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
        gripper_motor = hardwareMap.get(DcMotor.class, "gripper_motor");
        imu_1 = hardwareMap.get(Gyroscope.class, "imu 1");
        imu = hardwareMap.get(Gyroscope.class, "imu");
        leftDistance = hardwareMap.get(DistanceSensor.class, "leftDistance");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servoGripper1 = hardwareMap.get(Servo.class, "servoGripper1");
        shooter_motor = hardwareMap.get(DcMotor.class, "shooter_motor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}
