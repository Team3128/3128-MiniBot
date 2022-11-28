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

package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.DriveSubsystem;
import robotCore.Encoder;
import robotCore.Logger;
import robotCore.RobotBase;
import robotCore.Timer;

/**
 *
 */
public class TestDriveCommand extends CommandBase {
    private final DriveSubsystem m_subsystem;
    private Encoder m_leftEncoder;
    private Encoder m_rightEncoder;
    private Timer m_timer = new Timer();

    enum State
    {
        Left,
        Right,
        End
    }

    private State m_state;

    public TestDriveCommand(DriveSubsystem subsystem) {
        Logger.log("TestDriveCommand", 3, "TestDriveCommand()");

        m_subsystem = subsystem;
        m_leftEncoder = subsystem.GetLeftEncoder();
        m_rightEncoder = subsystem.GetRightEncoder();

        // Use requires() here to declare subsystem dependencies
        addRequirements(m_subsystem);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();

        m_state = State.Left;
        m_timer.reset();

        m_subsystem.setPower(0.5, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        Logger.log("TestDriveCommand", -1, "execute()");
        Logger.log("TestDriveCommand", 1, String.format("Left = %d,Right = %d", m_leftEncoder.getSpeed(), m_rightEncoder.getSpeed()));

        if (m_timer.get() >= 2)
        {
            if (m_state == State.Left)
            {
                m_subsystem.setPower(0, 0.5);
                m_state = State.Right;
                m_timer.reset();
            }
            else
            {
                m_state = State.End;
            }
        }

        RobotBase.sleep(100);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        Logger.log("TestDriveCommand", -1, "isFinished()");

        return (m_state == State.End);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Logger.log("TestDriveCommand", 2, "end()");

        m_subsystem.setPower(0, 0);
    }
}
