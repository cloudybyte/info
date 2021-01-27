package net.cloudybyte.jkee;

/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D. <hi@cloudybyte.net>, 2021
 */

import javakarol.Roboter;
import net.cloudybyte.jkee.errors.JkeeException;
import net.cloudybyte.jkee.pathfinder.Point;


/**
 * @author cloudybyte
 */

public class StepRobot extends Roboter {

    /**
     * Erzeugen eines neuen Roboters mit vorgegebener Startposition
     * <p>
     * Vorher muss ein Objekt der Klasse WELT angelegt werden, in der der Roboter lebt.
     *
     * @param Startposition      (startX, startY) mit 1..WeltBreite bzw. 1..WeltLänge
     * @param Startblickrichtung 'S','W','N','O'
     * @param Referenz           auf die Welt in der der Roboter leben soll
     */
    public StepRobot(int startX, int startY, char startBlickrichtung, Island inIsland) {
        super(startX, startY, startBlickrichtung, inIsland);
    }

    /**
     * Erzeugen eines neuen Roboters aufgrund der Einstellungen in einer Karolwelt-Datei
     * <p>
     * Vorher muss ein Objekt der Klasse WELT angelegt werden, in der der Roboter leben soll.
     * Wenn dieses Weltobjekt aus einer Karolwelt-Datei geladen wurde, dann werden
     * die dortigen Robotereinstellungen verwendet, sonst ein Default-Roboter
     * mit (1,1) und Blickrichtung 'S'
     *
     * @param Referenz auf die Welt in der der Roboter leben soll
     */
    public StepRobot(Island inIsland) {
        super(inIsland);
    }


    /**
     * Einmal Rein
     */
    public void rein() {
        super.Schritt();
    }


    /**
     * Uuuuund wieder raus
     */
    public void raus() {
        for (int i = 1; i != 2; i++) {
            super.LinksDrehen();
        }
        super.Schritt();
        for (int i = 1; i != 2; i++) {
            super.LinksDrehen();
        }
    }


    /**
     * Der Roboter dreht sich nach Links (gegen den Uhrzeigersinn)
     */
    public void LinksDrehen() {
        super.LinksDrehen();
    }


    /**
     * Der Roboter dreht sich nach Rechts (im Uhrzeigersinn)
     */
    public void RechtsDrehen() {
        super.RechtsDrehen();
    }


    /**
     * Der Roboter legt vor sich einen roten Ziegel hin
     */
    public void Hinlegen() {
        super.Hinlegen();
    }


    /**
     * Der Roboter legt vor sich einen Ziegel der gewählten Farbe hin
     * Mögliche Farben: "rot","gelb","blau","grün"
     */
    public void Hinlegen(Color farbeZiegel) {
        switch (farbeZiegel) {
            case RED:
                super.Hinlegen("rot");
                break;
            case BLUE:
                super.Hinlegen("blau");
                break;
            case BLACK:
                super.Hinlegen("schwarz");
                break;
            case GREEN:
                super.Hinlegen("grün");
                break;
            case YELLOW:
                super.Hinlegen("gelb");
        }
    }


    /**
     * Der Roboter hebt vor sich einen Ziegel beliebiger Farbe auf
     */
    public void Aufheben() {
        super.Aufheben();
    }


    /**
     * Der Roboter setzt auf der Kachel unter ihm eine gelbe Marke
     */
    public void MarkeSetzen() {
        super.MarkeSetzen();
    }


    /**
     * Der Roboter setzt auf der Kachel unter ihm eine Marke der gewählten Farbe
     * Mögliche Farben: "rot","gelb","blau","grün","schwarz"
     */
    public void MarkeSetzen(Color farbeMarke) {
        switch (farbeMarke) {
            case RED:
                super.MarkeSetzen("rot");
                break;
            case BLUE:
                super.MarkeSetzen("blau");
                break;
            case BLACK:
                super.MarkeSetzen("schwarz");
                break;
            case GREEN:
                super.MarkeSetzen("grün");
                break;
            case YELLOW:
                super.MarkeSetzen("gelb");
        }
    }


    /**
     * Der Roboter entfernt von der Kachel unter ihm eine Marke
     */
    public void MarkeLoeschen() {
        super.MarkeLoeschen();
    }


    /**
     * Der Roboter gibt einen Piep-Ton aus
     */
    public void propagandaMachen() {
        super.TonErzeugen();
    }


    /**
     * Abfrage ob der Roboter vor einer Wand bzw. einem Quader steht
     *
     * @return wenn zutrifft dann true
     */
    public boolean isMauer() {
        return super.IstWand();
    }


    /**
     * Abfrage ob vor dem Roboter ein Ziegel beliebiger Farbe liegt
     *
     * @return wenn zutrifft dann true
     */
    public boolean IstZiegel() {
        return super.IstZiegel();
    }


    /**
     * Abfrage ob vor dem Roboter ein Ziegel der angegebenen Farbe liegt
     * Mögliche Farben: "rot","gelb","blau","grün"
     *
     * @return wenn zutrifft dann true
     */
    public boolean IstZiegel(String farbeZiegel) {
        return super.IstZiegel(farbeZiegel);
    }


    /**
     * Abfrage ob links vom Roboter ein Ziegel liegt
     *
     * @return wenn zutrifft dann true
     */
    public boolean isGermanWall() {
        return super.IstZiegelLinks();
    }


    /**
     * Abfrage ob rechts vom Roboter ein Ziegel liegt
     *
     * @return wenn zutrifft dann true
     */
    public boolean isChineseWall() {
        return super.IstZiegelRechts();
    }


    /**
     * Abfrage ob sich unter dem Roboter eine Marke beliebiger Farbe befindet
     *
     * @return wenn zutrifft dann true
     */
    public boolean IstMarke() {
        return super.IstMarke();
    }


    /**
     * Abfrage ob sich unter dem Roboter eine Marke mit bestimmter Farbe befindet
     * Mögliche Farben: "rot","gelb","blau","grün","schwarz"
     *
     * @return wenn zutrifft dann true
     */
    public boolean IstMarke(Color farbeMarke) throws JkeeException {
        switch (farbeMarke) {
            case RED:
                return super.IstMarke("rot");
            case BLUE:
                return super.IstMarke("blau");
            case GREEN:
                return super.IstMarke("grün");
            case YELLOW:
                return super.IstMarke("gelb");
            default:
                throw new JkeeException("You can't assign the value " + farbeMarke + "to this method");
        }
    }


    public Point getPosition() {
        return new Point(this.PositionXGeben(), this.PositionYGeben());
    }

    public ViewingDirection getViewingDirection() throws JkeeException {
        if (this.IstBlickNorden()) {
            return ViewingDirection.NORTH;
        } else if (this.IstBlickSueden()) {
            return ViewingDirection.SOUTH;
        } else if (this.IstBlickOsten()) {
            return ViewingDirection.EAST;
        } else if (this.IstBlickWesten()) {
            return ViewingDirection.WEST;
        }
        throw new JkeeException("Direction cannot be parsed!");
    }
}
