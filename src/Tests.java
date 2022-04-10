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
    void TestRandom() {
        Assertions.assertFalse(program.isWellSorted(new String[]{"Aadaadad"}));
    }
    @Test
    void TestCorrectOrder(){
        Assertions.assertTrue(program.isWellSorted(new String[]{"A", "B", "C", "D"}));
        Assertions.assertTrue(program.isWellSorted(new String[]{"B", "A", "C", "D"}));
    }
    @Test
    void TestIncorrectOrder(){
        Assertions.assertFalse(program.isWellSorted(new String[]{"C", "B", "A",  "D"}));
        Assertions.assertFalse(program.isWellSorted(new String[]{"D", "C", "B", "A"}));
    }
}
