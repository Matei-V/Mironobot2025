package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name="Autonomie")
public class Auto_tractari extends OpMode {

    WheelDrive Drive =  new WheelDrive();
    Odometry Pos = new Odometry();
    Controler ctrldel = new Controler();
    ArmDrive brat = new ArmDrive();
    ElapsedTime timer = new ElapsedTime();

    LinearAlgebra matematix = new LinearAlgebra();
    public int gata = 0;
    @Override
    public void init() {
        init_wheel();
    }

    @Override
    public void loop() {
       double z[][] = Pos.get_pos();

       double zt[][] = new double[1][3];

       zt[0][0] = 5;
       zt[0][1] = 5;
       zt[0][2] = 30;

       double K[][] = ctrldel.get_K(z[0][2]);

       double u[][] = matematix.multiplyMatrix(3,3, K, 3, 1, matematix.substractMatrix(6, 1, zt, 6, 1, z));
       
       Drive.move(u[0][0], u[0][1], u[0][2]);
    }

    public void init_wheel(){
        Drive.lF = hardwareMap.get(DcMotor.class, "leftFront");
        Drive.rF = hardwareMap.get(DcMotor.class, "rightFront");
        Drive.lB = hardwareMap.get(DcMotor.class, "leftBack");
        Drive.rB = hardwareMap.get(DcMotor.class, "rightBack");
        Drive.lF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.rF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.lB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Drive.rB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Drive.lF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.rF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.lB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Drive.rB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        brat.arm = hardwareMap.get(DcMotorEx.class, "arm");

        brat.wrist = hardwareMap.get(Servo.class, "wrist");
        brat.grip =hardwareMap.get(Servo.class, "grip");



        brat.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        brat.wrist.setPosition(0.7);


    }
}
