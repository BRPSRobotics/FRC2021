package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;
import edu.wpi.first.wpilibj.command.Command;

// Import all subsystems required here.

public class BaseCommand extends Command {
    public BaseCommand()
    {
        // Add 'requires(<Subsystem>.getInstance());' for each subsystem required, replacing <Subsystem> with the class name.
    }

    protected void initialize()
    {
        // Called by Trigger handler when class is initialized.
    }

    protected void execute()
    {
        // Called after initialization.
    }

    protected void end()
    {
        // Called when Trigger end-case is met.
    }

    protected void interrupted()
    {
        // Called when an Interrupt is encountered.
        // Should call the end() command or do something similar to stop execution.
        end();
    }

    @Override
    protected boolean isFinished()
    {
        // Flag used to indicate if the Command is completed.]
        // Useful in autonomous commands to indicate when to clear the current command.

        return false;
    }
}