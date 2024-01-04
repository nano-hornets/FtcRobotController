package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "back_up_RedTermRedAuto.java", group = "backup")
public class RedTermRedAuto extends LinearOpMode {

  private DcMotor frontLeftWheel;
  private DcMotor backLeftWheel;
  private DcMotor wrubby_motor;
  private DcMotor slide_motor;
  private DcMotor frontRightWheel;
  private DcMotor backRightWheel;
  private Servo servo1;
  private Servo servo2;
  private Servo servo3;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
    backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
    frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
    backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
    slide_motor = hardwareMap.get(DcMotor.class, "slide_motor");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    servo2 = hardwareMap.get(Servo.class, "servo2");
    servo3 = hardwareMap.get(Servo.class, "servo3");
    
    // Put initialization blocks here
    servo3.setPosition(0);
    servo2.setPosition(0);
    servo1.setPosition(1);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    
    waitForStart();
    
    frontLeftWheel.setTargetPosition(-538);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setPower(0.4);
    
    while (opModeIsActive()) {
      // Put loop blocks here
      telemetry.addData("CurrentPosition", frontLeftWheel.getCurrentPosition());
      telemetry.addData("TargetPosition", frontLeftWheel.getTargetPosition());
      telemetry.update();
    }
    /*drive forward (two blocks, 22.75)
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(855);
    frontLeftWheel.setTargetPosition(855);
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    sleep(3000);
    
    // a 45 degree right turn to the right
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontLeftWheel.setPower(0.4);
    frontRightWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    sleep(500);
    //check
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    /*small drive forward
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(428); //FEB12 //855
    frontLeftWheel.setTargetPosition(428); //FEB12  //855
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);*/
    
    //raise slide to hight of tall junction
    //check
    //high junction is 33.5 inches 
    //motors have (about) 537.6 tics per revolution 
    //count how many revolutions it takes to get to the top junction
    //maybe lower servo 3??
    //servo2.setPosition(0.6); 
    //servo1.setPosition(0.6);
    /*sleep(500);
    
    //slide_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    //slide_motor.setPower(0.4); //tweak
    sleep(5000); //time it 
    //slide_motor.setPower(0.0);
    
    //open gripper
    //test
    //servo2.setPosition(0.8); //test
    //servo1.setPosition(-0.8);
    
    //small drive backward
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(428); //FEB12 //855
    frontLeftWheel.setTargetPosition(428); //FEB12  //855
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //lower slide
   // slide_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    //slide_motor.setPower(0.4); //tweak
    sleep(5000); //time it 
    //slide_motor.setPower(0.0);
    
    //a 45 degree left turn to the left
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    sleep(500);//test, org: 1000
    frontRightWheel.setPower(0.3);
    frontLeftWheel.setPower(0.5); //FEB12 0.4
    backRightWheel.setPower(0.3);
    backLeftWheel.setPower(0.5);
    sleep(500);//test, org: 1000
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //drive backward to wall
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(855); //FEB12
    frontLeftWheel.setTargetPosition(855); //FEB12
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //straif right (half a block), test straif
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    sleep(500);//test
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    sleep(500);//test
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    */
    
    //park on blue trianle 
    
    //scores 5 for high junction
    //scores 2 for parked in alliance substation
    //7 points total 
  }
} 

