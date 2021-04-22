package org_new.frcteam5162.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org_new.frcteam5162.commands.TankDriveCommand;
import org_new.frcteam5162.config.RobotConfig;

import edu.wpi.first.wpilibj.command.Subsystem;

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
