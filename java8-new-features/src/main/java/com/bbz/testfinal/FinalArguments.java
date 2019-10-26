package com.bbz.testfinal;

public class FinalArguments {

    void with(final Gizmo g) {

    }

    void withOut(Gizmo g) {
       g=new Gizmo();
       g.spin();
    }

    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf=new FinalArguments();
        bf.with(null);
        bf.withOut(null);
    }
}
