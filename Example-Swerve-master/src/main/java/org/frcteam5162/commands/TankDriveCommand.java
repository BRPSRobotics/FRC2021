package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam5162.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {

    public TankDriveCommand() {
        requires(TankDriveSubsystem.getInstance());
    }

    @Override
    protected void execute() {
        final double right = Robot.getOi().getPrimaryY();
        final double left = Robot.getOi().getSecondaryY();

        TankDriveSubsystem.getInstance().drive(right, left);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
