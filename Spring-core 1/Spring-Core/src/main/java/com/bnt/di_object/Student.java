package com.bnt.di_object;

public class Student {

    private int id;

//    MathCheat mathCheat = new MathCheat();    //using new keyword tight coupling
    private MathCheat mathCheat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MathCheat getMathCheat() {
        return mathCheat;
    }

    public void setMathCheat(MathCheat mathCheat) {
        this.mathCheat = mathCheat;
    }

    public void cheating(){
        mathCheat.mathCheat();
        System.out.println("Hey my id is "+id);
    }
}
