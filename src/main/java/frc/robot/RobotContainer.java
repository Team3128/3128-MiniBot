// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.DriveForDistanceCommand;
import frc.robot.commands.DriveForTimeCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TestMotorSpeedCommand;
import frc.robot.commands.RunFeederAndShoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
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
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drivetrain m_drivetrain = new Drivetrain(); 
  private final Joystick m_joystick = new Joystick(0); 
  private final JoystickButton m_button1 = new JoystickButton(m_joystick, 1); 
  private final JoystickButton m_button2 = new JoystickButton(m_joystick, 2); 
  private final JoystickButton m_button3 = new JoystickButton(m_joystick, 3); 
  private final JoystickButton m_button4 = new JoystickButton(m_joystick, 4); 
  private final ExampleCommand m_autoCommand = null;
  private CommandScheduler m_commandScheduler = CommandScheduler.getInstance(); 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    m_commandScheduler.setDefaultCommand(m_drivetrain, new ArcadeDriveCommand(m_drivetrain, m_joystick));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * @param m_joystick 
   */
  private void configureButtonBindings() {
    m_button1.whenPressed(new DriveForTimeCommand(m_drivetrain, 0.75, 3.0)); //-/+1.0, seconds
    m_button2.whenPressed(new DriveForDistanceCommand(m_drivetrain, 0.75, 3000)); //-/+1.0, seconds
    m_button3.whenPressed(new TestMotorSpeedCommand(m_drivetrain));
    m_button4.whenPressed(new RunFeederAndShoot(0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
