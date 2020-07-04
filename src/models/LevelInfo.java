/*
 * 
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Andreck san
 */
public class LevelInfo {
    
    private int level;
    private ArrayList<Wave>listWaves;
    private Wave actualWave;
    private int secondEndLevel;
    private int scoreWin;

    public LevelInfo(int level, ArrayList<Wave> listWaves, int secondLevel, int scoreWin) {
        this.level = level;
        this.listWaves = listWaves;
        this.secondEndLevel = secondLevel;
        this.scoreWin = scoreWin;
        actualWave = listWaves.get(0);
    }
    
    public void setACtualWave(int second){
        actualWave = null;
        for (Wave wave : listWaves) {
            if(wave.getTimeToApear() == second){
                actualWave = wave;
                //System.out.println("nueva olada cargada");
            }
        }
    }

    public Wave getActualWave(){
        return actualWave;
    }

    

    public int getLevel() {
        return level;
    }

    public ArrayList<Wave> getListWaves() {
        return listWaves;
    }

    public int getSecondEndLevel() {
        return secondEndLevel;
    }

    public int getScoreWin() {
        return scoreWin;
    }
    
    
    
    
    
    
}
