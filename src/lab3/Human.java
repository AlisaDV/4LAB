package lab3;

import java.util.Random;

public class Human extends Creatures implements LostOfHealth, retribution{
Hum Type;
Location location;
int hp;
public Human (Hum type, Location str, int l) throws NegativeHPException {
	if(l <= 0) {
		new NegativeHPException("Аллерт, здоровье меньше или равно нулю");
	}
		Type = type;
		location=str;
		hp=l;
}

public Location getLoc() {
	return location;
}
public Hum getType() {
	return Type;
}

public void setType(Hum type) {
	this.Type = type;
}

@Override
public void LostHP(int diff) {
	hp=hp-diff;
	if (hp<=0) {
		System.out.println("Человек убит");
	}
	else {
		System.out.println("Выжил. Осталось " + hp + " здоровья");
	}
}

public void Realization(Human object, int damage, Troll Hemuliha) throws GodCanNotBeKilledException {
	if(object.getType()==Hum.GOD) {
		throw new GodCanNotBeKilledException();
	}
	GameOver();
	if (retribution()!=10) {
		
		if (object.getType() == Hum.valueOf("BAD") || (object.getType() == Hum.valueOf("NEUTRAL") && object.getLoc()==Location.valueOf("EARTH"))) {
			LostHP(damage);
		}
		else if (object.getType() == Hum.valueOf("TROLL")){
			System.out.println("Хемулиха не трогает троллей");
		}
		else {
			System.out.println("Хемулиха дарует жизнь хорошим людям");
		}
	}
	else {
		if(object.getType() == Hum.valueOf("TROLL")){
			System.out.println("Троля настигла божественная кара");
		}
		else {
			System.out.println("Человеку было подарено божественное спасение");
		}
		Random random = new Random();
		int diff = random.nextInt(50+1);
		Hemuliha.LostHP(diff);
	}
}

@Override
public int retribution() {
	Random random = new Random();
	int count = random.nextInt(10+1);
	return count;	
}
class Leader{
	public void SavePeople() {
		System.out.println("Появился сильный лидер. Под его началом люди перестали совершать зло. Они заключили мирный договор с Хемулихой, дабы последняя больше не террорезировала людей");
		System.exit(0);
	}
}
public static class Godlike{
	public void Godlike() {
		System.out.println("Дабы избежать гнева Хемулихи, люди стали поклоняться ей, превознося её к богам. Что же произойдёт дальше? Попробует ли Хемулиха свергнуть богов?...");
		System.exit(0);
	}
}

@Override
void GameOver() {
Random random = new Random();
if(random.nextInt(10+1)==5) {
	System.out.println("Люди взбунтовались против Хемулики и казнили её");
	System.exit(0);
}
else if(random.nextInt(10+1)==6) {
	Godlike godlike = new Godlike();
	godlike.Godlike();
}
else if (random.nextInt(10+1)==7) {
	Leader Greg = new Leader();
	Greg.SavePeople();
}
}





}

