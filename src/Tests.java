import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {
    private TaskSorter taskSorter;

    @BeforeEach
    void InitTests() {
        taskSorter = new TaskSorter();
        taskSorter.setOrder(new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}});
    }

    @Test
    void TestNewOrder() {
        taskSorter.setOrder(new String[][]{{"B", "C"}, {"C", "A"}, {"B", "D"}, {"C", "E"}});
        assertTrue(taskSorter.isWellSorted(new String[]{"B", "D", "C", "A", "E"}));
        assertTrue(taskSorter.isWellSorted(new String[]{"B", "C", "D", "E", "A"}));
        assertTrue(taskSorter.isWellSorted(new String[]{"B", "C", "A", "D", "E"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"B", "D", "A", "C", "E"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"A", "B", "C", "D"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }

    @Test
    void TestTransitive() {
        taskSorter.setOrder(new String[][]{{"A", "B"}, {"B", "C"}});
        assertFalse(taskSorter.isWellSorted(new String[]{"C", "A"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"C", "C", "D", "A"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"A", "C"}));
        assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "B", "C"}));
        assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "C", "B"}));
    }

    @Test
    void TestRandom() {
        assertFalse(taskSorter.isWellSorted(new String[]{"Aadaadad"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"Aadaadad", "B", "A", "C", "D"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"B", "A", "C", "DDDDDD", "D"}));
    }

    @Test
    void TestCorrectOrder() {
        assertTrue(taskSorter.isWellSorted(new String[]{"A", "B", "C", "D"}));
        assertTrue(taskSorter.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }

    @Test
    void TestIncorrectOrder() {
        assertFalse(taskSorter.isWellSorted(new String[]{"C", "B", "A", "D"}));
        assertFalse(taskSorter.isWellSorted(new String[]{"D", "C", "B", "A"}));
    }
}
