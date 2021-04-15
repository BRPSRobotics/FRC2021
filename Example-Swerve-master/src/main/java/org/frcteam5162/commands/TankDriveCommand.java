package org.frcteam5162.commands;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {

    public TankDriveCommand() {
        requires(TankDriveSubsystem.getInstance());
    }

    @Override
    protected void execute() {
        double right = Robot.getOi().getPrimaryY();
        double left = Robot.getOi().getSecondaryY();

        DrivetrainSubsystem.getInstance().drive(right, left);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
