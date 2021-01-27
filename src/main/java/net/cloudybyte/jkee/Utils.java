/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee;

import net.cloudybyte.jkee.errors.JkeeException;

public class Utils {
    public ViewingDirection getViewingDirection(StepRobot robot) throws JkeeException {
        if (robot.IstBlickNorden()) {
            return ViewingDirection.NORTH;
        } else if (robot.IstBlickSueden()) {
            return ViewingDirection.SOUTH;
        } else if (robot.IstBlickWesten()) {
            return ViewingDirection.WEST;
        } else if (robot.IstBlickOsten()) {
            return ViewingDirection.EAST;
        }
        throw new JkeeException("Couldn't determine viewing direction!");
    }
}
