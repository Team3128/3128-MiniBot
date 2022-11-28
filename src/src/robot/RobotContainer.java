/*
 *	  Copyright (C) 2022  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */


package robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import robot.commands.ArcadeDriveCommand;
import robot.commands.TestBallCounterCommand;
import robot.commands.TestDriveCommand;
import robot.commands.TestFeederCommand;
import robot.commands.TestNavigatorCommand;
//import robot.commands.TestLightCommand;
import robot.commands.TestLimitSwitchesCommand;
import robot.commands.TestShooterCommand;
import robot.commands.TestTurntableCommand;
import robot.subsystems.DriveSubsystem;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;
import robot.subsystems.TurntableSubsystem;
import robotCore.Joystick;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick m_joystick = new Joystick(0);
  private final JoystickButton m_button1 = new JoystickButton(m_joystick, 1);
  private final JoystickButton m_button2 = new JoystickButton(m_joystick, 2);
  private final JoystickButton m_button3 = new JoystickButton(m_joystick, 3);
  private final JoystickButton m_button4 = new JoystickButton(m_joystick, 4);
  private final JoystickButton m_button5 = new JoystickButton(m_joystick, 5);
  //private final JoystickButton m_button6 = new JoystickButton(m_joystick, 6);
  private final JoystickButton m_button7 = new JoystickButton(m_joystick, 7);
  private final JoystickButton m_button8 = new JoystickButton(m_joystick, 8);

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final FeederSubsystem m_feederSubsystem = new FeederSubsystem();
  private final TurntableSubsystem m_turntableSubsystem = new TurntableSubsystem();
  //private final Camera m_camera = new Camera();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(m_driveSubsystem, m_joystick));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_button1.whenPressed(new TestDriveCommand(m_driveSubsystem));
    m_button2.whileHeld(new TestShooterCommand(m_shooterSubsystem));
    m_button3.whileHeld(new TestFeederCommand(m_feederSubsystem));
    m_button4.whileHeld(new TestTurntableCommand(m_turntableSubsystem));
    m_button5.toggleWhenPressed(new TestLimitSwitchesCommand());
    //m_button6.whileHeld(new TestLightCommand(m_camera));
    m_button7.toggleWhenPressed(new TestBallCounterCommand());
    m_button8.toggleWhenPressed(new TestNavigatorCommand(m_driveSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
