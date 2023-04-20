public class InventoryManager {
    private int index;
    public InventoryManager() {
        index = 0;
    }
    public int giveId() {
        int currentIndex = index;
        ++index;
        return currentIndex;
    }
}
