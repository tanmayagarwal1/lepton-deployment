package com.uhg.tanmay.particle.api.builders;

import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;

public class ParticleBuilder {
    public static Particle builder(Wrapper wrap) {
        if (wrap.getTid() == 101) {
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Electron", wrap.getTid(), -1, 1, 0.511);
        }

        else if(wrap.getTid() == 102){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Muon", wrap.getTid(), -1, 1, 105.66);
        }

        else if(wrap.getTid() == 103){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Tau", wrap.getTid(), -1, 1, 1.7768);
        }

        else if(wrap.getTid() == 104){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Electron Neutrino", wrap.getTid(), 0, 1, 1.0);
        }

        else if(wrap.getTid() == 105){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Muon Neutrino", wrap.getTid(), 0, 1, 0.17);
        }

        else if(wrap.getTid() == 106){
            return new Particle(wrap.getPrice(), wrap.getQuantity(), "Tau Neutrino", wrap.getTid(), 0, 1, 18.2);
        }
        return null ;
    }
}
