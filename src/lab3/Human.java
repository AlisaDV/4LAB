package lab3;

import java.util.Random;

public class Human extends Creatures implements LostOfHealth, retribution{
Hum Type;
Location location;
int hp;
public Human (Hum type, Location str, int l) throws NegativeHPException {
	if(l <= 0) {
		new NegativeHPException("������, �������� ������ ��� ����� ����");
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
		System.out.println("������� ����");
	}
	else {
		System.out.println("�����. �������� " + hp + " ��������");
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
			System.out.println("�������� �� ������� �������");
		}
		else {
			System.out.println("�������� ������ ����� ������� �����");
		}
	}
	else {
		if(object.getType() == Hum.valueOf("TROLL")){
			System.out.println("����� �������� ������������ ����");
		}
		else {
			System.out.println("�������� ���� �������� ������������ ��������");
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
		System.out.println("�������� ������� �����. ��� ��� ������� ���� ��������� ��������� ���. ��� ��������� ������ ������� � ���������, ���� ��������� ������ �� ��������������� �����");
		System.exit(0);
	}
}
public static class Godlike{
	public void Godlike() {
		System.out.println("���� �������� ����� ��������, ���� ����� ����������� ��, ���������� � � �����. ��� �� ��������� ������? ��������� �� �������� ��������� �����?...");
		System.exit(0);
	}
}

@Override
void GameOver() {
Random random = new Random();
if(random.nextInt(10+1)==5) {
	System.out.println("���� ������������� ������ �������� � ������� �");
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

