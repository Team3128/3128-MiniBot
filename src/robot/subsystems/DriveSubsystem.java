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


package robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Device;
import robotCore.Encoder;
import robotCore.Logger;
import robotCore.PWMMotor;
import robotCore.Encoder.EncoderType;

public class DriveSubsystem extends SubsystemBase {

  //TODO move the pins to the Constants class
  //TODO don't forget to change name and import!
  public final static double  k_ticksPerFoot = 7059.2 / 5.85;

  private static final int k_leftMotorPWMPin = Device.M1_1_PWM;
  private static final int k_leftMotorDirPin = Device.M1_1_DIR;
  private static final int k_rightMotorPWMPin = Device.M1_2_PWM;
  private static final int k_rightMotorDirPin = Device.M1_2_DIR;
  private static final int k_leftEncoderIntPin = Device.Q1_INT;
  private static final int k_leftEncoderDirPin = Device.Q1_DIR;
  private static final int k_rightEncoderIntPin = Device.Q2_INT;
  private static final int k_rightEncoderDirPin = Device.Q2_DIR;
  
  //TODO create motor and encoder objects using PWMMotor.class and Encoder.class


  public DriveSubsystem() {
    Logger.log("DriveSubsystem", 3, "DriveSubsystem()");

    // TODO Invert the left motor encoder
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Logger.log("DriveSubsystem", -1, "periodic()");
  }

  // TODO create one method to set power to both motors

  // TODO creat two methods to get left and right encoders
}
