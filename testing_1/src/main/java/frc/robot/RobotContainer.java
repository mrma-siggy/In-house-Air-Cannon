/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystemPID;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //The robot's subsystems are defined here.
  private static final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private static final PIDCommand m_driveDistanceCommand = new PIDCommand(new PIDController(Constants.PIDConstants.DriveSubsystem1.kP, Constants.PIDConstants.DriveSubsystem1.kI, Constants.PIDConstants.DriveSubsystem1.kD), m_driveSubsystem::getDistanceDriven, 10, output -> m_driveSubsystem.drive(output, 0, 1), m_driveSubsystem);
  private static final DriveSubsystemPID m_driveSubsystemPID = new DriveSubsystemPID();
  private static final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private static final FeederSubsystem m_feederSubsystem = new FeederSubsystem();
  private static final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  //The robot's joystick(s) and controller(s) are defined here.
  public static final Joystick m_stick = new Joystick(Constants.OIConstants.kStickPort);
  public static final XboxController m_controller = new XboxController(Constants.OIConstants.kControllerPort);

  //Create the button bindings here.
  JoystickButton m_controllerA = new JoystickButton(m_controller, XboxController.Button.kA.value);
  JoystickButton m_controllerB = new JoystickButton(m_controller, XboxController.Button.kB.value);
  Trigger m_controllerRT = new Trigger(() -> m_controller.getTriggerAxis(GenericHID.Hand.kRight) > 0.9);
  JoystickButton m_joystick1 = new JoystickButton(m_stick, Joystick.ButtonType.kTrigger.value);
  JoystickButton m_joystick3 = new JoystickButton(m_stick, 3);
  JoystickButton m_joystick4 = new JoystickButton(m_stick, 4);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //Set the default commands here. Configure the button bindings here.
    //m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, () -> -m_stick.getY(), () -> m_stick.getX(), () -> m_stick.getThrottle()));
    //TODO If the RunCommand below works, then delete the DriveCommand.
    m_driveSubsystem.setDefaultCommand(new RunCommand(() -> m_driveSubsystem.drive(-m_stick.getY(), m_stick.getX(), m_stick.getThrottle())));
  
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Configure the button bindings here.
    m_controllerA.whenPressed(m_intakeSubsystem::intakeRunStop);
    m_controllerRT.whenActive(m_intakeSubsystem::intakeDownUp);

    //TODO test the feeder
    //m_joystick3.whenPressed(new InstantCommand(m_feederSubsystem::feederUp/*, m_feederSubsystem*/)).whenReleased(m_feederSubsystem::feederStop);
    //m_joystick4.whenPressed(new InstantCommand(m_feederSubsystem::feederDown/*, m_feederSubsystem*/)).whenReleased(m_feederSubsystem::feederStop);
    m_joystick3.whenHeld(new StartEndCommand(m_feederSubsystem::feederUp, m_feederSubsystem::feederStop, m_feederSubsystem));
    m_joystick4.whenHeld(new StartEndCommand(m_feederSubsystem::feederDown, m_feederSubsystem::feederStop, m_feederSubsystem));
    m_joystick1.whenPressed(m_feederSubsystem::feederStopperUpDown);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_driveDistanceCommand;
  }
}
