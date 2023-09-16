package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class MaulLeerException extends HamsterException implements Serializable {
    public MaulLeerException(Hamster hamster) {
        super(hamster, "1");
    }

    public String toString() {
        return "hamster.MaulLeerException";
    }
}