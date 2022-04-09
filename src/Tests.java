import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {
    private Program program;

    @BeforeAll
    void InitTests() {
        program = new Program();
    }

    @Test
    void TestSorting() {
        Assertions.assertTrue(program.isWellSorted(new String[]{"A", "B", "C", "D"}));

        Assertions.assertFalse(program.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }
}
