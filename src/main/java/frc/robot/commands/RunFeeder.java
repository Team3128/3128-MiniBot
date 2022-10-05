// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class RunFeeder extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Feeder m_feeder;
  private Timer m_timer = new Timer();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunFeeder() {
    m_feeder = Feeder.getInstance();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_feeder.beginFeed();
    m_timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  //check if the feeder if getting jammed
  //if jammed, reverse the feeder for a short amount of time and run normally again
  @Override
  public void execute() {
    if (m_feeder.getEncoderRate() > 0) {//if moving fowardss
      if (m_feeder.getEncoderRate() * 60 > 0) {//slowest normal speed in RPM
        m_timer.reset();
      } else if (m_timer.get() > 3) {//greatest stall time allowed
        m_feeder.beginReverseFeed();
        m_timer.reset();
      } else {
        if (m_timer.get() > 1) {//time we want the feeder to reverse
          m_feeder.beginFeed();
          m_timer.reset();
        }
      }
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_feeder.stopFeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
