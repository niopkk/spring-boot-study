package com.bbz.关系代理;

public class SpaceShipDelegation {

    private String name;

    private SpaceShipControls spaceShipControls;

    public SpaceShipDelegation(String name, SpaceShipControls spaceShipControls) {
        this.name = name;
        this.spaceShipControls = spaceShipControls;
    }

    public void up(int velocity) {
        spaceShipControls.up(velocity);
    }
    public void down(int velocity){
        spaceShipControls.down(velocity);
    }
    public void left(int velocity){
        spaceShipControls.left(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation delegation=new SpaceShipDelegation("dsd",new SpaceShipControls());

        delegation.up(111);
    }

}
