// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants.ModulePosition;
import frc.robot.Constants.DriveConstants;

public class SwerveDrive extends SubsystemBase {

    private Map<ModulePosition,SwerveModule> swerveModules = Map.of(
        ModulePosition.BACK_LEFT, new SwerveModule(),
        ModulePosition.BACK_RIGHT, new SwerveModule(),
        ModulePosition.FRONT_LEFT, new SwerveModule(),
        ModulePosition.FRONT_RIGHT, new SwerveModule()
    );

    private SwerveDriveKinematics swerveDriveKinematics = new SwerveDriveKinematics(
        DriveConstants.modulePositions.values().toArray(new Translation2d[4]));

    /** Creates a new ExampleSubsystem. */
    public SwerveDrive() {}

    public void drive(double forwardVelocity, double sidewaysvelocity, double rotationVelocity) {
        SwerveModuleState[] moduleStates = swerveDriveKinematics.toSwerveModuleStates(
            new ChassisSpeeds(forwardVelocity, sidewaysvelocity, rotationVelocity));

        setDesiredModuleStates(Map.of(
            ModulePosition.BACK_LEFT, moduleStates[0],
            ModulePosition.BACK_RIGHT, moduleStates[1],
            ModulePosition.FRONT_LEFT, moduleStates[2],
            ModulePosition.FRONT_RIGHT, moduleStates[3]));
        
    }

    public void setDesiredModuleStates(Map<ModulePosition,SwerveModuleState> states) {
        for (ModulePosition i : ModulePosition.values()) {
            swerveModules.get(i).setDesiredModuleState(states.get(i));
        }
    }

    public void setDesiredModuleStates(SwerveModuleState state) {
        for (ModulePosition i : ModulePosition.values()) {
            swerveModules.get(i).setDesiredModuleState(state);
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
