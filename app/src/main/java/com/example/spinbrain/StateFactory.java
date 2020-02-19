package com.example.spinbrain;

public class StateFactory {
    private static StateFactory instance;
    private int state;
    private Object stateObj = null;


    StateFactory(){

    }

    public static StateFactory Instance(){
        if(instance == null){
            instance = new StateFactory();
            instance.state = 1;
        }
           return instance;

    }

//    public void setState(int state){
//        this.state = state;
//
//    }



    public Object getState(int state){
        switch (state){
            case 1: stateObj = new State1();
                    break;
            case 2: stateObj = new State2();
                    break;
        }
        return stateObj;


    }


}
