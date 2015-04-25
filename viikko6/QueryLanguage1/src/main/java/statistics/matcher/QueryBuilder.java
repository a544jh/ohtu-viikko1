/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author axel
 */
public class QueryBuilder {
    ArrayList<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList<Matcher>();
    }
    
    public Matcher build() {
        Matcher matcher = new And(matchers.toArray(new Matcher[0]));
        matchers.clear();
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matchers.add(new Or(m1, m2));
        return this;
    }
}
