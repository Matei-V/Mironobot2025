package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.checkerframework.checker.units.qual.A;


@TeleOp(name = "MainDrive")
public class MainDrive extends OpMode {

    WheelDrive Drive =  new WheelDrive();

    ArmDrive Arm = new ArmDrive();
    public Servo Antonov;


    public double target_arm;

    @Override
    public void init() {
        init_all();
    }

    @Override
    public void loop() {


        double speed = -gamepad1.left_stick_y - gamepad2.left_stick_y;
        double turn = gamepad1.right_stick_x + gamepad2.right_stick_x;
        double strafe = gamepad1.left_stick_x + gamepad2.left_stick_x;

        Drive.move(speed, strafe, turn);

        if(gamepad1.dpad_right || gamepad2.dpad_right){
            Arm.grip.setPosition(0.45);
        }

        if(gamepad1.dpad_left || gamepad2.dpad_left){
            Arm.grip.setPosition(1);
        }

        if(gamepad1.back || gamepad2.back){
            telemetry.addData("d", 1);
            Antonov.setPosition(0);
        }

        if(gamepad1.a || gamepad2.a){
            target_arm = 100;
        }

        if(gamepad1.b || gamepad2.b){
            target_arm = 1300;
        }

        if(gamepad1.dpad_up || gamepad2.dpad_up){
            Arm.wrist.setPosition(0.25);
        }
        if(gamepad1.dpad_down || gamepad2.dpad_down) {
            Arm.wrist.setPosition(0.5);
        }

        if(gamepad1.right_bumper || gamepad2.right_bumper){
            target_arm = Arm.arm.getCurrentPosition() + 3;
        }


        if(gamepad1.left_bumper || gamepad2.left_bumper){
            target_arm = Arm.arm.getCurrentPosition() - 3;
        }
        telemetry.update();
    }



    public void init_all(){
        Drive.lF = hardwareMap.get(DcMotor.class, "leftFront");
        Drive.rF = hardwareMap.get(DcMotor.class, "rightFront");
        Drive.lB = hardwareMap.get(DcMotor.class, "leftBack");

        Drive.rB = hardwareMap.get(DcMotor.class, "rightBack");
        Drive.lF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.rF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.lB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.rB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Drive.lF.setDirection(DcMotor.Direction.REVERSE);
        Drive.lB.setDirection(DcMotor.Direction.REVERSE);

        Drive.lF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.rF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.lB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.rB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Arm.arm = hardwareMap.get(DcMotorEx.class, "arm");

        //brat.lift_b.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //brat.lift_f.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Arm.wrist = hardwareMap.get(Servo.class, "wrist");
        Arm.grip =hardwareMap.get(Servo.class, "grip");



        Arm.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Antonov = hardwareMap.get(Servo.class, "707");

        target_arm = Arm.arm.getCurrentPosition();

    }


}
