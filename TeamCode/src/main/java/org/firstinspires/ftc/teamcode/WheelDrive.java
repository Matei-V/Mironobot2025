package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

public class WheelDrive {

    public DcMotor lF;
    public DcMotor rF;
    public DcMotor lB;
    public DcMotor rB;

    public void move(double speed, double strafe, double turn){
        double leftFront = speed + turn + strafe;
        double rightFront = speed - turn - strafe;
        double leftBack = speed+ turn - strafe;
        double rightBack = speed - turn + strafe;

        lF.setPower(0.2*leftFront);
        rF.setPower(0.2*rightFront);
        lB.setPower(0.2*leftBack);
        rB.setPower(0.2*rightBack);

    }
}
