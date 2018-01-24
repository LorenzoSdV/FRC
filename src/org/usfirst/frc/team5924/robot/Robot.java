package org.usfirst.frc.team5924.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Spark m_frontLeft = new Spark(0);
	Spark m_rearLeft = new Spark(1);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	Spark m_frontRight = new Spark(2);
	Spark m_rearRight = new Spark(3);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
	
	Joystick leftJoy = new Joystick(1);
	
	Timer timer = new Timer();
	
	Compressor c = new Compressor(0);
	
	Potentiometer pot = new AnalogPotentiometer(0, 3600, 30);
	/**10 revolutions of 360 degrees to extend to maximum length: 6 inches
	 * so 10 * 360 = 3600 degrees maximum rotation
	 */
	double potDegrees = pot.get();
	DoubleSolenoid mySol1 = new DoubleSolenoid(1, 2);
	DoubleSolenoid mySol2 = new DoubleSolenoid(0, 3);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 
	@Override
	public void robotInit() {
	}

	
	 //This function is run once each time the robot enters autonomous mode
	 
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	
	 //This function is called periodically during autonomous
	 
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 2.0) {
			m_drive.arcadeDrive(-0.5, 0.0); // drive forwards half speed
		} else {
			m_drive.arcadeDrive(0.0, 0.0); // stop robot
		}
	}

	
	 //This function is called once each time the robot enters tele-operated
	 //mode
	
	*/
	
	@Override
	public void teleopInit() {
		
	}

	 //This function is called periodically during operator control
	 
	@Override
	public void teleopPeriodic() {
		
		/** double value = leftJoy.getRawAxis(1);
		double value1 = leftJoy.getRawAxis(4);
		m_drive.arcadeDrive(value, value1);
		m_frontLeft.set(leftJoy.getRawAxis(1));
		*/
		
		
		if (leftJoy.getRawButtonPressed(4)) {
		
			mySol1.set(DoubleSolenoid.Value.kForward);
			mySol2.set(DoubleSolenoid.Value.kForward);
			
		
		}
		if (leftJoy.getRawButtonPressed(3)) {
			
			mySol1.set(DoubleSolenoid.Value.kReverse);
			mySol2.set(DoubleSolenoid.Value.kReverse);
		}
		
		if (leftJoy.getRawButtonPressed(2)){
			
			System.out.println(potDegrees);
			
		}
	}
}

	/**
	 * This function is called periodically during test mode
	 
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

	*/