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
import robotCore.Device;
import robotCore.DigitalInput;
import robotCore.Logger;
import robotCore.RobotBase;

/**
 *
 */
public class TestLimitSwitchesCommand extends CommandBase {
	private static final int k_leftLimitPin = Device.IO_4;
    private static final int k_rightLimitPin = Device.IO_3;
    
    private final DigitalInput m_leftLimit = new DigitalInput(k_leftLimitPin);
    private final DigitalInput m_rightLimit = new DigitalInput(k_rightLimitPin);

    public TestLimitSwitchesCommand() {
        Logger.log("TestLimitSwitchesCommand", 3, "TestLimitSwitchesCommand()");
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        Logger.log("TestLimitSwitchesCommand", 2, "initialize()");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        Logger.log("TestLimitSwitchesCommand", -1, "execute()");

        Logger.log("TestLimitSwitchesCommand", 1, String.format("left = %b, right = %b", m_leftLimit.get(), m_rightLimit.get()));
        RobotBase.sleep(100);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        Logger.log("TestLimitSwitchesCommand", -1, "isFinished()");

        return (false);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Logger.log("TestLimitSwitchesCommand", 2, "end()");
    }
}
