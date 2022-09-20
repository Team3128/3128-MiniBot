// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;

public class RunFeederAndShoot extends SequentialCommandGroup{

    // run feeder and shooter at the same time
    public RunFeederAndShoot(double RPM) {
        addCommands(
            //if not working, probably should stop the feeder before shooter is at correct RPM
            parallel (
                new RunFeeder(Feeder.getInstance()),
                new CmdShootRPM(RPM)
            )
        );
    }
}
