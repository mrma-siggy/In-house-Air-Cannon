/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

  //Create an instance of the subsystem and require it here.
  private final DriveSubsystem m_driveSubsystem;
  public DriveCommand(DriveSubsystem driveSubsystem) {
    m_driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }
  
  //Define variables for the class here.
  private static double scale;
  private static double speed;
  private static double rotation;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    scale = -0.13 * RobotContainer.m_stick.getThrottle() + 0.67;
    speed = -RobotContainer.m_stick.getY() * scale;
    rotation = RobotContainer.m_stick.getX() * scale;

    m_driveSubsystem.drive(speed, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
