// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.supurdueper.robot2025.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import org.supurdueper.lib.subsystems.SupurdueperSubsystem;
import org.supurdueper.lib.subsystems.TalonFXSubsystem;
import org.supurdueper.robot2025.CanId;
import org.supurdueper.robot2025.Robot;
import org.supurdueper.robot2025.state.RobotStates;

import static org.supurdueper.robot2025.Constants.FunnelConstants.*;

public class Funnel extends TalonFXSubsystem implements SupurdueperSubsystem {
  /** Creates a new FunnelSubsystem. */
  public Funnel() {
    Robot.add(this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.periodic();
  }

  private void run(){
    runVoltage(kIntakeVoltage);
  }

  private Command intake(){
    return runEnd(this::run, this::stop).withName("Funnel.Intake");
  }

  @Override
  public void bindCommands() {
    // TODO Auto-generated method stub
    RobotStates.actionIntake.onTrue(intake());
  }

  @Override
  public CanId canIdLeader() {
    // TODO Auto-generated method stub
    return CanId.TALONFX_FUNNEL;
  }

  @Override
  public CanId canIdFollower() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean followerInverted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public CurrentLimitsConfigs currentLimits() {
    // TODO Auto-generated method stub
    return kCurrentLimit;
  }

  @Override
  public boolean inverted() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean brakeMode() {
    // TODO Auto-generated method stub
    return true;
  }
}
