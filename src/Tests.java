import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {
    private TaskSorter taskSorter;

    @BeforeAll
    void InitTests() {
        taskSorter = new TaskSorter();
        taskSorter.setOrder(new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}});
    }

    @Test
    void TestNewOrder() {
        taskSorter.setOrder(new String[][]{{"B", "C"}, {"C", "A"}, {"B", "D"}, {"C", "E"}});
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"B", "D", "C", "A", "E"}));
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"B", "C", "D", "E", "A"}));
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"B", "C", "A", "D", "E"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"B", "D", "A", "C", "E"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"A", "B", "C", "D"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }

    @Test
    void TestTransitive() {
        taskSorter.setOrder(new String[][]{{"A", "B"}, {"B", "C"}});
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"C", "A"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"C", "C", "D", "A"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"A", "C"}));
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "B", "C"}));
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "C", "B"}));
    }

    @Test
    void TestRandom() {
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"Aadaadad"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"Aadaadad", "B", "A", "C", "D"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"B", "A", "C", "DDDDDD", "D"}));
    }

    @Test
    void TestCorrectOrder() {
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "C", "D"}));
        Assertions.assertTrue(taskSorter.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }

    @Test
    void TestIncorrectOrder() {
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"C", "B", "A", "D"}));
        Assertions.assertFalse(taskSorter.isWellSorted(new String[]{"D", "C", "B", "A"}));
    }
}
