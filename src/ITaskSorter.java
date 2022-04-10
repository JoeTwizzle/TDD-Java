public interface ITaskSorter {
    boolean isWellSorted(String[] sequence);

    public void setOrder(String[][] order);

    public  String[][] getOrder(String[][] order);


}
