package org.training.food_tracker.dao;

import org.training.food_tracker.dao.impl.ConnectionFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new ConnectionFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
