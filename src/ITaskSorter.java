public interface ITaskSorter {
    boolean isWellSorted(String[] sequence);

    void setOrder(String[][] order);

    void getOrder(String[][] order);


}
