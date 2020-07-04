/*
 * 
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Andreck san
 */
public class LevelManager {
    
    private EntityManager entiManager;
    private int actualSeconds;
    private LevelInfo actuallevel;
    private LevelInfo level1;

    public LevelManager() {
        entiManager = new EntityManager();
        actuallevel = null;
        actualSeconds = 0;
        createLevel1();
        
        
        setNextlevel();
    }

    public int getActualSeconds() {
        return actualSeconds;
    }

    public void setActualSeconds(int actualSeconds) {
        this.actualSeconds = actualSeconds;
    }
    
    public void spendaSecond(){
        actualSeconds++;
        actuallevel.setACtualWave(actualSeconds);
    }

    public void createLevel1(){
        int lev = 1;        
        //createWaves(entiManager.getListEntityLevel1());
        level1 = new LevelInfo(lev, createWaves(entiManager.getListEntityLevel1()), 60, 200);
    }

    public LevelInfo getActuallevel() {
        return actuallevel;
    }
    
    public void setNextlevel(){
        if(actuallevel == null){
            actuallevel = level1;
        }
    }

    public LevelInfo getLevel1() {
        return level1;
    }        
    
    public ArrayList<Wave> createWaves(ArrayList<EntityMoving> listEnemiesLevel){
        ArrayList<Wave> listWaves = new ArrayList<>();
        Wave wave1 = new Wave(getRandomLevelEntities(listEnemiesLevel), 1);
        listWaves.add(wave1);
        Wave wave2 = new Wave(getRandomLevelEntities(listEnemiesLevel), 5);
        listWaves.add(wave2);
//        Wave wave3 = new Wave(getRandomLevelEntities(listEnemiesLevel), 6);
//        listWaves.add(wave3);
//        Wave wave4 = new Wave(getRandomLevelEntities(listEnemiesLevel), 22);
//        listWaves.add(wave4);
        Wave wave5 = new Wave(getRandomLevelEntities(listEnemiesLevel), 10);
        listWaves.add(wave5);
//        Wave wave6 = new Wave(getRandomLevelEntities(listEnemiesLevel), 30);
//        listWaves.add(wave6);
//        Wave wave7 = new Wave(getRandomLevelEntities(listEnemiesLevel), 36);
//        listWaves.add(wave7);
//        Wave wave8 = new Wave(getRandomLevelEntities(listEnemiesLevel), 39);
//        listWaves.add(wave8);        
        return listWaves;
    }
    
    public ArrayList<EntityMoving> getRandomLevelEntities(ArrayList<EntityMoving>listEne){
        ArrayList<EntityMoving> newlist = new ArrayList<>();
        //for (int i = 0; i < getRandomInt(0, listEne.size()); i++) {
        for (EntityMoving entityMoving : listEne) {
            
            int height = entityMoving.getHeight();
            int width = entityMoving.getWidth();
            EntityMoving enti = new EntityMoving( height,width,
                            entityMoving.getImageEntity(),
                            entityMoving.getSpeedPixels());
            enti.setRoute(entityMoving.getListroute());
            newlist.add(enti);
            enti = null;
        }
        
        return newlist;
    }
    
    public int getRandomInt(int min,int max) {
        return (int) (Math.floor(Math.random() * (max - min)) + min);
    }
    
    
}
