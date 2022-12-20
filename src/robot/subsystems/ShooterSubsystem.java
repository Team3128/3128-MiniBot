/*
 *	  Copyright (C) 2016  John H. Gaby
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
import robotCore.Encoder.EncoderType;
import robotCore.SmartMotor.SmartMotorMode;
import robotCore.Logger;
import robotCore.PWMMotor;

/**
 *
 */
public class ShooterSubsystem extends SubsystemBase {
    private static final int k_PWMPin = Device.M2_2_PWM;
    private static final int k_DirPin = Device.M2_2_DIR;

    private static final int k_encoderPin1 = Device.Q5_INT;
    private static final int k_encoderPin2 = -1;

    private PWMMotor m_motor = new PWMMotor(k_PWMPin, k_DirPin);
    public Encoder m_encoder = new Encoder(EncoderType.Quadrature, k_encoderPin1, k_encoderPin2);

    public ShooterSubsystem() {
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        Logger.log("ShooterSubsystem", -1, "periodic()");
    }

    public void setSpeed(double speed) {
        m_motor.setControlMode(SmartMotorMode.Speed);

        m_motor.set(speed);
    }

    public void setPower(double power) {
        m_motor.setControlMode(SmartMotorMode.Power);

        m_motor.set(power);
    }

    public Encoder getEncoder() {
        return (m_encoder.clone());
    }
}
