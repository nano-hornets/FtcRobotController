package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "back_up_TURNN", group = "backup")
public class TURNN extends LinearOpMode {

  private DcMotor frontLeftWheel;
  private DcMotor backLeftWheel;
  private DcMotor wrubby_motor;
  private DcMotor slide_motor;
  private DcMotor frontRightWheel;
  private DcMotor backRightWheel;
  private Servo servo1;
  private Servo servo2;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
    backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
    frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
    backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
    wrubby_motor = hardwareMap.get(DcMotor.class, "wrubby_motor");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    servo2 = hardwareMap.get(Servo.class, "servo2");
    
    // Put initialization blocks here
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    frontLeftWheel.setPower(0.4);
    frontRightWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    sleep(1000);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
      /*  //MOVE BACKWARD 2 BLOCKS
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(900);
    frontLeftWheel.setTargetPosition(900);
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    servo2.setPosition(0.5);
    servo1.setPosition(0);
    slide_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    slide_motor.setPower(0.2); //tweak
    sleep(2500);//half the previous
    waitForStart();
    frontRightWheel.setPower(0.5);
    frontLeftWheel.setPower(0.5);
    backRightWheel.setPower(0.5);
    backLeftWheel.setPower(0.5);
     while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    frontRightWheel.setPower(0);
    frontLeftWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    sleep(2000);
    
    //turn
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    sleep(1000);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    sleep(1050);//weak
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
     //MOVE TO CAROUSEL
    frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(215); //1755
    frontLeftWheel.setTargetPosition(215);
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    waitForStart();
    frontRightWheel.setPower(0.2);
    frontLeftWheel.setPower(0.2);
    backRightWheel.setPower(0.2);
    backLeftWheel.setPower(0.2);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);

    */
  }

}
