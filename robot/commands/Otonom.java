// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;
import frc.robot.subsystems.Limelight;


public class Otonom extends CommandBase {
  DriveTrain driveTrain;
  Shooter shooter;
  Storage storage;
  Intake intake;
  IntakeArm intakeArm;
  Limelight limelight;
  LimelightTarget limelightTarget;
  private boolean finish=false;
  Timer timer;
  double tx;
  
  /** Creates a new Otonom. */
  public Otonom(DriveTrain drive, Shooter shoot, Storage storag, Intake intak, Limelight limeligh, IntakeArm intakarm) {
    driveTrain = drive;
    addRequirements(driveTrain);
    shooter = shoot;
    addRequirements(shooter);
    storage = storag;
    addRequirements(storage);
    intake = intak;
    addRequirements(intake);
    intakeArm = intakarm;

    limelight = new Limelight();
    addRequirements(limelight);
    timer = new Timer();
    limelightTarget = new LimelightTarget(limelight);
    limelightTarget.addRequirements(limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 
    timer.reset();
    timer.start();
    while (timer.get()<1)
    {
      intakeArm.intakeArmPosition(0.5);
    }
    timer.reset();
    timer.start();
    while (timer.get()<1.5)
    {
      intakeArm.intakeArmPosition(0);
      driveTrain.driveForward(-1*Constants.AUTONOMOUS_SPEED);
      intake.intakeBall(Constants.STORAGE_SPEED);
    }
    timer.reset();
    timer.start();
    while (timer.get()<0.1)
    {
      driveTrain.driveForward(Constants.AUTONOMOUS_SPEED);
    }
    timer.reset();
    timer.start();
    while (timer.get()<1.4)
    {
      driveTrain.driveForward(0);
      intake.intakeBall(Constants.INTAKE_SPEED);
    }
    timer.reset();
    timer.start();
    while (timer.get()<0.7)
    {
      storage.storageBall(Constants.STORAGE_SPEED-0.1);
      intake.intakeBall(Constants.INTAKE_SPEED);
    }
    timer.reset();
    timer.start();
    while (timer.get() < 1){
      intake.intakeBall(0);
      storage.storageBall(0);
      DriveTrain.targeting(0.6, -0.6);
    }
    timer.reset();
    timer.start();
    limelight.target();
    while (timer.get()<7){
      shooter.shootBall(0.52);
      while (timer.get()<1.7) {
        limelight.target();
        shooter.shootBall(0.52);
      }
      while (3<timer.get() && timer.get()<4){
        shooter.shootBall(0.52);
        storage.storageBall(Constants.STORAGE_SPEED-0.3);
      }
      while (4<timer.get() && timer.get()<3.1){
        shooter.shootBall(0.52);
        storage.storageBall(0);
      }
      while (4.1<timer.get() && timer.get()<7){
        shooter.shootBall(0.52);
        storage.storageBall(Constants.STORAGE_SPEED-0.3);
      }
    }
    timer.reset();
    storage.storageBall(0);
    shooter.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
