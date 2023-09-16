package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class TileEmptyException extends KachelLeerException
        implements
        Serializable {


    public TileEmptyException(Hamster hamster, int reihe, int spalte) {
        super(hamster, reihe, spalte);

    }

    public TileEmptyException(KachelLeerException e) {
        super(e.hamster, e.reihe, e.spalte);

    }

}