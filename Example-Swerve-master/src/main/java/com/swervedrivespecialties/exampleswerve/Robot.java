package com.swervedrivespecialties.exampleswerve;

import java.sql.Time;

import com.swervedrivespecialties.exampleswerve.commands.DriveCommand;
import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;

import org.frcteam5162.commands.FeederCommand;
import org.frcteam5162.subsystems.color_wheel.ColorWheelTurnSubsystem;
import org.frcteam5162.subsystems.color_wheel.ColorWheelArmSubsystem;
import org.frcteam5162.subsystems.FeederSubsystem;
import org.frcteam5162.subsystems.LaunchSubsystem;
import org.frcteam5162.subsystems.LiftSubsystem;
import org.frcteam5162.subsystems.LoadFillSubsystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Robot extends TimedRobot {
    private static OI oi;

    private static DrivetrainSubsystem drivetrain;

    private static LoadFillSubsystem subLoadFill;
    private static FeederSubsystem subFeeder;
    private static LaunchSubsystem subLaunch;
    private static LiftSubsystem subLift;
    private static ColorWheelArmSubsystem subColorWheelArm;
    private static ColorWheelTurnSubsystem subColorWheelTurn;

    private final Timer m_timer = new Timer();
    private SequentialCommandGroup autonomousCommandGroup;

    public static OI getOi() {
        return oi;
    }

    public static LoadFillSubsystem getSubLoadFill()
    {
        return subLoadFill;
    }

    public static FeederSubsystem getSubFeeder()
    {
        return subFeeder;
    }

    public static LaunchSubsystem getSubLaunch()
    {
        return subLaunch;
    }

    public static LiftSubsystem getSubLift()
    {
        return subLift;
    }

    public static ColorWheelArmSubsystem getSubColorWheelArm()
    {
        return subColorWheelArm;
    }

    public static ColorWheelTurnSubsystem getSubColorWheelTurn()
    {
        return subColorWheelTurn;
    }

    @Override
    public void robotInit() {
        oi = new OI();
        subLift = LiftSubsystem.getInstance();
        subLaunch = LaunchSubsystem.getInstance();
        subLoadFill = LoadFillSubsystem.getInstance();
        subFeeder = FeederSubsystem.getInstance();
        drivetrain = DrivetrainSubsystem.getInstance();

        //autonomousCommandGroup = new SequentialCommandGroup(new FeederCommand(), new DriveCommand());
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left Analog - X-Axis", oi.getSecondaryX());
        SmartDashboard.putNumber("Left Analog - Y-Axis", oi.getSecondaryY());
        SmartDashboard.putNumber("Right Analog - X-Axis", oi.getPrimaryX());
        SmartDashboard.putNumber("Right Analog - Y-Axis", oi.getPrimaryY());
    }

    @Override
    public void autonomousInit() {
        m_timer.reset();
        m_timer.start();

        //if (autonomousCommandGroup != null) autonomousCommandGroup.start();
    }
}
