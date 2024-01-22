/* Copyright (c) 2019 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import com.qualcomm.robotcore.hardware.CRServo;


import java.util.List;

/*
 * This OpMode illustrates the basics of TensorFlow Object Detection,
 * including Java Builder structures for specifying Vision parameters.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
 */
@Autonomous(name = "Hailey's Excellent Camera Red", group = "Concept")


public class CameraCodeRed extends LinearOpMode {
    
    
    private static final int ENCODER_RESOLUTION = 538;
    private DcMotor frontLeftWheel;
    private DcMotor backLeftWheel;
    private DcMotor slide_motor;
    private DcMotor frontRightWheel;
    private DcMotor backRightWheel;
    private CRServo servo0;

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    // TFOD_MODEL_ASSET points to a model file stored in the project Asset location,
    // this is only used for Android Studio when using models in Assets.
    //private static final String TFOD_MODEL_ASSET = "MyModelStoredAsAsset.tflite";
    // TFOD_MODEL_FILE points to a model file stored onboard the Robot Controller's storage,
    // this is used when uploading models directly to the RC using the model upload interface.
    private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/redBlock";
    // Define the labels recognized in the model for TFOD (must be in training order!)
    private static final String[] LABELS = {
       "red block",
    };

    /**
     * The variable to store our instance of the TensorFlow Object Detection processor.
     */
    private TfodProcessor tfod;

    /**
     * The variable to store our instance of the vision portal.
     */
    private VisionPortal visionPortal;

    private double xCoordinate = 0;  // Variable to store x-coordinate
    private String chosenMovement = "No Specific Movement";  // Variable to store chosen movement
    
    
    
    private void moveForward(int full, int quarter){
        int ticCount = ENCODER_RESOLUTION * full + (ENCODER_RESOLUTION * quarter) / 4;
        
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        
    }
    
    private void moveLeft(){
        int ticCount = ENCODER_RESOLUTION * 2 + ENCODER_RESOLUTION / 4;
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        
        
    }
    
    private void moveRight(){
        int ticCount = ENCODER_RESOLUTION / 2;
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
    }
    
    private void moveBack(int quarters){
        int ticCount = ENCODER_RESOLUTION * quarters / 4;
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        
    }
    
    private void turnLeft(){
        
        int ticCount = ENCODER_RESOLUTION/ 1 ;
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        
    }
    
    private void turnRight(){
        
        int ticCount = ENCODER_RESOLUTION + (ENCODER_RESOLUTION / 2);
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
    }
    
    private void moveCenter(){
        
        int ticCount = ENCODER_RESOLUTION / 3;
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        
        frontLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        frontRightWheel.setTargetPosition(ticCount);
        frontLeftWheel.setTargetPosition(ticCount);
        backRightWheel.setTargetPosition(ticCount);
        backLeftWheel.setTargetPosition(ticCount);
        
        frontRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRightWheel.setPower(0.4);
        frontLeftWheel.setPower(0.4);
        backRightWheel.setPower(0.4);
        backLeftWheel.setPower(0.4);
        
        while (frontRightWheel.isBusy()) {
            // Put loop blocks here
        }
    
        frontRightWheel.setPower(0);
        frontLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        
    }
    
    private void ejectPixel(){
        
        servo0.setDirection(DcMotorSimple.Direction.FORWARD);
        servo0.setPower(1.0);
        sleep(2000);
        servo0.setPower(0);
        
    }
    
    
    private void initalizeMotors(){
        frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
        backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
        backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
        slide_motor = hardwareMap.get(DcMotor.class, "slide_motor");
        
        frontLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        
        frontLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    }
    
    private void initalizeServos(){
        servo0 = hardwareMap.get(CRServo.class, "servo0");
    }
    
public int detectBlock(){
            
    telemetryTfod();
    
    if (!tfod.getRecognitions().isEmpty()) {
        Recognition blueBlock = tfod.getRecognitions().get(0);
        xCoordinate = (blueBlock.getLeft() + blueBlock.getRight()) / 2;

                    // Determine the movement based on x-coordinate
                    if (xCoordinate < 300) {
                       return 0;
                    } else if (xCoordinate >= 300) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
                return 2;
} 
    
    @Override
    public void runOpMode() {

        initTfod();
        initalizeMotors();
        initalizeServos();
        // Wait for the DS start button to be touched.
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();
        
        int blockLocation = -1;
        
        while(!isStarted()){
            
            blockLocation = detectBlock();
            telemetry.addData("Location", "%d", blockLocation);
            telemetry.update();
            
        }
        
        waitForStart();

        if (opModeIsActive()) {

                if (blockLocation == 0) {
                        chosenMovement = "Move Left";
                        // Add robot movement to the left.
                        // e.g., moveLeft();
                        moveRight();
                        moveForward(1,2);
                        turnLeft();
                        moveForward(0,1);
                        ejectPixel();
                        moveBack(2);
                        
                    } else if (blockLocation == 1) {
                        chosenMovement = "Move Center";
                        // Add robot movement to the center.
                        // e.g., moveCenter();
                        moveCenter();
                        moveForward(2,1);
                        ejectPixel();
                        moveBack(2);
                    } else {
                        chosenMovement = "Move Right";
                        moveRight();
                        moveForward(2,1);
                        turnRight();
                        moveForward(0,1);
                        ejectPixel();
                        moveBack(2);
                    }

                // Display the chosen movement on the Driver Station.
                while(opModeIsActive()){
                    
                    telemetry.addData("Chosen Movement", chosenMovement);
                     telemetry.update();
                }
        }
    

        // Save more CPU resources when camera is no longer needed.
        visionPortal.close();

    }   // end runOpMode()

    /**
     * Initialize the TensorFlow Object Detection processor.
     */
    private void initTfod() {

        // Create the TensorFlow processor by using a builder.
        tfod = new TfodProcessor.Builder()

            // With the following lines commented out, the default TfodProcessor Builder
            // will load the default model for the season. To define a custom model to load, 
            // choose one of the following:
            //   Use setModelAssetName() if the custom TF Model is built in as an asset (AS only).
            //   Use setModelFileName() if you have downloaded a custom team model to the Robot Controller.
            //.setModelAssetName(TFOD_MODEL_ASSET)
            .setModelFileName(TFOD_MODEL_FILE)

            // The following default settings are available to un-comment and edit as needed to 
            // set parameters for custom models.
            .setModelLabels(LABELS)
            .setIsModelTensorFlow2(true)
            .setIsModelQuantized(true)
            .setModelInputSize(300)
            .setModelAspectRatio(16.0 / 9.0)

            .build();

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }

        // Choose a camera resolution. Not all cameras support all resolutions.
        //builder.setCameraResolution(new Size(640, 480));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        //builder.enableLiveView(true);

        // Set the stream format; MJPEG uses less bandwidth than default YUY2.
        //builder.setStreamFormat(VisionPortal.StreamFormat.YUY2);

        // Choose whether or not LiveView stops if no processors are enabled.
        // If set "true", monitor shows solid orange screen if no processors enabled.
        // If set "false", monitor shows camera view without annotations.
        //builder.setAutoStopLiveView(false);

        // Set and enable the processor.
        builder.addProcessor(tfod);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

        // Set confidence threshold for TFOD recognitions, at any time.
        //tfod.setMinResultConfidence(0.75f);

        // Disable or re-enable the TFOD processor at any time.
        //visionPortal.setProcessorEnabled(tfod, true);
        
    }   // end method initTfod()

    /**
     * Add telemetry about TensorFlow Object Detection (TFOD) recognitions.
     */
    private void telemetryTfod() {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {
            double x = (recognition.getLeft() + recognition.getRight()) / 2 ;
            double y = (recognition.getTop()  + recognition.getBottom()) / 2 ;

            telemetry.addData(""," ");
            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
            telemetry.addData("- Position", "%.0f / %.0f", x, y);
            telemetry.addData("- Size", "%.0f x %.0f", recognition.getWidth(), recognition.getHeight());
            telemetry.addData("- Camera width", "%d", recognition.getImageWidth());
        }   // end for() loop

    }   // end method telemetryTfod()

}   // end class
