// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example drivetrain. */
public class TestMotorSpeedCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private double m_power; 
  private final int m_leftEncoder;
  private final int m_rightEncoder;

  /**
   * Creates a new TestMotorSpeedCommand.
   *
   * @param drivetrain The drivetrain used by this command.
   */
  public TestMotorSpeedCommand(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    m_leftEncoder = drivetrain.getLeftEncoder();
    m_rightEncoder = drivetrain.getRightEncoder();

    
    // Use addRequirements() here to declare drivetrain dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_power = 0; 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.setSpeed(m_power, m_power);
    m_power += 0.0025; 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_power > 1.3; 
  }
}
