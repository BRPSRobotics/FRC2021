// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class ArmControl extends SubsystemBase {
  /** Creates a new ArmControl. */
  public ArmControl() {}

private final static WPI_TalonFX tiltmotor = new WPI_TalonFX(4);

private MotorControllerGroup tiltmotorgroup = new MotorControllerGroup(tiltmotor);

public void armspeed(double speed){
  tiltmotorgroup.set(speed);
}

private final static WPI_TalonFX extend = new WPI_TalonFX(3);

private MotorControllerGroup extendgroup = new MotorControllerGroup(extend);

public void tiltspeed(double speed){
  extendgroup.set(speed);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
