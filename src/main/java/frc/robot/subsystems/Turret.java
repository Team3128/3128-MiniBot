// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
import static frc.robot.Constants.TurretConstants.*;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;

public class Turret extends PIDSubsystem {

    public static Turret instance;

    private PWM m_turretMotor = new PWM(k_turretMotorPWMPin);

    private Encoder m_turretEncoder = new Encoder(k_turretEncoderPin1, k_turretEncoderPin2);

    public Turret() {
      super(new PIDController(kP, kI, kD));
      
      convertEncoderUnit();
      zeroEncoder();
    }

    public static synchronized Turret getInstance() {
      if (instance == null) {
        instance = new Turret();
      }
      return instance;
    }

    public void startPID(double angle) {
      super.setSetpoint(angle);
      getController().setTolerance(k_turretTolerance);

    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      super.periodic();
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
      super.periodic();
    }

    @Override
    protected void useOutput(double output, double setpoint) {
      // we shouldn't need a FF...

      m_turretMotor.setSpeed(MathUtil.clamp(output / 7.2, -1, 1));
        
    }

    @Override
    protected double getMeasurement() {
        return m_turretEncoder.get();
        //get count of encoder
    }

    public double getEncoder() {
      return m_turretEncoder.getDistance();
    }

    // Set the encoder to 0 (corresponding to front?)
    public void zeroEncoder() {
      m_turretEncoder.reset();
    }

    // Set turret angle to default(0)
    public void resetAngle() {
      startPID(k_turretDefaultAngle);
    }

    public void convertEncoderUnit() {
      m_turretEncoder.setDistancePerPulse((360 / k_TTMotorPulsePerRotation));
      //setting each count of encoder to equivalent amount of degree
    }
  
  }