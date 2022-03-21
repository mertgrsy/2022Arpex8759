// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Limelight;

public class LimelightDistance extends CommandBase {
  Limelight limelight;
  /** Creates a new LimelightDistance. */
  public LimelightDistance(Limelight s) {
    limelight = s;
    addRequirements(limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ty; 
    ty = limelight.getTy();

    double targetOffsetAngle_Vertical = ty;

    double limelightMountAngleDegrees = 31.0;

    double limelightLensHeightInches = 22;

    double goalHeightInches = 104.0;

    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians);

    if(distanceFromLimelightToGoalInches < 19.7){
      Constants.SHOOTER_SPEED = 0.3;
    }
    //0.5-1m
    else if(19.8 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 39.4){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 19)/700+0.36;
    }
    //1-2m
    else if(39.5 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 78.4){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 39.5)/530+0.40;
    }
    //2-3m
    else if(78.9 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 98){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 78.9)/780+0.45;
    }
    else if(98.1 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 118.1){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 98.1)/780+0.47;
    }
    //3-4m
    else if(118.2 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 157.5){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 118.2)/780+0.5;
    }
    //4-5m
    else if(157.7 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 196.85){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 157.7)/780+0.54;
    }
    //5-6m
    else if(196.86 <distanceFromLimelightToGoalInches && distanceFromLimelightToGoalInches < 236.22){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 196.86)/600+0.6;
    }
    else if(236.23 < distanceFromLimelightToGoalInches){
      Constants.SHOOTER_SPEED = (distanceFromLimelightToGoalInches - 236.23)/600+0.65;
    }
    else{
      Constants.SHOOTER_SPEED = 0.3;
    }
    System.out.println(distanceFromLimelightToGoalInches);
    System.out.println(Constants.SHOOTER_SPEED);
  }
 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
