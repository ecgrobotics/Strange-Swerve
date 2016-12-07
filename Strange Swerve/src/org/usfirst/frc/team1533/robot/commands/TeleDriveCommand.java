package org.usfirst.frc.team1533.robot.commands;

public class TeleDriveCommand extends CommandBase {
	
	public TeleDriveCommand() {
		requires(swerve);
	}
	
	protected void initialize() {}

	protected void execute() {
		swerve.driveRobotOriented(joy1.getX(), -joy1.getY(), joy1.getZ());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}

	protected void interrupted() {}

}
