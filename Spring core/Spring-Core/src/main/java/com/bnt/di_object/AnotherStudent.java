package com.bnt.di_object;

public class AnotherStudent {

    private MathCheat cheat;

    public MathCheat getCheat() {
        return cheat;
    }

    public void setCheat(MathCheat cheat) {
        this.cheat = cheat;
    }

    public void startCheating(){
        cheat.mathCheat();
    }
}
