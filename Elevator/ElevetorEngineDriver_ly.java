/**
 * interface of elevator system with people
 */ 
public class ElevetorEngineDriver {
	public static void main(String[] args) {
        ElevatorEngine engine = new ElevatorEngine();
        engine.startEngine();
         
        engine.pressButton(1);
        sleep();
        engine.pressButton(5);
        sleep();
        engine.pressButton(6);
        engine.pressButton(1);
        engine.pressButton(4);
        sleep();sleep();
        engine.pressButton(2);
        engine.pressButton(9);
        engine.pressButton(1);
        sleep();
        engine.stopEngine();
        try {
            engine.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
    public static void sleep(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
