/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D. <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee;

import net.cloudybyte.jkee.errors.JkeeException;
import net.cloudybyte.jkee.pathfinder.Intelligenz;
import net.cloudybyte.jkee.pathfinder.Point;

public class main {

    public static void main(String[] args) throws JkeeException {
        //this program isn't overengineered.
        UEBUNG ubung = new UEBUNG();
        Intelligenz schlau = new Intelligenz(ubung.erde, ubung.karol);
        schlau.move_to_point(new Point(9, 9));
        //ubung.Aufgabe4();

    }
}
