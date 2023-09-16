package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class MouthEmptyException extends MaulLeerException implements Serializable {
    public MouthEmptyException(Hamster hamster) {
        super(hamster);
    }

    public MouthEmptyException(MaulLeerException exc) {
        super(exc.hamster);
    }
}