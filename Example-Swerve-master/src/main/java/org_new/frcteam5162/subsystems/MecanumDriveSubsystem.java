package org_new.frcteam5162.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.frcteam5162.commands.MecanumDriveCommand;
import org.frcteam5162.config.RobotConfig;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MecanumDriveSubsystem extends Subsystem {

    private static TalonSRX frontLeftMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);
    private static TalonSRX frontRightMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);
    private static TalonSRX backLeftMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);
    private static TalonSRX backRightMotor = new TalonSRX(RobotConfig.FEEDER_CAN_ID);

    private static MecanumDriveSubsystem instance;

    public MecanumDriveSubsystem() {
        
    }

    public static MecanumDriveSubsystem getInstance() {
        if (instance == null) {
            instance = new MecanumDriveSubsystem();
        }

        return instance;
    }

    @Override
    public void periodic() {
        
    }

    public void drive(double x, double y, double rotation) {
        double[] speeds = getMecanumDriveSpeeds(x, y, rotation);
        frontLeftMotor.set(ControlMode.PercentOutput, speeds[0]);
        frontRightMotor.set(ControlMode.PercentOutput, speeds[1]);
        backLeftMotor.set(ControlMode.PercentOutput, speeds[2]);
        backRightMotor.set(ControlMode.PercentOutput, speeds[3]);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDriveCommand());
    }

    public static double[] getMecanumDriveSpeeds(double x, double y, double rotation)
    {
        double[] speeds = new double[4];
        
        speeds[0] = x + y + rotation;
        speeds[1] = -x + y - rotation;
        speeds[2] = -x + y + rotation;
        speeds[3] = x + y - rotation;
        
        normalizeSpeeds(speeds);
        
        return speeds;
    }

    private static void normalizeSpeeds(double[] speeds)
    {
        double maxMagnitude = Math.abs(speeds[0]);
        
        for (int i = 1; i < speeds.length; i++)
        {
            double magnitude = Math.abs(speeds[i]);
            
            if (magnitude > maxMagnitude)
            {
                maxMagnitude = magnitude;
            }
        }
        
        if (maxMagnitude > 1.0)
        {
            for (int i = 0; i < speeds.length; i++)
            {
                speeds[i] /= maxMagnitude;
            }
        }
    }

}
