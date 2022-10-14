// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.TurretConstants.*;

/** An example command that uses an example subsystem. */
public class TurnTurretFromJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Turret m_turret;
  private double twist;
  private double angle;
  private double currentAng;

  /**
   * Creates a new turn turret Command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnTurretFromJoystick(double JoystickTwist) {
    m_turret = Turret.getInstance();
    twist = JoystickTwist;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    currentAng = m_turret.getEncoder();
    angle = currentAng + twist * k_twistToDegree;
    m_turret.startPID(angle);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
