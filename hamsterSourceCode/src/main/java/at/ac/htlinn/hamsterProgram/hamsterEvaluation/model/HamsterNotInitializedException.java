package at.ac.htlinn.hamsterProgram.hamsterEvaluation.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author $Author: djasper $
 * @version $Revision: 1.1 $
 */
public class HamsterNotInitializedException extends
        HamsterNichtInitialisiertException implements Serializable {
    public HamsterNotInitializedException(Hamster hamster) {
        super(hamster);
    }

    public HamsterNotInitializedException(HamsterNichtInitialisiertException e) {
        super(e.hamster);
    }

}