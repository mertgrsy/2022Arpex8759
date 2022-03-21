// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeArm extends SubsystemBase {
  PWMVictorSPX intakeArm;
  DigitalInput altSwitch = new DigitalInput(2);
  DigitalInput ustlimitSwitch = new DigitalInput(3);
  Counter counterust = new Counter(ustlimitSwitch);
  Counter counteralt = new Counter(altSwitch);
  /** Creates a new IntakeArm. */
  public IntakeArm() {
    intakeArm = new PWMVictorSPX(Constants.INTAKE_BACK);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public boolean isSwtichSetUst(){
    return counterust.get() > 0;
  }
  public boolean isSwtichSetAlt(){
    return counteralt.get() > 0;
  }
  public void counterResetUst(){
    counterust.reset();
  }
  public void counterResetAlt(){
    counteralt.reset();
  }
  public void intakeArmPosition(double speed){
    intakeArm.set(speed);
  }
  public void stop(){
    intakeArm.set(0);
  }

  public boolean switchUp(){
    return ustlimitSwitch.get();
  }
  public boolean switchDown(){
    return altSwitch.get();
  }
}
