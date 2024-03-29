/**
 * The elevator which could go up and down, select the next floor to stop
 */



import java.util.TreeSet;

enum UpDownEnum {
	UP, DOWN;
}
public class ElevatorCabin {
    
    public int currentFloor = 0;
    public UpDownEnum direction = UpDownEnum.UP;
    public TreeSet<Integer> callingFloorList  = new TreeSet<Integer>();
     
    public void add(Integer floor){
        callingFloorList.add(floor);
    }
     
    public Integer gotoNext(){
        Integer nextFloor = currentFloor;
        switch(direction){
        case UP:
            for (Integer floor : callingFloorList) {
                if(floor > nextFloor){
                    nextFloor = floor;
                    direction = UpDownEnum.UP;
                    break;
                }
            }
             
            if(nextFloor == currentFloor){
                for (Integer floor : callingFloorList.descendingSet()) {
                    if(floor < nextFloor){
                        nextFloor = floor;
                        direction = UpDownEnum.DOWN;
                        break;
                    }
                }
            }
            break;
        case DOWN:
            for (Integer floor : callingFloorList.descendingSet()) {
                if(floor < nextFloor){
                    nextFloor = floor;
                    direction = UpDownEnum.DOWN;
                    break;
                }
            }
             
            if(nextFloor == currentFloor){
                for (Integer floor : callingFloorList) {
                    if(floor > nextFloor){
                        nextFloor = floor;
                        direction = UpDownEnum.UP;
                        break;
                    }
                }
            }
        }
        callingFloorList.remove(nextFloor);
        currentFloor = nextFloor;
        return nextFloor;
    }
}
