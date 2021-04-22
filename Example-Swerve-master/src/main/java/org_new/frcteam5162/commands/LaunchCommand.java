package org_new.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam5162.subsystems.LaunchSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchCommand extends Command {
    public LaunchCommand() {
        requires(LaunchSubsystem.getInstance());
    }

    protected void initialize()
    {
        Robot.getSubLaunch().LauncherOn();
    }

    protected void execute() {
        //Set LauncherMotor power to full ON
    }

    protected void end()
    {
        Robot.getSubLaunch().LauncherOff();
    }

    protected void interrupted()
    {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}