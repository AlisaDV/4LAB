package lab3;

import java.util.Random;

public class Troll extends Creatures implements retribution, LostOfHealth{
Hum Type;
Location location;
int hp;
public Troll(Hum type, Location loc, int hitpoints) throws NegativeHPException {
		if(hitpoints <= 0) {
			new NegativeHPException("������, �������� ������ ��� ����� ����");
		}
		Type = type;
		location=loc;
		hp=hitpoints;
}
public Hum getType() {
	return Type;
}
public int getHP() {
	return hp;
}

void GodRetribution(){
	System.out.println("������� ���� ������������ �� ��������");
};

@Override
public void LostHP(int diff) {
	hp=hp-diff;
	Troll God = new Troll(Hum.GOD, Location.EDEN, hp) {
		void GodRetribution(){
		System.out.println("�������� �������� ���� �� ����� ������ " + diff + ". � �� �������� " + hp + " ��������");
		}
	};
	God.GodRetribution();
	if (hp<=0 || retribution()==100) {
		GameOver();
	}
}

@Override
public void GameOver() {
	class Unicorn{
		String name;
		String move;
		Unicorn(String name, String move) {
			this.name=name;
			this.move=move;
		}
		private String getName() {
			return name;
		}
		private String getMove() {
			return move;
		}
		Unicorn Jellal = new Unicorn("������", "������� ��������");
		void KillHem() {
			System.out.println("���������� " + Jellal.getName() + ", ��������� ������, " + Jellal.getMove());
		}
	}
	System.exit(0);
}



@Override
public int retribution() {
	Random random = new Random();
	int count = random.nextInt(100+1);
	return count;
	
}




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Type == null) ? 0 : Type.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	return true;
}
@Override
public String toString() {
	return "Troll [Type=" + Type + "]";
}







}
