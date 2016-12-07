package org.usfirst.frc.team1533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public void robotInit() {
		
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
    public void autonomousInit() {

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
}
