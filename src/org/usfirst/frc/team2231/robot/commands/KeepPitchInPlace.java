package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class KeepPitchInPlace extends Command {

    public KeepPitchInPlace() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_elevatorPitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	Robot.m_elevatorPitch.setSpeed(-0.1);
    	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevatorPitch.setSpeed(-0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
