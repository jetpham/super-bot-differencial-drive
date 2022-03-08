// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants.ModulePosition;
import frc.robot.Constants.DriveConstants;

public class SwerveDriveTrain extends SubsystemBase {
    /** Creates a new SwerveDriveTrain. */
    public SwerveDriveTrain() {}

    // TODO: Double check clockwise direction and X/Z flipping

    /**
     * Calculates the swerve module states relative to the robot based on the robot speeds
     * 
     * @param forwardVelocity Forwards velocity in meters per second.
     * @param sidewaysVelocity Sideways velocity in meters per second.
     * @param rotationVelocity Rotational velocity in radians per second, clockwise positive.
     * @return A {@link Map} of {@link ModulePosition} to {@link SwerveModuleState}.
     */
    public Map<ModulePosition, SwerveModuleState> robotSpeedToModuleStates(double forwardVelocity, double sidewaysVelocity, double rotationVelocity) {

        /** Map of {@link SwerveModuleState} for each {@link ModulePosition} */
        Map<ModulePosition, SwerveModuleState> moduleStates = new HashMap<ModulePosition, SwerveModuleState>();

        /** Vector of the robot's motion */
        Translation2d motionVector = new Translation2d(forwardVelocity, sidewaysVelocity);
        
        // For every module position
        for (ModulePosition i : ModulePosition.values()) {

            /** Position of the current module */
            Translation2d modulePosition = DriveConstants.modulePositions.get(i);

            /** Heading of the vector for the module to rotate the robot */
            double rotationVectorHeading = Math.atan2(modulePosition.getY(), modulePosition.getX());

            /** Vector for the module to rotate the robot */
            Translation2d rotationVector =  new Translation2d(
                -modulePosition.getNorm() * rotationVelocity * Math.cos(rotationVectorHeading),
                modulePosition.getNorm() * rotationVelocity * Math.sin(rotationVectorHeading));
            
            /** Final sum of the motion and rotation vectors */
            Translation2d sumVector = motionVector.plus(rotationVector);

            // Add the pose to the module state
            moduleStates.put(i, new SwerveModuleState(sumVector.getNorm(), new Rotation2d(Math.atan2(sumVector.getY(), sumVector.getX()))));
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
