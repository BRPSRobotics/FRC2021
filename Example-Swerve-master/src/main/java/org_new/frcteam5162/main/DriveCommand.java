package org_new.frcteam5162.main;

import org_new.frcteam5162.commands.TankDriveCommand;
import edu.wpi.first.wpilibj.command.Command;


public class DriveCommand extends Command {

    private TankDriveCommand driveTypeCommand;

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