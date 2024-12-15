package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Odometry {
    double x, y, theta;
    DcMotor L, R, C;
    double l_pos, r_pos, c_pos;
    double trackwidth=10, forward_offset=10;

    public void update_position(){
        double left_encoder_pos = L.getCurrentPosition();
        double right_encoder_pos = R.getCurrentPosition();
        double center_encoder_pos = C.getCurrentPosition();

        double delta_left_encoder_pos   = left_encoder_pos - l_pos;
        double delta_right_encoder_pos  = right_encoder_pos - r_pos;
        double delta_center_encoder_pos = center_encoder_pos - c_pos;

        double phi = (delta_left_encoder_pos - delta_right_encoder_pos) / trackwidth;
        double delta_middle_pos = (delta_left_encoder_pos + delta_right_encoder_pos) / 2;
        double delta_perp_pos = delta_center_encoder_pos - forward_offset * phi;

        double delta_x = delta_middle_pos * Math.cos(theta) - delta_perp_pos * Math.sin(theta);
        double delta_y = delta_middle_pos * Math.sin(theta) + delta_perp_pos * Math.cos(theta);

        x += delta_x;
        y += delta_y;
        theta += phi;

        l_pos = left_encoder_pos;
        r_pos = right_encoder_pos;
        c_pos = center_encoder_pos;
    }
    public double[][] get_pos(){
        double z[][] = new double[1][3];
        z[0][0] = x;
        z[0][1] = y;
        z[0][2] = Math.toDegrees(theta);

        return z;
    }
}
