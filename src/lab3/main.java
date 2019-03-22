package lab3;

import java.util.Random;

public class main {
	
	public static void main(String[] args) {		
		Human[] humans = new Human[50];
		int min = 100;
		int max = 600;
		int diff = max - min;
		Hum[] TypeArray = Hum.values();
		Location[] LocArray = Location.values();
		Troll Hemuliha = new Troll(TypeArray[3], LocArray[0], 150);
		Hemuliha.GodRetribution();
		for (int i=0; i<10; i++){
			Random random = new Random();
			int countType = random.nextInt(3+1);
			int countLoc = random.nextInt(1+1);
			int countHP = random.nextInt(diff + 1);
			countHP += min;
			humans[i] = new Human(TypeArray[countType], LocArray[countLoc], countHP);				
		}
			for (int i=0; i<10; i++){
				Random random = new Random();
				int countDamage = random.nextInt(diff+1);
				try {
					humans[i].Realization(humans[i], countDamage, Hemuliha);
				}
				catch (GodCanNotBeKilledException e){
					e.ChangeType(humans[i]);
				}
			}
			System.out.println("Благодаря Хемулихи мир избавился от плохих людей");
	}
}