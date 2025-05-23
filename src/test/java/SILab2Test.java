import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {
        // Тест 1: allItems == null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // Тест 2: item.name == null
        List<Item> list2 = List.of(new Item(null, 1, 100, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(list2, "1234567812345678"));
        assertEquals("Invalid item!", ex2.getMessage());

        // Тест 3: item без попуст
        List<Item> list3 = List.of(new Item("Milk", 1, 100, 0));
        double result3 = SILab2.checkCart(list3, "1234567812345678");
        assertEquals(100, result3);

        // Тест 4: item со попуст и -30
        List<Item> list4 = List.of(new Item("Bread", 11, 400, 0.1));
        double result4 = SILab2.checkCart(list4, "1234567812345678");
        assertEquals(3960 - 30, result4);
    }

    @Test
    void testMultipleCondition() {
        // Тестови според 5-те одговори што ги пишавме

        // A=false, B=false, C=false → no penalty
        List<Item> list1 = List.of(new Item("Item1", 1, 100, 0));
        assertEquals(100, SILab2.checkCart(list1, "1234567812345678"));

        // A=true, B=false, C=false
        List<Item> list2 = List.of(new Item("Item2", 1, 400, 0));
        assertEquals(400 - 30, SILab2.checkCart(list2, "1234567812345678"));

        // A=false, B=true, C=false
        List<Item> list3 = List.of(new Item("Item3", 1, 100, 0.5));
        assertEquals(50 - 30, SILab2.checkCart(list3, "1234567812345678"));

        // A=false, B=false, C=true
        List<Item> list4 = List.of(new Item("Item4", 20, 100, 0));
        assertEquals(2000 - 30, SILab2.checkCart(list4, "1234567812345678"));

        // A=true, B=true, C=true
        List<Item> list5 = List.of(new Item("Item5", 20, 400, 0.25));
        assertEquals((400 * 0.75 * 20) - 30, SILab2.checkCart(list5, "1234567812345678"));
    }
}
