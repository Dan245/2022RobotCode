// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Driving extends CommandBase {
  /** Creates a new Driving. */
  public Driving() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = RobotContainer.getDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = RobotContainer.getDriverRawAxis(Constants.RIGHT_STICK_Y);

    RobotContainer.m_driveTrain.setLeftMotors(leftStickY);
    RobotContainer.m_driveTrain.setRightMotors(rightStickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if (interrupted){
    RobotContainer.m_driveTrain.setRightMotors(0);
    RobotContainer.m_driveTrain.setLeftMotors(0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void interrupted() {
    this.end(true);
  }
}
