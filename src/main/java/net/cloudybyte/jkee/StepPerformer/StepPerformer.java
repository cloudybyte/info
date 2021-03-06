/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee.StepPerformer;

import net.cloudybyte.jkee.StepRobot;
import net.cloudybyte.jkee.errors.StepSisterStuckException;

public class StepPerformer implements StepPerformerEngine {
    @Override
    public void perform_step(StepRobot stepRobot) throws StepSisterStuckException {
        try {
            stepRobot.rein();
        } catch (RuntimeException ex) {
            throw new StepSisterStuckException();
        }
    }
}
