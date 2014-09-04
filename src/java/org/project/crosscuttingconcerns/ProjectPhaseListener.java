/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.crosscuttingconcerns;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author CNA
 */
public class ProjectPhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        //System.out.println("after: "+ event.getPhaseId()+" "+event.getSource());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //System.out.println("before: "+ event.getPhaseId()+" "+event.getSource());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
