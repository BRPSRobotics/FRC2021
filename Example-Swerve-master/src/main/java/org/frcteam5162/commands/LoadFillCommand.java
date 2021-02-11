package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.frcteam5162.subsystems.LoadFillSubsystem;

public class LoadFillCommand extends Command {
    public LoadFillCommand()
    {
        requires(LoadFillSubsystem.getInstance());
    }

    protected void initialize()
    {
        Robot.getSubLoadFill().LoadFillOn(); // Motor power for ON is defined in LoadFillSubsystem.java
    }

    protected void execute()
    {
        
    }

    protected void end()
    {
        Robot.getSubLoadFill().LoadFillOff();
    }

    protected void interrupted()
    {
        end();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}