// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
PWMVictorSPX climb;
DigitalInput toplimitSwitch = new DigitalInput(0);
DigitalInput bottomlimitSwitch = new DigitalInput(1);

  /** Creates a new Climb. */
  public Climb() {
    climb = new PWMVictorSPX(Constants.CLIMB_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void climb(double speed){
    climb.set(speed);
  }
  public void stop(){
    climb.set(0);
  }
  public boolean switchUp(){
    return toplimitSwitch.get();
  }
  public boolean switchDown(){
    return bottomlimitSwitch.get();
  }
}
