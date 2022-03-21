// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class LimelightTarget extends CommandBase {
  Limelight limelight;
  double ty; 
  double tx;
  /** Creates a new LimelightTarget. */
  public LimelightTarget(Limelight s) {
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
    tx = limelight.getTx();
    if(tx > 2){
      DriveTrain.targeting(-0.4, 0.4);
    }
    else if(tx < -2){
      DriveTrain.targeting(0.4, -0.4);
    }
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
