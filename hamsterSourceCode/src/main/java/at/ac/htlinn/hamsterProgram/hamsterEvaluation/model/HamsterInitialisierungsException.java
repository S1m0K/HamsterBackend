package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class HamsterInitialisierungsException extends HamsterException
        implements Serializable {
    public HamsterInitialisierungsException(Hamster hamster) {
        super(hamster, "4");
    }

    public String toString() {
        return "hamster.HamsterInitialisierungsException";
    }
}
