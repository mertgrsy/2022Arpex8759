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
    
    public static final int LEFT_FRONT = 3;
    public static final int RIGHT_FRONT = 5;
    public static final int LEFT_BACK = 2;
    public static final int RIGHT_BACK = 4;
    
    public static final int SHOOTER = 1;
    public static final int INTAKE_FRONT = 9;
    public static final int INTAKE_BACK = 8;
    public static final int CLIMB_MOTOR = 7;
    public static final int STORAGE = 6;

    public static final double DRIVETRAINSPEED = 1;
    public static final double DRIVE_FORWAD_TIME = 1;
    public static final double AUTONOMOUS_SPEED = 0.7;
    
    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int XBOX_RIGHT_X_AXIS = 2;
    public static final int JOYSTICK_NUMBER = 0;
    public static final int RIGHT_TRIGGER = 3;   

    public static final double INTAKE_SPEED = 1;
    public static final double INTAKE_REVERSE_SPEED = -1;
    public static final double INTAKE_UP_SPEED = -0.7;
    public static final double INTAKE_DOWN_SPEED = 0.5;
    public static double SHOOTER_SPEED = 0;
    public static final double CLIMB_DOWN = 1;
    public static final double CLIMB_UP = -0.6;
    public static final double STORAGE_SPEED = 1;

    public static final int SHOOT_BUTTON = 1;
    public static final int INTAKE_BUTTON = 3;
    public static final int INTAKE_REVERSE_BUTTON = 5;
    public static final int CLIMB_DOWN_BUTTON = 4;
    public static final int CLIMB_UP_BUTTON = 6;
    public static final int STORAGE_FULL_BUTTON = 7;
    public static final int STORAGE_REVERSE_BUTTON = 8;
    public static final int INTAKE_ARM_UP = 10;
    public static final int INTAKE_ARM_DOWN = 9;
    public static final int TARGET_BUTTON = 2;
    
    public static final double proportialPIDConstant = 0.0002;
    public static final double integralPIDConstant = 0.0;
    public static final double derivativePIDConstant = 0.0;
    public static final double shooterPIDConstant = 0.000175;
    public static final double maxPIDOutput = 1.0;
    public static final double minPIDOutput = 0.0;
}
