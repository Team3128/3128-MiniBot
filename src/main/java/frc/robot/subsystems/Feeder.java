// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import static frc.robot.Constants.FeederConstants.*;

public class Feeder extends SubsystemBase {
  public static Feeder instance;

  private PWM m_motor = new PWM(k_feederMotorPWMPin);

  private Encoder m_encoder = new Encoder(k_feederEncoderPin1, k_feederEncoderPin2);

  /** Creates a new ExampleSubsystem. */
  public Feeder() {}

  public static synchronized Feeder getInstance() {
    if (instance == null) {
      instance = new Feeder();
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

  public void beginFeed() {
    m_motor.setSpeed(k_feederRPM);
  }

  public void stopFeed() {
    m_motor.setSpeed(0);
  }

  public int getEncoder() {
    return(m_encoder.get());
  }

  public void resetEncoder() {
    m_encoder.reset();
  }
}
