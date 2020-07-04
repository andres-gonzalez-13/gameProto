/*
 * 
 */
package views;

import models.GroupSoldier;

/**
 *
 * @author Andreck san
 */
public class BtnCardSoldier extends BtnStandar{
    
    private GroupSoldier soldier;

    public BtnCardSoldier(GroupSoldier soldier, String word, String linkIcon) {
        super(word, linkIcon);
        this.soldier = soldier;
    }
    
    
    
}
