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

package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.DriveSubsystem;
import robotCore.Logger;
import robotCore.Navigator;
import robotCore.RobotBase;

/**
 *
 */
public class TestNavigatorCommand extends CommandBase {
    private Navigator m_navigator = null;
    private final DriveSubsystem m_subsystem;

    public TestNavigatorCommand(DriveSubsystem subsystem) {
        Logger.log("TestGyroCommand", 3, "TestGyroCommand()");

        m_subsystem = subsystem;
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        Logger.log("TestGyroCommand", 2, "initialize()");

        if (m_navigator == null)
        {
            m_navigator = new Navigator(m_subsystem.GetLeftEncoder(), m_subsystem.GetRightEncoder());
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        Logger.log("TestGyroCommand", -1, "execute()");

        Logger.log("TestGyroCommand", 1, String.format("Yaw = %f", m_navigator.getYaw()));

        RobotBase.sleep(100);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        Logger.log("TestGyroCommand", -1, "isFinished()");

        return (false);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Logger.log("TestGyroCommand", 2, "end()");
    }
}
