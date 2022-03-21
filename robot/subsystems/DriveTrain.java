// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveTrain extends SubsystemBase {
  // DriveTrain subsytem için motor değişkenleri tanımlamaları
  CANSparkMax leftFront;             //sol ön motor 
  CANSparkMax rightFront;            //sol arka motor
  CANSparkMax leftBack;              //sağ ön motor
  CANSparkMax rightBack;             //sağ arka motor  
  MotorControllerGroup leftMotors;    //sol motorlar gruplandı
  MotorControllerGroup rightMotors;   //sağ motorlar gruplandı
  static DifferentialDrive drive;            //diferansiyel sürüş için değişken tanımlaması yapıldı

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront= new CANSparkMax(Constants.LEFT_FRONT, MotorType.kBrushed);    //sol ön motor can bağlantısı tanımlanıyor
    leftFront.setInverted(false);
    rightFront= new CANSparkMax(Constants.RIGHT_FRONT, MotorType.kBrushed);  //sağ ön motor can bağlantısı tanımlanıyor
    rightFront.setInverted(true);
    leftBack=new CANSparkMax(Constants.LEFT_BACK, MotorType.kBrushed);       //sol arka motor can bağlantısı tanımlanıyor
    leftBack.setInverted(false);
    rightBack=new CANSparkMax(Constants.RIGHT_BACK, MotorType.kBrushed);     //sağ arka motor can bağlantısı tanımlanıyor
    rightBack.setInverted(true);

    leftMotors=new MotorControllerGroup(leftFront, leftBack);     //sol motor grubunun tanımlaması yapılıyor
    rightMotors=new MotorControllerGroup(rightFront, rightBack);  //sağ motor grubunun tanımlaması yapılıyor    

    drive=new DifferentialDrive(leftMotors, rightMotors);   

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void driveWithJoysticks(Joystick controller,double speed)
  {
    drive.arcadeDrive(controller.getY(),controller.getX()*(-1)/(1.3));
  }
  
  public void driveForward(double speed)
  {
    drive.tankDrive(speed,speed);

  }
  public static void targeting(double ls, double rs)
  {
    drive.tankDrive(ls, rs);
  }
  public void stop()
  {
    drive.stopMotor();
  }
}
