// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.CAN;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private CANSparkMax leftmotor1 = new CANSparkMax(8, MotorType.kBrushless); //creates a new SparkMax MotorController
  private CANSparkMax leftmotor2 = new CANSparkMax(9, MotorType.kBrushless); //creates a new SparkMax MotorController
  private MotorControllerGroup leftMCgroup = new MotorControllerGroup(leftmotor1, leftmotor2); // Groups previous MotorControllers together
  private CANSparkMax rightmotor1 = new CANSparkMax(10, MotorType.kBrushless); //creates a new SparkMax MotorController
  private CANSparkMax rightmotor2 = new CANSparkMax(11, MotorType.kBrushless); //creates a new SparkMax MotorController
  private MotorControllerGroup rightMCgroup = new MotorControllerGroup(rightmotor1, rightmotor2); // Groups previous MotorControllers together

  private DifferentialDrive m_MyDrivetrain = new DifferentialDrive(leftMCgroup, rightMCgroup); // creates an actual drivetrain using the motorcontroller groups above

  public void arcadeDrive(double turnrate, double throttle){ // creates a new arcadedrive function, and varibles for turning and driving
    m_MyDrivetrain.arcadeDrive(turnrate, throttle, false);
  } 
  
  public Drivetrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
