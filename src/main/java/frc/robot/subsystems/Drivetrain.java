// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems; 

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import static frc.robot.Constants.DrivetrainConstants.*;
import edu.wpi.first.math.controller.PIDController;

public class Drivetrain extends SubsystemBase {

  public static Drivetrain instance;

  private PWM m_leftMotor = new PWM(k_leftMotorID);
  private PWM m_rightMotor = new PWM(k_rightMotorID);

  private Encoder m_leftEncoder = new Encoder(k_leftEncoderPin1, k_leftEncoderPin2);
  private Encoder m_rightEncoder = new Encoder(k_rightEncoderPin1, k_rightEncoderPin2, true);

  private PIDController pid = new PIDController(kP, kI, kD);  

  public Drivetrain() {
    // m_rightEncoder.setInverted(); //On website updated of 2022 but not sad
    //m_leftMotor.setFeedbackDevice(m_leftEncoder);
    //m_leftMotor.setMaxSpeed(k_maxSpeed); 
  }

  public static synchronized Drivetrain getInstance() {
    if (instance == null) {
      instance = new Drivetrain();
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

  public void setSpeed(double leftPower, double rightPower) {
    m_leftMotor.setSpeed(leftPower);
    m_rightMotor.setSpeed(rightPower);
  }

  public void setPIDSpeed(double setpoint){
    double leftMotorPID = pid.calculate(m_leftEncoder.getDistance(), setpoint); 
    double rightMotorPID = pid.calculate(m_rightEncoder.getDistance(), setpoint); 

    pid.setTolerance(k_posTolerance,k_vTolerance);
    pid.atSetpoint(); 
    pid.setIntegratorRange(k_minIntegral, k_maxIntegral);
  }

  public int getLeftEncoder(){
    return (m_leftEncoder.get());
  }

  public int getRightEncoder(){
    return (m_rightEncoder.get());
  }

  public void resetEncoders(){
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

}
