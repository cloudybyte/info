/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole D.  <hi@cloudybyte.net>, 2021
 */

package net.cloudybyte.jkee;

import org.jetbrains.annotations.NotNull;

class UEBUNG {
    
    Island erde;
    StepRobot karol;

        // Wähle im Konstruktor immer den Teil, der zur Aufgabe gehört
    UEBUNG(){
        
        
        // Aufgabe 1,2: Deine Loesungen sollen auch noch funktionieren, 
        // falls die Groeße der Welt geaendert wird
        erde = new Island(10,10,5);
        karol = new StepRobot(6,7,'W',erde);
        karol.VerzoegerungSetzen(10);
    }
    
    // Verwende bei alle Aufgaben so weit wie möglich Zaehlwiederholungen und / oder bedingte Wiederholungen
    
    // Karol soll bis zur naechsten Wand laufen
    void Aufgabe1() {
        // Wiederholung mit Bedingung --> while
        // Bedingung: Karol steht nicht vor der Wand --> karol.IstWand() == false
        while(true) {
            try {
                this.karol.rein();
            }catch (RuntimeException i) {
                System.out.println("Karol steht vor der wand!");
                responsible_exit(1000, ExitCause.OK);
            }
           sleep(250);
        }
    }
    
    // Karol soll sich nach Norden drehen und dann zur Wand laufen
    void Aufgabe2(){
        // Erst muss sich Karol nach Norden drehen 
        //--> Wiederholung mit Bedingung --> while
        // Benutze für die Bedingung karol.IstBlickNorden()
        while (!this.karol.IstBlickNorden()) {
            this.karol.LinksDrehen();
        }
        responsible_exit(1000, ExitCause.OK);
    }
    
    // Karol soll bis zur Wand laufen und dabei alle Ziegelsteine aufheben
    void Aufgabe3(){
        // Aehnlich wie Aufgabe1, aber diesesmal muss Karol vor jedem Schritt überprüfen,
        // ob ein Stein vor ihm liegt und ihn dann aufheben --> bedingte Anweisung (if ...)
        while (true) {
            try {
                this.karol.Aufheben();
            } catch (RuntimeException ignored) {}
            try {
                this.karol.rein();
            }catch (RuntimeException ignored) {
                System.out.println("Karol steht vor einer Wand!");
                responsible_exit(1000, ExitCause.OK);
            }
            sleep(250);
        }
    }
    
    // Karol soll 100 Ziegelsteine entlang der Wand legen
    void Aufgabe4(){
        reset();
        straight_legen();
        // 100 Steine legen --> Zaehlwiederholung (for ...)
        // In der Zaehlwiederholung muss er immer einen Stein legen und einen Schritt machen
        // Falls er vor einer Wand steht muss er sich zuerst um 90° nach links drehen (if ...)
        for (int i = 0; i != 100; i++) {
            try_legen();
            try_step();
        }
    }



    void reset() {
        while (!this.karol.isMauer()) {
            this.karol.rein();
        }
        this.karol.LinksDrehen();
        while (!this.karol.isMauer()) {
            this.karol.rein();
        }
        this.karol.LinksDrehen();
    }

    /**
     * @param timeout Timeout till exit in ms
     * @param exitCause Cause while we want to exit the program
     * */
    public void responsible_exit(@NotNull int timeout, @NotNull ExitCause exitCause) {

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.exit(exitcause_to_int(ExitCause.INTERRUPTED));
        }
        System.exit(exitcause_to_int(exitCause));
    }

    public int exitcause_to_int(@NotNull ExitCause exitCause) {
        int causeid;
        switch (exitCause) {

            case OK:
                causeid = 0;
                break;

            case KAROL_SHIT:
                causeid = 69;
                break;

            case INTERRUPTED:
                causeid = 2;
                break;

            case RUNTIME_EXCEPTION:
                causeid = 3;
                break;

            default:
                causeid = 999;
                break;

        };
        return causeid;
    }

    void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            responsible_exit(3000, ExitCause.INTERRUPTED);
        }
    }

    void try_step(){
        try {
            this.karol.rein();
        } catch (RuntimeException ignored) {
            this.karol.LinksDrehen();
        }
    }

    void try_legen(){
        try {
            this.karol.Hinlegen();
        } catch (RuntimeException ignored) {
            this.karol.LinksDrehen();
            this.karol.Hinlegen();
        }
    }

    void straight_legen() {
        for (int i = 1; i != 2; i++) {
            this.karol.LinksDrehen();
        }
        try_step();
        for (int i = 1; i != 2; i++) {
            this.karol.LinksDrehen();
        }
        try_legen();
        try_step();
    }
}