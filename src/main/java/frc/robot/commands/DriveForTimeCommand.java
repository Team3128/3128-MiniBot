// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.PWM;

/** An example command that uses an example subsystem. */
public class DriveForTimeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain; 
  private Timer m_timer = new Timer(); 
  private double m_speed; 
  private double m_time; 

  /**
   * Creates a new DriveForTimeCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForTimeCommand(Drivetrain drivetrain, double speed, double time) {
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_time = time; 
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.setSpeed(m_speed,m_speed); 
    m_timer.reset(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
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
    return (m_timer.get() >= m_time);
  }
}
