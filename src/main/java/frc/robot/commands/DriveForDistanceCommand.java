// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.PWM;

/** An example command that uses an example subsystem. */
public class DriveForDistanceCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain; 
  private double m_speed; 
  private double m_distance; 
  private int m_leftEncoder; 

  /**
   * Creates a new DriveForDistanceCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForDistanceCommand(Drivetrain drivetrain, double speed, double distance) {
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_distance = distance; 
    m_leftEncoder = drivetrain.getLeftEncoder(); 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.setSpeed(m_speed,m_speed); 
    m_leftEncoder = 0; 
  }

  // Called every Distance the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stop
    m_drivetrain.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return(m_leftEncoder >= m_distance); 
  }
}
