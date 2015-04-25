/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author axel
 */
public class HasFewerThan implements Matcher {
    HasAtLeast hal;

    public HasFewerThan(int value, String category) {
        this.hal = new HasAtLeast(value, category);
    }
    
    @Override
    public boolean matches(Player p) {
        return !hal.matches(p);
    }
    
}
