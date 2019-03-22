package lab3;

public class GodCanNotBeKilledException extends Exception {
public void ChangeType (Human object) {
	if(object.getType()==Hum.GOD) {
		object.setType(Hum.NEUTRAL);
	}
}
}
