/*
 * CornThereException.java
 *
 * Created on 10. Oktober 2007, 10:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package at.ac.htlinn.hamsterProgram.hamsterEvaluation.lego.model;

import at.ac.htlinn.hamsterProgram.hamsterEvaluation.debugger.model.Hamster;

import java.io.Serializable;

/**
 * @author Christian
 */
public class CornThereException extends KornDaException implements Serializable {

    /**
     * Creates a new instance of CornThereException
     */
    public CornThereException(Hamster hamster, int reihe, int spalte) {
        super(hamster, reihe, spalte);
    }

    public CornThereException(KornDaException e) {
        super(e.hamster, e.reihe, e.spalte);
    }

}
