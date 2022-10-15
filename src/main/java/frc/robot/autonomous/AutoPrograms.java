package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.RunFeederAndShoot;
import static frc.robot.Constants.ShooterConstants.*;
import frc.robot.subsystems.*;
 
public class AutoPrograms {
    private Drivetrain drive;
    private Feeder feed;
    private Shooter shoot;

    public AutoPrograms() {
        drive = Drivetrain.getInstance();
        feed = Feeder.getInstance();
        shoot = Shooter.getInstance();

    }

    public Command getAutonomousCommand() {
        String autoName = "ShootFor10sec";
 
        // if (autoName == null) {
        //     return null;
        // }
        // probably need this after adding some kind of input
 
        Command autoCommand = null;
 
        switch(autoName) {
            case "ShootFor10sec":
                autoCommand = new RunFeederAndShoot(k_shooterRPM).withTimeout(10);
                break;
            case "auto2":
                break;
            default:
                break;
        }
 
        return autoCommand;
    }
}

