package org.frcteam5162.subsystems;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDriveSubsystem extends Subsystem {

    private static TalonSRX leftMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);
    private static TalonSRX rightMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);

    private static TankDriveSubsystem instance;

    public TankDriveSubsystem() {
        
    }

    public static TankDriveSubsystem getInstance() {
        if (instance == null) {
            instance = new TankDriveSubsystem();
        }

        return instance;
    }

    @Override
    public void periodic() {
        
    }

    public void drive(double left, double right) {
       leftMotor.set(ControlMode.PercentOutput, left/2);
       rightMotor.set(ControlMode.PercentOutput, right/2);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDriveCommand());
    }
}
