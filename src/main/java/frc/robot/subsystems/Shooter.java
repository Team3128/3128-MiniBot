// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import static frc.robot.Constants.ShooterConstants.*;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;

public class Shooter extends PIDSubsystem {

  public static Shooter instance;

  private PWM m_shooterMotor = new PWM(k_shooterMotorID);

  private Encoder m_shooterEncoder = new Encoder(k_shooterEncoderPin1, k_shooterEncoderPin2);

  private int plateauCount = 0;

  public Shooter() {
    super(new PIDController(kP, kI, kD));

    convertEncoderUnit();

  }

  public static synchronized Shooter getInstance() {
    if (instance == null) {
      instance = new Shooter();
    }
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.periodic();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    super.simulationPeriodic();
  }

  //uses the voltage output from PID and add a feed forward value
  @Override
  protected void useOutput(double output, double setpoint) {
    double ff = kF * setpoint;
    double voltageOutput = output + ff;

    if (getController().atSetpoint() && (setpoint != 0)) {
      plateauCount ++;
    } else {
      plateauCount = 0;
    }

    if (setpoint == 0) voltageOutput = 0;

    m_shooterMotor.setSpeed(MathUtil.clamp(voltageOutput / 7.2, -1, 1));
    //this line needs testing
  }

  //get current RPM
  @Override
  protected double getMeasurement() {
    return m_shooterEncoder.getRate() * 60;
    //rotation per second to RPM
  }
  
  //Begins the PID loop to reach setpoint RPM
  public void beginShoot(double rpm) {  
    setSetpoint(rpm);
    getController().setTolerance(k_rpmTolerancePercent * rpm);
  }

  //stop the shooter from shooting by setting setpoint to 0
  public void stopShoot() {
    plateauCount = 0;
    setSetpoint(0);
  }

  //checks if shooter is ready to shoot through plateau count
  public boolean isReady() {
    return (plateauCount >= k_plateauCount) && (getSetpoint() != 0);
  }

  //resets plateau count
  public void resetPlateauCount() {
    plateauCount = 0;
  }

  public void convertEncoderUnit() {
    m_shooterEncoder.setDistancePerPulse((1 / k_TTMotorPulsePerRotation));
  }

  public int getEncoder() {
    return m_shooterEncoder.get();
  }

  public void resetEncoder() {
    m_shooterEncoder.reset();
  }
}
