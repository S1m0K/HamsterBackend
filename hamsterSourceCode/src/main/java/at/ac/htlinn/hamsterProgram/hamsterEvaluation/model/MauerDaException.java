package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class MauerDaException extends HamsterException implements Serializable {
    int reihe;
    int spalte;

    public MauerDaException(Hamster hamster, int reihe, int spalte) {
        super(hamster, "2");
        this.reihe = reihe;
        this.spalte = spalte;

    }

    public int getReihe() {
        return reihe;
    }

    public int getSpalte() {
        return spalte;
    }

    public String toString() {
        return "hamster.MauerDaException" + " (" + reihe + ", " + spalte + ")";
    }
}