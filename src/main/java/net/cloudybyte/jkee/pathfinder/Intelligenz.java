/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee.pathfinder;

import net.cloudybyte.jkee.Island;
import net.cloudybyte.jkee.StepRobot;
import net.cloudybyte.jkee.ViewingDirection;
import net.cloudybyte.jkee.errors.IntelligenzException;
import net.cloudybyte.jkee.errors.IntelligenzExceptionCause;
import net.cloudybyte.jkee.errors.JkeeException;

public class Intelligenz {

    Island norwegen;
    StepRobot menschi;

    public Intelligenz(Island norwegen, StepRobot menschi) {
        this.norwegen = norwegen;
        this.menschi = menschi;
    }


    public void move_to_point(Point to) throws JkeeException {
        this.menschi.VerzoegerungSetzen(1000);
        Point from = this.menschi.getPosition();
        print_point(from);
        print_point(to);
        int x_offset = from.x - to.x;
        int y_offset = from.y - to.y;
        System.out.printf("Initial Offset: xout: %s, y_out: %s\n", x_offset, y_offset);

        if (x_offset > 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.WEST) {
                this.menschi.RechtsDrehen();
            }
            while (x_offset != 0) {
                this.menschi.Schritt();
                x_offset = calc_x_offset(to);
            }
        } else if (x_offset < 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.EAST) {
                this.menschi.RechtsDrehen();
            }
            while (x_offset != 0) {
                this.menschi.Schritt();
                x_offset = calc_x_offset(to);
            }
        }
        print_point(this.menschi.getPosition());

        if (y_offset > 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.NORTH) {
                this.menschi.RechtsDrehen();
            }
            while (y_offset != 0) {
                this.menschi.Schritt();
                y_offset = calc_y_offset(to);
            }
        } else if (y_offset < 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.SOUTH) {
                this.menschi.RechtsDrehen();
            }
            while (y_offset != 0) {
                this.menschi.Schritt();
                y_offset = calc_y_offset(to);
            }
        }


        System.out.printf("Arrived! \n x_offset: %s, y_offset: %s\n", calc_x_offset(to), calc_y_offset(to));
    }

    int calc_x_offset(Point target) {
        return this.menschi.getPosition().x - target.x;
    }

    int calc_y_offset(Point target) {
        return this.menschi.getPosition().y - target.y;
    }

    void print_point(Point point) {
        System.out.printf("Point:    x: %s, y: %s\n", point.x, point.y);
    }

    void walk_straight(Point to) throws JkeeException {
        Point from = this.menschi.getPosition();
        int x_offset = from.x - to.x;
        int y_offset = from.y - to.y;

        if (x_offset > 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.WEST) {
                this.menschi.RechtsDrehen();
            }
            while (x_offset != 0) {
                this.menschi.Schritt();
                x_offset = calc_x_offset(to);
            }
        } else if (x_offset < 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.EAST) {
                this.menschi.RechtsDrehen();
            }
            while (x_offset != 0) {
                this.menschi.Schritt();
                x_offset = calc_x_offset(to);
            }
        }
        print_point(this.menschi.getPosition());

        if (y_offset > 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.NORTH) {
                this.menschi.RechtsDrehen();
            }
            while (y_offset != 0) {
                this.menschi.Schritt();
                y_offset = calc_y_offset(to);
            }
        } else if (y_offset < 0) {
            while (this.menschi.getViewingDirection() != ViewingDirection.SOUTH) {
                this.menschi.RechtsDrehen();
            }
            while (y_offset != 0) {
                this.menschi.Schritt();
                y_offset = calc_y_offset(to);
            }
        }

    }

    /**
     * @return true if position needs to be reevaluated and offsets need to be recalculated
     */
    boolean avoid_collision_step() throws IntelligenzException {
        try {
            this.menschi.Schritt();
            return false;
        } catch (RuntimeException e) {
            turn_from_wall();
            while (this.menschi.isGermanWall()) {
                try {
                    this.menschi.Schritt();
                } catch (RuntimeException f) {
                    turn_from_wall();
                }
            }
            return true;
        }
    }

    private void turn_from_wall() throws IntelligenzException {
        int i = 0;
        while (this.menschi.isMauer()) {
            if (i == 4) {
                throw new IntelligenzException(IntelligenzExceptionCause.STUCK);
            }
            this.menschi.LinksDrehen();
            i++;
        }
    }

    /**
     * @return true if there is a gap to go through on the left, false if not. NOTE: If there is a gap, the robot is facing it, and not turning back to the original direction!
     * */
    private boolean breach_left() {
        this.menschi.LinksDrehen();
        if (!this.menschi.isMauer()) {
            return true;
        }
        this.menschi.RechtsDrehen();
        return false;
    }

}
