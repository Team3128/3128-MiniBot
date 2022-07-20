// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import static frc.robot.Constants.WiringConstants.*;
import static frc.robot.Constants.UtilityConstants.*;
import static frc.robot.Constants.PIDConstants.*;
import edu.wpi.first.math.controller.PIDController;

public class Shooter extends SubsystemBase {

  public static Shooter instance;

  private PWM m_shooterMotor = new PWM(k_shooterMotorID);

  private Encoder m_shooterEncoder = new Encoder(k_shooterEncoderPin1, k_shooterEncoderPin2);

  private PIDController pid = new PIDController(kP, kI, kD);  

  public Shooter() {}

  public static synchronized Shooter getInstance() {
    if (instance == null) {
      instance = new Shooter();
    }
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
  public void beginShoot(double setpoint) {  
    double shooterPID = pid.calculate(m_shooterEncoder.getRate(), setpoint);
  }

  public void setEncoderDistancePerPulse() {
    m_shooterEncoder.setDistancePerPulse(60 * (1/k_TTMotorPulsePerRotation));
    //converting "unit per second" to RPM
  }

  public int getEncoder() {
    return m_shooterEncoder.get();
  }

  public double getRPM() {
    return m_shooterEncoder.getRate();
    //need to transfer units per second to RPM, not sure about units
  }

  public void resetEncoder() {
    m_shooterEncoder.reset();
  }
}
