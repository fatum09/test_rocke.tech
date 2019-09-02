package taskthree;

public class IncrementSynchronize {

    private int value = 0; //getNextValue();
    private Object objectForLock;

    private int getNextValue() {
        return value++;
    }

    public int getNextValueOne() {
        synchronized (this) {
            return getNextValue();
        }
    }

    public synchronized  int getNextValueTwo() {

        return getNextValue();

    }

    public int getNextValueThree() {
       synchronized (objectForLock){
          return getNextValue();
        }
    }
}
