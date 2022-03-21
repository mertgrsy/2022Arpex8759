// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Shooter extends SubsystemBase {
  // DriveTrain subsytem için motor değişkenleri tanımlamaları
    CANSparkMax shooter;             //shooter motor 
    RelativeEncoder encoder;
    SparkMaxPIDController  shooterPID;
  /** Creates a new DriveTrain. */
  public Shooter() {  
    shooter = new CANSparkMax(Constants.SHOOTER, MotorType.kBrushless);
    shooter.restoreFactoryDefaults();
    encoder = shooter.getEncoder();
    /** 
    shooterPID.setP(Constants.proportialPIDConstant);
    shooterPID.setI(Constants.integralPIDConstant);
    shooterPID.setD(Constants.derivativePIDConstant);
    shooterPID.setIZone(Constants.integralPIDConstant);
    shooterPID.setFF(Constants.shooterPIDConstant);
    shooterPID.setOutputRange(Constants.minPIDOutput, Constants.maxPIDOutput);
    stop();
    shooter.burnFlash(); 
    */
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shootBall(double speed){
        shooter.set(speed);
        System.out.println(encoder.getVelocity());
  }
  public void stop(){
        shooter.set(0);
  }
}
