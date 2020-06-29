import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class DnDCharacter {
    int strength,dexterity,constitution,intelligence, wisdom,charisma;

    int ability() {
        return dados();
    }

    int modifier(int input) {
        return (int)Math.round((input-10)/2);
    }

    int getStrength() {
        strength = (strength==0)?strength=dados():strength;
        return strength;
    }

    int getDexterity() {
        dexterity = (dexterity==0)?dexterity=dados():dexterity;
        return dexterity;
    }

    int getConstitution() {
        constitution = (constitution==0)?constitution=dados():constitution;
        return constitution;
    }

    int getIntelligence() {
        intelligence = (intelligence==0)?intelligence=dados():intelligence;
        return intelligence;
    }

    int getWisdom() {
        wisdom = (wisdom==0)?wisdom=dados():wisdom;
        return wisdom;
    }

    int getCharisma() {
        charisma = (charisma==0)?charisma=dados():charisma;
        return charisma;
    }

    int getHitpoints() {
        return 10+modifier(getConstitution());
    }

    private int dados(){
        List resultados = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            resultados.add(new Random().nextInt(6)+1);
        }
        resultados.remove(Collections.min(resultados));
        int value=0;
        for (Object a: resultados) {
            value+=(int)a;
        }
        return value;
    }

}
