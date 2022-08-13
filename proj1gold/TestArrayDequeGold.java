import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        String message = "";
        Integer expected = 1;
        Integer actual = 1;
        for (int i = 0; i < 1000; i++) {
            if (solutionDeque.size() == 1) {
                Integer number = StdRandom.uniform(1000);
                int choice = StdRandom.uniform(2);
                if (choice == 0) {
                    message += "addFirst(" + number + ")\n";
                    solutionDeque.addFirst(number);
                    studentDeque.addFirst(number);
                }
                else {
                    message += "addLast(" + number + ")\n";
                    solutionDeque.addLast(number);
                    studentDeque.addLast(number);
                }
            }
            else {
                Integer number = StdRandom.uniform(1000);
                int choice = StdRandom.uniform(4);
                if (choice == 0) {
                    message += "addFirst(" + number + ")\n";
                    solutionDeque.addFirst(number);
                    studentDeque.addFirst(number);
                } else if (choice == 1) {
                    message += "addLast(" + number + ")\n";
                    solutionDeque.addLast(number);
                    studentDeque.addLast(number);
                } else if (choice == 2) {
                    message += "removeFirst()\n";
                    expected = solutionDeque.removeFirst();
                    actual = studentDeque.removeFirst();
                }
                else {
                    message += "removeLast()\n";
                    expected = solutionDeque.removeLast();
                    actual = solutionDeque.removeLast();
                }
                assertEquals(message, expected, actual);
            }
        }
    }
}
