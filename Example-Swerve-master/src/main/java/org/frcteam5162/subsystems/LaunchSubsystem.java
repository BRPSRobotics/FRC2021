package org.frcteam5162.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frcteam5162.config.RobotConfig;

public class LaunchSubsystem extends Subsystem {
    private static LaunchSubsystem instance;
    private static double dblOnPower = -1;
    private static TalonSRX mtrLauncherRear = new TalonSRX(RobotConfig.LAUNCH_RE_CAN_ID);
    private static TalonSRX mtrLauncherFront = new TalonSRX(RobotConfig.LAUNCH_FR_CAN_ID);

    public LaunchSubsystem() {
        mtrLauncherRear.set(ControlMode.PercentOutput, 0);
        mtrLauncherFront.set(ControlMode.PercentOutput, 0);

        mtrLauncherRear.setNeutralMode(NeutralMode.Coast);
        mtrLauncherFront.setNeutralMode(NeutralMode.Coast);
    }

    public static LaunchSubsystem getInstance() {
        if (instance == null)
        {
            instance = new LaunchSubsystem();
        }

        return instance;
    }

    public static void LauncherOn()
    {
        mtrLauncherRear.set(ControlMode.PercentOutput, dblOnPower);
        mtrLauncherFront.set(ControlMode.PercentOutput, dblOnPower);
    }

    public static void LauncherOff()
    {
        mtrLauncherRear.set(ControlMode.PercentOutput, 0);
        mtrLauncherFront.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new LaunchCommand());
    }
}