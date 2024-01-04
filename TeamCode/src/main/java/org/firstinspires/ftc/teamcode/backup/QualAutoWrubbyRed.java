package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "back_up_QualAutoWrubbyRed.java", group = "backup")
public class QualAutoWrubbyRed extends LinearOpMode {

  private DcMotor frontLeftWheel;
  private DcMotor backLeftWheel;
  private DcMotor frontRightWheel;
  private DcMotor backRightWheel;
  private DcMotor wrubby_motor;
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
    servo2 = hardwareMap.get(Servo.class, "servo2");

    // Put initialization blocks here
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    wrubby_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(2480);
    frontLeftWheel.setTargetPosition(2480);
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    servo2.setPosition(1);
    waitForStart();
    wrubby_motor.setPower(0.3); //right spot?
    frontRightWheel.setPower(1);
    frontLeftWheel.setPower(1);
    backRightWheel.setPower(1);
    backLeftWheel.setPower(1);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    
    wrubby_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    wrubby_motor.setPower(0.3); //right spot?
    sleep(10000); //adjust time
    
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setTargetPosition(2480);
    frontLeftWheel.setTargetPosition(2480); //strafes right

    // Put run blocks here.
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    sleep(1000);
  }
}
