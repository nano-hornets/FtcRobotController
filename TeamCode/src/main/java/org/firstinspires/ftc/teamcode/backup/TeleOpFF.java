package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "back_up_TeleOpFF", group = "backup")
public class TeleOpFF extends LinearOpMode {
    //change gripper(rubby) onto gamepad 2 
  private DcMotor frontLeftWheel;
  private DcMotor backLeftWheel;
  private DcMotor wrubby_motor;
  private DcMotor slide_motor;
  private DcMotor frontRightWheel;
  private DcMotor backRightWheel;
  private Servo servo1;
  //private Servo servo2;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double Power_Back_Left;
    double Power_Back_Right;
    double Power_Front_left;
    double Power_Front_Right;
    double gamepadA;
    double gamepadB;
    double gamepadX;
    double gamepadY;
    double LeftTrigger;
    double RightTrigger;
    double LeftBumper;
    double RightBumper;
    float Left_Joy_Stick_X;
    double Left_Joy_Stick_Y;
    float Right_Joy_Stick_X;

    frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
    backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
    wrubby_motor = hardwareMap.get(DcMotor.class, "wrubby_motor");
    slide_motor = hardwareMap.get(DcMotor.class, "slide_motor");
    frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
    backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    //servo2 = hardwareMap.get(Servo.class, "servo2");

    // Put initialization blocks here.
    waitForStart();
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    Power_Back_Left = 0;
    Power_Back_Right = 0;
    Power_Front_left = 0;
    Power_Front_Right = 0;
    if (opModeIsActive()) {
      // Put run blocks here.
     // servo2.setPosition(1);
      while (opModeIsActive()) {
        if (gamepad2.a) {
          gamepadA = 1;
          servo1.setPosition(0);
          //servo2.setPosition(1);
        } else if (gamepad2.b) {
          gamepadB = 1;
          servo1.setPosition(1);
          //servo2.setPosition(0);
        } else {
          gamepadA = 0;
          gamepadB = 0;
        }
        /*if (gamepad2.x) {
          gamepadX = 1;
          servoGripper1.setPosition(1);
        } else if (gamepad2.y) {
          gamepadY = 1;
          servoGripper1.setPosition(0.5);
        } else {
          gamepadY = 0;
          gamepadX = 0;
        }*/
        LeftTrigger = -gamepad2.left_trigger;
        RightTrigger = gamepad2.right_trigger;
        LeftTrigger = Range.clip(LeftTrigger, -0.3, 0.3);
        RightTrigger = Range.clip(RightTrigger, -0.3, 0.3);
        wrubby_motor.setPower(LeftTrigger + RightTrigger);
        
        // Left_Joy_Stick_Y = gamepad2.left_stick_y;
//counterclockwise will go down
//clockwise will go up
 
        
        Left_Joy_Stick_X = gamepad1.left_stick_x;
        Left_Joy_Stick_Y = gamepad1.left_stick_y;
        Right_Joy_Stick_X = gamepad1.right_stick_x;
        Power_Back_Left = (Left_Joy_Stick_Y - Left_Joy_Stick_X) + Right_Joy_Stick_X;
        Power_Back_Left = Math.min(Math.max(Power_Back_Left, -1), 1);
        Power_Back_Right = (Left_Joy_Stick_Y + Left_Joy_Stick_X) - Right_Joy_Stick_X;
        Power_Back_Right = Math.min(Math.max(Power_Back_Right, -1), 1);
        Power_Front_left = Left_Joy_Stick_Y + Left_Joy_Stick_X + Right_Joy_Stick_X;
        Power_Front_left = Math.min(Math.max(Power_Front_left, -1), 1);
        Power_Front_Right = (Left_Joy_Stick_Y - Left_Joy_Stick_X) - Right_Joy_Stick_X;
        Power_Front_Right = Math.min(Math.max(Power_Front_Right, -1), 1);
        // Put loop blocks here.
        frontRightWheel.setPower(Power_Front_Right);
        frontLeftWheel.setPower(Power_Front_left);
        backRightWheel.setPower(Power_Back_Right);
        backLeftWheel.setPower(Power_Back_Left);
        telemetry.addData("Left Joy Stick X", Left_Joy_Stick_X);
        telemetry.addData("Left Joy Stick Y", Left_Joy_Stick_Y);
        telemetry.addData("Right Joy Stick X", Right_Joy_Stick_X);
        telemetry.addData("Power Back Left", Power_Back_Left);
        telemetry.addData("Power Back Right", Power_Back_Right);
        telemetry.addData("Power Front Left", Power_Front_left);
        telemetry.addData("Power Front Right", Power_Front_Right);
        telemetry.addData("Left Trigger", LeftTrigger);
        telemetry.addData("Right Trigger", RightTrigger);
        telemetry.addData("servo1", servo1.getPosition());
        //telemetry.addData("servo2", servo2.getPosition());
        telemetry.update();
      }
    }
  }
}