package org.firstinspires.ftc.teamcode.backup;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "back_up_Auto1Red", group = "")
public class Auto1Red extends LinearOpMode {

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
    slide_motor = hardwareMap.get(DcMotor.class, "slide_motor");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    servo2 = hardwareMap.get(Servo.class, "servo2");
    
    //NEWCODE
    int slidesleep = 6250; //FEB12

    
    // Put initialization blocks here
    servo2.setPosition(0.8);
    servo1.setPosition(0.6);
    slide_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    
    servo2.setPosition(0.6);
    slide_motor.setPower(0.4); //tweak
    sleep(slidesleep); //time it 
    slide_motor.setPower(0.0);
    

    //MOVE FORWARD 2 BLOCKS
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
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
    
    //grippy
    servo2.setPosition(0.6);
    servo1.setPosition(0.2); //test
    sleep(500);
    
    //MOVE BACKWARD 2 BLOCKS
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(200);
    frontLeftWheel.setTargetPosition(200);
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
    frontRightWheel.setPower(0);
    frontLeftWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    servo2.setPosition(0.6); 
    servo1.setPosition(0.6);
    sleep(500);

    //FEB12
    
    /*
    slide_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    slide_motor.setPower(0.4); //tweak
    sleep(5000); //time it 
    slide_motor.setPower(0.0);
    */
    servo2.setPosition(0.8); //test
    
    //STRAFE left
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    sleep(1000);
    frontRightWheel.setPower(0.5);
    frontLeftWheel.setPower(0.5);
    backRightWheel.setPower(0.5);
    backLeftWheel.setPower(0.5);
    sleep(3000);//weak
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    sleep(500);
    
    //MOVE TO CAROUSEL
    backRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    //frontRightWheel.setTargetPosition(215); //1755
    //frontLeftWheel.setTargetPosition(215);
    //frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //FEB12
    backRightWheel.setTargetPosition(260); //211
    backLeftWheel.setTargetPosition(260);
    backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.05); //0.2
    frontLeftWheel.setPower(0.05);
    backRightWheel.setPower(0.05);
    backLeftWheel.setPower(0.05);
    while (!(!backLeftWheel.isBusy() || !backRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickBR", backRightWheel.getCurrentPosition());
      telemetry.addData("TicksBL", backLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    
    //WRUBBY CODE
    wrubby_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    wrubby_motor.setPower(0.4); //FEB12 0.4
    sleep(3000); //adjust time //FEB12
    wrubby_motor.setPower(0.0);
    

    //STRAFE RIGHT
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    sleep(1000);
    frontRightWheel.setPower(0.5);
    frontLeftWheel.setPower(0.5);
    backRightWheel.setPower(0.5);
    backLeftWheel.setPower(0.5);
    sleep(2400);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //TURN RIGHT
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    sleep(1000);
    frontRightWheel.setPower(0.3);
    frontLeftWheel.setPower(0.5); //FEB12 0.4
    backRightWheel.setPower(0.3);
    backLeftWheel.setPower(0.5);
    sleep(1000);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //STRAFE RIGHT
    frontRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    sleep(1000);
    frontRightWheel.setPower(0.4);
    frontLeftWheel.setPower(0.4);
    backRightWheel.setPower(0.4);
    backLeftWheel.setPower(0.4);
    sleep(1000);
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
    //MOVE FORWARD TO WAREHOUSE
    frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    frontRightWheel.setTargetPosition(2785);
    frontLeftWheel.setTargetPosition(2785);
    frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    frontRightWheel.setPower(0.6);
    frontLeftWheel.setPower(0.6);
    backRightWheel.setPower(0.6);
    backLeftWheel.setPower(0.6);
    while (!(!frontLeftWheel.isBusy() || !frontRightWheel.isBusy())) {
      // Put loop blocks here
      telemetry.addData("TickFR", frontRightWheel.getCurrentPosition());
      telemetry.addData("TicksFL", frontLeftWheel.getCurrentPosition());
      telemetry.update();
    }
    // Put run blocks here.
    frontLeftWheel.setPower(0);
    frontRightWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);
    
  }
}
