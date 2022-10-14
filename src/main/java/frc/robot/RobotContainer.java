// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.DriveForDistanceCommand;
import frc.robot.commands.DriveForTimeCommand;
import frc.robot.commands.TestMotorSpeedCommand;
import frc.robot.commands.RunFeederAndShoot;
import frc.robot.commands.RunFeeder;
import frc.robot.commands.TurnTurret;
import frc.robot.commands.TurnTurretFromJoystick;
import frc.robot.common.hardware.input.NAR_Joystick;
import frc.robot.common.hardware.input.NAR_XboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain(); 
  private final Turret m_turret = new Turret();
  private final NAR_Joystick m_rightStick = new NAR_Joystick(0); 
  private final NAR_Joystick m_leftStick = new NAR_Joystick(1);

  private CommandScheduler m_commandScheduler = CommandScheduler.getInstance(); 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings


    m_commandScheduler.setDefaultCommand(m_drivetrain, new ArcadeDriveCommand(m_drivetrain, m_rightStick));
    configureButtonBindings();

    // m_commandScheduler.setDefaultCommand(m_turret, new TurnTurretManual(m_leftStick));
    // configureButtonBindings();
  }


  private void configureButtonBindings() {
    m_rightStick.getButton(1).whenHeld(new RunFeederAndShoot(0));
    m_rightStick.getButton(2).whenPressed(new DriveForDistanceCommand(m_drivetrain, 0.75, 3000)); //-/+1.0, seconds
    m_rightStick.getButton(3).whenPressed(new TestMotorSpeedCommand(m_drivetrain));
    m_rightStick.getButton(4).whenPressed(new DriveForTimeCommand(m_drivetrain, 0.75, 3.0)); //-/+1.0, seconds
    m_rightStick.getButton(5).whenPressed(() -> m_turret.resetAngle()); // Set turret angle to default(0)
    m_rightStick.getButton(6).whenHeld(new RunFeeder());
    // m_leftStick.ifTwisted().whenActive(new TurnTurret(getTwist)); TODO make twist relate to turrent motion
    
  }

}
