// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.commands.KeepElevatorInPlace;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    public final SpeedControllerGroup elevatorWheels = Robot.m_robotMap.elevatorWheels;
    public final WPI_TalonSRX firstMotor = Robot.m_robotMap.elevatorFirstMotor;
    public final WPI_VictorSPX secondMotor = Robot.m_robotMap.elevatorSecondMotor;
    public final WPI_VictorSPX thirdMotor = Robot.m_robotMap.elevatorThirdMotor;
    public final WPI_VictorSPX fourthMotor = Robot.m_robotMap.elevatorFourthMotor;
    public final PIDController pidController = Robot.m_robotMap.elevatorPIDController;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new KeepElevatorInPlace());
    }

    public void setSpeed(double speed) {
    	//if (firstMotor.getSensorCollection().isFwdLimitSwitchClosed() && speed < 0) {
//    	elevatorWheels.set(0);
//    	}	
//    	else if (firstMotor.getSensorCollection().isRevLimitSwitchClosed() & speed > 0) {
    		firstMotor.set(speed);
    		secondMotor.follow(firstMotor);
    		thirdMotor.follow(firstMotor);
    		fourthMotor.follow(firstMotor);
//    	else {
    	
//    	}
//    	firstMotor.set(speed);
//    	secondMotor.set(speed);
//    	thirdMotor.set(speed);
//    	fourthMotor.set(speed);
    }
    
    public void stop() {
    	elevatorWheels.set(0);
    }
    
    public void setSetpoint(double setpoint) {
    	pidController.setSetpoint(setpoint);
    }
    
    public void enablePIDController() {
    	pidController.enable();
    }
    
    public void disablePIDController() {
    	pidController.disable();
    }
    
    public void setOutputRange() {
    	pidController.setOutputRange(0, 0.7);
    }
    
    public boolean isOnPoint() {
    	return pidController.onTarget();
    }
}
