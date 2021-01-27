/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee.StepPerformer;

public class StepPerformerEngineFactory {
    static StepPerformer performer;
    StepPerformerEngineFactory() {
        performer = new StepPerformer();
    }
    public static StepPerformer getStepPerformer() {
        return performer;
    }
}
