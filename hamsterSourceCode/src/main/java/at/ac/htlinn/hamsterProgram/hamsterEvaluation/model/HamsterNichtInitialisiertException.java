package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class HamsterNichtInitialisiertException extends HamsterException
        implements Serializable {
    public HamsterNichtInitialisiertException(Hamster hamster) {
        super(hamster, "3");
    }

    public String toString() {
        return "hamster.HamsterNichtInitialisiertException";
    }
}