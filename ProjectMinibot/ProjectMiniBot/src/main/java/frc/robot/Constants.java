// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    public static class WiringConstants {
        public static final int k_rightMotorPWMPin = 0;
        public static final int k_leftMotorPWMPin = 0;

        public static final int k_rightMotorDirPin = 0;
        public static final int k_leftMotorDirPin = 0;

        public static final int k_leftMotorID = 0;
        public static final int k_rightMotorID = 1;

        public static final int k_rightEncoderPin1 = 0;
        public static final int k_rightEncoderPin2 = 0;

        public static final int k_leftEncoderPin1 = 0;
        public static final int k_leftEncoderPin2 = 0;
    }

    public static class PIDConstants {
        public static final double kF_left = 0;
        public static final double kF_right = 0;
        public static final double k_maxSpeed = 0; 

        public static final double kP = 0;
        public static final double kI = 0;
        public static final double kD = 0;

        public static final double k_posTolerance = 5;
        public static final double k_vTolerance = 5;
        public static final double k_maxIntegral = 5;
        public static final double k_minIntegral = 5;

    }
}
