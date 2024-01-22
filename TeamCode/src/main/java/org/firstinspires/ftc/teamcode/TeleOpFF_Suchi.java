package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
@TeleOp(name = "TeleOpFF-Suchi", group = "")
public class TeleOpFF_Suchi extends LinearOpMode {
  private DcMotor frontLeftWheel;
  private DcMotor backLeftWheel;
  private DcMotor slide_motor;
  private DcMotor lift_motor;
  private DcMotor frontRightWheel;
  private DcMotor backRightWheel;
  private CRServo servo0; //intake servo
  private Servo servo1; //drone servo
  private Servo servo2; //up/down servo
  private Servo servo3; //gripper servo
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double Power_Back_Left;
    double Power_Back_Right;
    double Power_Front_left;
    double Power_Front_Right;
    double Power_Slide_Motor;
    double gamepadA;
    double gamepadB;
    double gamepadX;
    double gamepadY;
    double LeftTrigger;
    double RightTrigger;
    double LeftBumper;
    double RightBumper;
    double Left_Joy_Stick_X;
    double Left_Joy_Stick_Y;
    double Right_Joy_Stick_X;
    double Left_Joy_Stick_g2_Y;
    double left_Joy_Stick_g2_X;
    double Right_Joy_Stick_g2_Y;
    frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
    backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
    slide_motor = hardwareMap.get(DcMotor.class, "slide_motor");
    lift_motor = hardwareMap.get(DcMotor.class, "lift_motor");
    frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
    backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
    servo0 = hardwareMap.get(CRServo.class, "servo0");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    servo2 = hardwareMap.get(Servo.class, "servo2");
    servo3 = hardwareMap.get(Servo.class, "servo3");
    // Put initialization blocks here.


    //initialize lift, slide
    lift_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    slide_motor.setDirection(DcMotorSimple.Direction.FORWARD);

    //servo3.setPosition(1);
    //servo1.setPosition(1);
    //servo0.setPosition(0);
    //servo2.setPosition(0);

    waitForStart();

    frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE); //change
    backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE); //change
    frontRightWheel.setPower(0);
    frontLeftWheel.setPower(0);
    backRightWheel.setPower(0);
    backLeftWheel.setPower(0);


    if (opModeIsActive()) {
      // Put run blocks here.
      //servo0.setPosition(0);
      //servo3.setPosition(0.3);
      //servo1.setPosition(1);
      //servo2.setPosition(0);
      while (opModeIsActive()) {
    /*if (gamepad2.a) {
    gamepadA = 1;
    servo1.setPosition(0.8);
    servo2.setPosition(0.2);
    } else if (gamepad2.b) {
    gamepadB = 1;
    servo1.setPosition(1);
    servo2.setPosition(0);
    } else {
    gamepadA = 0.5;
    gamepadB = 0.5;
    }
    if (gamepad2.x) {
    gamepadX = 2;
    servo3.setPosition(0.3);
    } else if (gamepad2.y) {
    gamepadY = 2;
    servo3.setPosition(0); //test
    } else {
    gamepadY = 0.5;
    gamepadX = 0.5;
    }*/
    /*if(gamepad2.left_bumper) {
      servo0.setPosition(1);
    } else if(gamepad2.right_bumper){
      servo0.setPosition(0);
    }*/

        LeftTrigger = -gamepad2.left_trigger;
        RightTrigger = gamepad2.right_trigger;
        RightTrigger = RightTrigger * 100;
        LeftTrigger = LeftTrigger * 100;
        LeftTrigger = Range.clip(LeftTrigger, -100, 100);
        RightTrigger = Range.clip(RightTrigger, -100, 100);
        //4 lines of code for Trigger Wrubby. When left is pushed, it will run like autonomous to drop duck and stop
        Power_Slide_Motor = LeftTrigger+RightTrigger;
        slide_motor.setPower(Power_Slide_Motor);

        //counterclockwise will go down
        //clockwise will go up
        //Left_Joy_Stick_g2_Y = gamepad2.left_stick_y;
        /*frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setTargetPosition(855);
        frontLeftWheel.setTargetPosition(855);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);  */  //slide_motor.setPower(Left_Joy_Stick_g2_Y);
        //SERVO3 - Y will pick up team element and cap


        //lift motor code
        //double Right_Joy_Stick_g2_Y;
        Right_Joy_Stick_g2_Y = gamepad2.right_stick_y;

        double liftPower;

        double liftSpeed = 1.0; // Adjust the speed as needed

        if (Math.abs(Right_Joy_Stick_g2_Y) > 0.1) { // Joystick moved up

          liftPower = Right_Joy_Stick_g2_Y * liftSpeed;

          lift_motor.setPower(liftPower);

        }
        if (Math.abs(Right_Joy_Stick_g2_Y) < -0.1){ //JoyStick moved down

          liftPower = Right_Joy_Stick_g2_Y * -liftSpeed;

          lift_motor.setPower(liftPower);

        }
        else {

          lift_motor.setPower(0); // Stop the lift motor if joystick not moved

        }


        //intake servo code (sero0)
        double joystickInput = -gamepad2.left_stick_y; // Reverse the input if needed

        double servoSpeed = 100; // Adjust the speed as needed

        if (joystickInput > 0.1) { // Joystick pushed up
          servo0.setPower(joystickInput);
        } else if (joystickInput < -0.1) { // Joystick pushed down
          servo0.setPower(joystickInput);
        }

        telemetry.addData("Servo Power", servo0.getPower());
        telemetry.update();


        //drone servo code (servo1)
        boolean buttonA = gamepad2.a;
        boolean buttonB = gamepad2.b;

        if (buttonA) {
          servo1.setPosition(1.0);
        } else if (buttonB) {
          servo1.setPosition(-1.0);
        } else{
          servo1.setPosition(0);
        }

        telemetry.addData("Servo Position", servo1.getPosition());
        telemetry.update();


        //up/down servo code (servo2)
        boolean buttonX = gamepad2.x;
        boolean buttonY = gamepad2.y;

        if(buttonX){
          servo2.setPosition(0.2);
        }else if(buttonY){
          servo2.setPosition(0.9);
        }

        telemetry.addData("Servo Position", servo2.getPosition());
        telemetry.update();


        //gripper servo code
        boolean buttonX2 = gamepad1.x;
        boolean buttonY2 = gamepad1.y;

        if(buttonX2){
          servo3.setPosition(1.0);
        }else if(buttonY2){
          servo3.setPosition(0.0);
        }

        telemetry.addData("Servo Position", servo3.getPosition());
        telemetry.update();


        // Right_Joy_Stick_g2_Y = Range.clip(Right_Joy_Stick_g2_Y, -1, 0);
        //servo3.setPosition(-Right_Joy_Stick_g2_Y);
        Left_Joy_Stick_X = gamepad1.left_stick_x*1.1; //change
        Left_Joy_Stick_Y = -gamepad1.left_stick_y; //change
        Right_Joy_Stick_X = gamepad1.right_stick_x;
        double Denominator =
                Math.max(Math.abs(Left_Joy_Stick_Y)+Math.abs(Left_Joy_Stick_X)+Math.abs(Right_Joy_Stick_X),1);
        Power_Back_Left = ((Left_Joy_Stick_Y - Left_Joy_Stick_X) + Right_Joy_Stick_X)/Denominator;
        //Power_Back_Left = Math.min(Math.max(Power_Back_Left, -0.4), 0.4);
        Power_Back_Right = ((Left_Joy_Stick_Y + Left_Joy_Stick_X) -
                Right_Joy_Stick_X)/Denominator;
        //Power_Back_Right = Math.min(Math.max(Power_Back_Right, -0.4), 0.4);
        Power_Front_left = ((Left_Joy_Stick_Y + Left_Joy_Stick_X) + Right_Joy_Stick_X)/Denominator;
        //Power_Front_left = Math.min(Math.max(Power_Front_left, -0.4), 0.4);
        Power_Front_Right = ((Left_Joy_Stick_Y - Left_Joy_Stick_X) -
                Right_Joy_Stick_X)/Denominator;
        //Power_Front_Right = Math.min(Math.max(Power_Front_Right, -0.4), 0.4);
        // Put loop blocks here.
        frontLeftWheel.setPower(Power_Front_left);
        backLeftWheel.setPower(Power_Back_Left);
        frontRightWheel.setPower(Power_Front_Right);
        backRightWheel.setPower(Power_Back_Right);

        telemetry.addData("Left Joy Stick X", Left_Joy_Stick_X);
        telemetry.addData("Left Joy Stick Y", Left_Joy_Stick_Y);
        telemetry.addData("Right Joy Stick X", Right_Joy_Stick_X);
        telemetry.addData("Power Back Left", Power_Back_Left);
        telemetry.addData("Power Back Right", Power_Back_Right);
        telemetry.addData("Power Front Left", Power_Front_left);
        telemetry.addData("Power Front Right", Power_Front_Right);
        telemetry.addData("Left Trigger", LeftTrigger);
        telemetry.addData("Right Trigger", RightTrigger);
        telemetry.addData("Slide Motor Power", Power_Slide_Motor);
        telemetry.addData("servo0", servo0.getPower());
        telemetry.addData("servo1", servo1.getPosition());
        telemetry.addData("servo2", servo2.getPosition());
        telemetry.addData("servo3", servo3.getPosition());
        telemetry.update();
      }
    }
  }
}