package wf;

public class TrainComposition {
    public void attachWagonFromLeft(int wagonId) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void attachWagonFromRight(int wagonId) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromLeft() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}