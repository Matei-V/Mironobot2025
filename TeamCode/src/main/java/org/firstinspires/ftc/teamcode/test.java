package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "test")
public class test extends OpMode {

    DcMotor test_motor;
    DistanceSensor ds;
    @Override
    public void init() {
        //ds = hardwareMap.get(DistanceSensor.class, "ds");
        test_motor = hardwareMap.get(DcMotor.class, "lift_f");
    }

    @Override
    public void loop() {
        test_motor.setPower(0.3);
       // telemetry.addData("dist: ", ds.getDistance(DistanceUnit.CM));
        telemetry.update();
    }
}
