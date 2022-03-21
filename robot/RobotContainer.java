// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbStop;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.IntakeArmStop;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeReverse;
import frc.robot.commands.IntakeRun;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.LimelightDistance;
import frc.robot.commands.LimelightTarget;
import frc.robot.commands.Otonom;
import frc.robot.commands.ShootBall;
import frc.robot.commands.StorageFull;
import frc.robot.commands.StorageReverse;
import frc.robot.commands.StorageStop;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
// The robot's subsystems and commands are defined here...

  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  public static Joystick driverJoystick;

  public final Otonom otonom;

  private final Shooter shooter;
  private final ShootBall shootBall;

  private final Intake intake;
  private final IntakeRun intakeRun;
  private final IntakeStop intakeStop;
  private final IntakeReverse intakeReverse;

  private final Climb climb;
  private final ClimbDown climbDown;
  private final ClimbUp climbUp;
  private final ClimbStop climbStop;

  private final Storage storage;
  private final StorageFull storageFull;
  private final StorageStop storageStop;
  private final StorageReverse storageReverse;

  private final IntakeArm intakeArm;
  private final IntakeUp intakeUp;
  private final IntakeDown intakeDown;
  private final IntakeArmStop intakeArmStop;

  private final Limelight limelight;
  private final LimelightDistance limelightDistance;
  private final LimelightTarget limelightTarget;
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    CameraServer.startAutomaticCapture();
    // Configure the button bindings
    driveTrain=new DriveTrain();
    driveWithJoysticks=new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);

    driveForwardTimed= new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);

    driverJoystick=new Joystick(Constants.JOYSTICK_NUMBER);

    //shooter Tanımları
    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);

    //intake Tanımları
    intake = new Intake();
    intakeRun = new IntakeRun(intake);
    intakeRun.addRequirements(intake);
    intakeStop = new IntakeStop(intake);
    intakeStop.addRequirements(intake);
    intakeReverse = new IntakeReverse(intake);
    intakeReverse.addRequirements(intake);

    //Climb Tanımları
    climb = new Climb();
    climbDown = new ClimbDown(climb);
    climbDown.addRequirements(climb);
    climbUp = new ClimbUp(climb);
    climbUp.addRequirements(climb);
    climbStop = new ClimbStop(climb);
    climbStop.addRequirements(climb);

    // Storage Tanımları
    storage = new Storage();
    storageFull = new StorageFull(storage);
    storageFull.addRequirements(storage);
    storageStop = new StorageStop(storage);
    storageStop.addRequirements(storage);
    storageReverse = new StorageReverse(storage);
    storageReverse.addRequirements(storage);

    //Intake Arm Tanımları
    intakeArm = new IntakeArm();
    intakeUp = new IntakeUp(intakeArm);
    intakeUp.addRequirements(intakeArm);
    intakeDown = new IntakeDown(intakeArm);
    intakeDown.addRequirements(intakeArm);
    intakeArmStop = new IntakeArmStop(intakeArm);
    intakeArmStop.addRequirements(intakeArm);

    limelight = new Limelight();
    limelightDistance = new LimelightDistance(limelight);
    limelightDistance.addRequirements(limelight);
    limelightTarget = new LimelightTarget(limelight);
    limelightTarget.addRequirements(limelight);

    otonom = new Otonom(driveTrain, shooter, storage, intake, limelight, intakeArm);
    otonom.addRequirements(driveTrain, shooter, storage);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //shooter butonları
    JoystickButton shootButton = new JoystickButton(driverJoystick, Constants.SHOOT_BUTTON);
    shootButton.whileHeld(new LimelightDistance(limelight));
    shootButton.whileHeld(new ShootBall(shooter));
    JoystickButton targetButton = new JoystickButton(driverJoystick, Constants.TARGET_BUTTON);
    targetButton.whileHeld(new LimelightTarget(limelight));

    //intake merdane butonları
    JoystickButton intakeButton = new JoystickButton(driverJoystick, Constants.INTAKE_BUTTON);
    intakeButton.whenPressed(new IntakeRun(intake));
    intakeButton.whenReleased(new IntakeStop(intake));

    //intake ters merdane butonları
    JoystickButton intakeReverseButton = new JoystickButton(driverJoystick, Constants.INTAKE_REVERSE_BUTTON);
    intakeReverseButton.whenPressed(new IntakeReverse(intake));
    intakeReverseButton.whenReleased(new IntakeStop(intake));

    //tırmanma aşağı butonları
    JoystickButton climbDownButton = new JoystickButton(driverJoystick, Constants.CLIMB_DOWN_BUTTON);
    climbDownButton.whenPressed(new ClimbDown(climb));
    climbDownButton.whenReleased(new ClimbStop(climb));

    //tırmanma yukarı butonları
    JoystickButton climbUpButton = new JoystickButton(driverJoystick, Constants.CLIMB_UP_BUTTON);
    climbUpButton.whenPressed(new ClimbUp(climb));
    climbUpButton.whenReleased(new ClimbStop(climb));

    //storage butonları
    JoystickButton storageFullButton = new JoystickButton(driverJoystick, Constants.STORAGE_FULL_BUTTON);
    storageFullButton.whileHeld(new StorageFull(storage));
    storageFullButton.whenReleased(new StorageStop(storage));
    
    //storage Reverse
    JoystickButton storageReverseButton = new JoystickButton(driverJoystick, Constants.STORAGE_REVERSE_BUTTON);
    storageReverseButton.whileHeld(new StorageReverse(storage));
    storageReverseButton.whenReleased(new StorageStop(storage));

    //intake kol yukarı butonları
    JoystickButton intakeUpButton = new JoystickButton(driverJoystick, Constants.INTAKE_ARM_UP);
    intakeUpButton.whenPressed(new IntakeUp(intakeArm));
    //intakeUpButton.whenReleased(new IntakeArmStop(intakeArm));

    //intake kol aşağı butonları
    JoystickButton intakeDownButton = new JoystickButton(driverJoystick, Constants.INTAKE_ARM_DOWN);
    intakeDownButton.whenPressed(new IntakeDown(intakeArm));
    //intakeDownButton.whenReleased(new IntakeArmStop(intakeArm));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return otonom;
    // An ExampleCommand will run in autonomous
  }
}
