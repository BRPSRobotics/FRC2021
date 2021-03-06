package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import org.frcteam5162.commands.FeederCommand;
import org.frcteam5162.commands.LoadFillCommand;
import org.frcteam5162.commands.color_wheel.ColorWheelArmCommand;
import org.frcteam5162.commands.color_wheel.ColorWheelTurnCommand;
import org.frcteam5162.commands.LiftCommand;
import org.frcteam5162.commands.LaunchCommand;

public class OI {
    private final boolean use_controller = false;

    /*
       Add your joysticks and buttons here
     */

    private Joystick secondaryJoystick;
    private Joystick primaryJoystick;

    private XboxController primaryController;

    /* 5162 */

    private JoystickButton loadfillButton;
    private JoystickButton feederButton;
    private JoystickButton launchButton;
    private JoystickButton liftButton;
    private JoystickButton colorWheelArmButton;
    private JoystickButton colorWheelTurnButton;
    private JoystickButton gyroResetButton;


    /* ~5162 */

    public OI() {
        // Back button zeroes the drivetrain

        if (use_controller)
        {
            primaryController = new XboxController(0);
            loadfillButton = new JoystickButton(primaryController, XboxController.Button.kA.value);
            feederButton = new JoystickButton(primaryController, XboxController.Button.kB.value);
            launchButton = new JoystickButton(primaryController, XboxController.Button.kX.value);
            liftButton = new JoystickButton(primaryController, XboxController.Button.kY.value);
            colorWheelArmButton = new JoystickButton(primaryController, XboxController.Button.kBumperLeft.value);
            colorWheelTurnButton = new JoystickButton(primaryController, XboxController.Button.kBumperRight.value);
            gyroResetButton = new JoystickButton(primaryController, XboxController.Button.kBack.value);
        }
        else
        {
            secondaryJoystick = new Joystick(0);
            primaryJoystick = new Joystick(1);
            loadfillButton = new JoystickButton(primaryJoystick, 1);
            feederButton = new JoystickButton(primaryJoystick, 2);
            launchButton = new JoystickButton(primaryJoystick, 3);
            liftButton = new JoystickButton(primaryJoystick, 4);
            colorWheelArmButton = new JoystickButton(primaryJoystick, 5);
            colorWheelTurnButton = new JoystickButton(secondaryJoystick, 6);
            gyroResetButton = new JoystickButton(primaryJoystick, 7);
        }

        gyroResetButton.whenPressed(
                new InstantCommand(() -> DrivetrainSubsystem.getInstance().resetGyroscope())
        );

        feederButton.whileHeld(new FeederCommand());
        launchButton.whileHeld(new LaunchCommand());
        liftButton.whileHeld(new LiftCommand());
        loadfillButton.whileHeld(new LoadFillCommand());
        colorWheelArmButton.whileHeld(new ColorWheelArmCommand());
        colorWheelTurnButton.whileHeld(new ColorWheelTurnCommand());
    }

    public Joystick getPrimaryJoystick() {
        return primaryJoystick;
    }

    public Joystick getSecondaryJoystick() {
        return secondaryJoystick;
    }

    public double getPrimaryX() {
        if (this.use_controller)
        {
            return this.primaryController.getX(Hand.kLeft);
        }
        else
        {
            return this.primaryJoystick.getRawAxis(0);
        }
    }

    public double getPrimaryY() {
        if (this.use_controller)
        {
            return this.primaryController.getY(Hand.kLeft);
        }
        else
        {
            return this.primaryJoystick.getRawAxis(1);
        }
    }

    public double getSecondaryX() {
        if (this.use_controller)
        {
            return this.primaryController.getX(Hand.kRight);
        }
        else
        {
            return this.secondaryJoystick.getRawAxis(0);
        }
    }

    public double getSecondaryY() {
        if (this.use_controller)
        {
            return this.primaryController.getY(Hand.kRight);
        }
        else
        {
            return this.secondaryJoystick.getRawAxis(1);
        }
    }
}
