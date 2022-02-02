// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Set;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase implements Command {
  // Init Motors
  private final CANSparkMax frontLeft = new CANSparkMax(Constants.FL_DRIVE_MOTOR, MotorType.kBrushless);
  private final CANSparkMax backLeft = new CANSparkMax(Constants.BL_DRIVE_MOTOR, MotorType.kBrushless);

  private final CANSparkMax frontRight = new CANSparkMax(Constants.FR_DRIVE_MOTOR, MotorType.kBrushless);
  private final CANSparkMax backRight = new CANSparkMax(Constants.BR_DRIVE_MOTOR, MotorType.kBrushless);

  frontLeft.follow(backLeft);
  // public DriveTrain() {}
  // @Override
  // public void periodic() {
  //   // This method will be called once per scheduler run
  // }

  public void initDefaultCommand() {
    setDefaultCommand(new DriveTrain());
  }
  public void setLeftMotors(double speed) {
    frontLeft.set(-speed);
    backLeft.set(-speed);

  }
  public void setRightMotors(double speed) {
    frontRight.set(speed);
    backRight.set(speed);

  }
  @Override
  public Set<Subsystem> getRequirements() {
    // TODO Auto-generated method stub
    return null;
  }

}