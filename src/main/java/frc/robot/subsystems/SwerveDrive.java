// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants.ModulePosition;
import frc.robot.Constants.DriveConstants;

public class SwerveDrive extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public SwerveDrive() {}

    private Map<ModulePosition, SwerveModuleState> robotSpeedMetersToModuleStates(double forwardVelocity, double sidewaysvelocity, double rotationVelocity) {
        Map<ModulePosition, SwerveModuleState> moduleStates = new HashMap<ModulePosition, SwerveModuleState>();
        
        Vector2d motionVector = new Vector2d(forwardVelocity, sidewaysvelocity);

        for (ModulePosition i : ModulePosition.values()) {
            // Super cool calculation here
            moduleStates.put(i, new SwerveModuleState(0.0, new Rotation2d()));
        }

        return moduleStates;


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
