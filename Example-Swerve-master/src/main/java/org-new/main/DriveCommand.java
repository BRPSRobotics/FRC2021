package org.frcteam5162.main;

import edu.wpi.first.wpilibj.command.Command;


public class DriveCommand extends Command {

    private Command driveTypeCommand;

    public DriveCommand() {
        driveTypeCommand = new TankDriveCommand();
    }

    @Override
    protected void execute() {
        driveTypeCommand.execute();
    }

    @Override
    protected boolean isFinished() {
        return driveTypeCommand.isFinished();
    }
}