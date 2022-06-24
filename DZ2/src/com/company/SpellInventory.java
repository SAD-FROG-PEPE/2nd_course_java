package com.company;

import java.util.ArrayList;

public class SpellInventory {
    private ArrayList<Spell<?>> spells=new ArrayList<>(3);

    public void addSpell(Spell<?> spell)
    {
        if (spells.size()<3) {spells.add(spell);}
    }

    public ArrayList<Spell<?>> getSpells(){return this.spells;}
}
