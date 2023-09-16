package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class HamsterInitializationException extends HamsterInitialisierungsException
        implements Serializable {
    public HamsterInitializationException(Hamster hamster) {
        super(hamster);
    }

    public HamsterInitializationException(HamsterInitialisierungsException e) {
        super(e.hamster);
    }

}
