package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.frcteam5162.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
    private boolean is_forward;

    public IntakeCommand(boolean forward)
    {
        requires(IntakeSubsystem.getInstance());
        this.is_forward = forward;
    }

    protected void initialize()
    {
        Robot.getSubIntake().IntakeOn(this.is_forward); // Motor power for ON is defined in IntakeSubsystem.java
    }

    protected void execute()
    {
        
    }

    protected void end()
    {
        Robot.getSubIntake().IntakeOff();
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