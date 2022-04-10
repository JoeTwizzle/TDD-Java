public interface ITaskSorter {
    boolean isWellSorted(String[] sequence);

    void setOrder(String[][] order);

    String[][] getOrder();
    
}
