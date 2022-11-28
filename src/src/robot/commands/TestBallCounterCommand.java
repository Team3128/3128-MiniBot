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
import robotCore.DigitalCounter;
import robotCore.Logger;
import robotCore.RobotBase;

/**
 *
 */
public class TestBallCounterCommand extends CommandBase {
    private final DigitalCounter m_ballCounter = new DigitalCounter(Device.IO_2);

    public TestBallCounterCommand() {
        Logger.log("TestBallCounterCommand", 3, "TestBallCounterCommand()");
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        Logger.log("TestBallCounterCommand", 2, "initialize()");
        m_ballCounter.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        Logger.log("TestBallCounterCommand", -1, "execute()");

        Logger.log("TestBallCounterCommand", 1, String.format("count = %d", m_ballCounter.get()));
        RobotBase.sleep(100);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        Logger.log("TestBallCounterCommand", -1, "isFinished()");

        return (false);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Logger.log("TestBallCounterCommand", 2, "end()");
    }
}
