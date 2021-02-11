package org.frcteam5162.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frcteam5162.config.RobotConfig;

public class LoadFillSubsystem extends Subsystem {
    private static LoadFillSubsystem instance;
    private static double dblOnPower = 0.25;
    private static TalonSRX mtrLoadFill = new TalonSRX(RobotConfig.LOAD_CAN_ID);

    public LoadFillSubsystem() {
        mtrLoadFill.set(ControlMode.PercentOutput, 0);
        mtrLoadFill.setNeutralMode(NeutralMode.Brake);
    }

    public static LoadFillSubsystem getInstance() {
        if (instance == null)
        {
            instance = new LoadFillSubsystem();
        }

        return instance;
    }

    public static void LoadFillOn()
    {
        // Set LoadFill motor to on (dblOnPower).
        mtrLoadFill.set(ControlMode.PercentOutput, dblOnPower);
    }
    public static void LoadFillOff()
    {
        // Set LoadFill motor to off (0).
        mtrLoadFill.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new LoadFillCommand());
    }
}