import java.util.Iterator;

public class DequeTests {
    public static void main(String[] args) {
        KTUDeque<Integer> deque = new KTUDeque(8);
        deque.addFirst(7);
        deque.addFirst(15);
        deque.addFirst(8);
        deque.addFirst(17);
        deque.addFirst(17);
        deque.addFirst(17);
        deque.addFirst(17);
        deque.addFirst(56);

        new VisualHelper("Pradinis dekas");
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas perpildymas");
        VisualHelper.print("Pridedame: " + 4);
        deque.addFirst(4);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas addLast()");
        VisualHelper.print("Pridedame: " + 12);
        VisualHelper.print("Pridedame: " + 42);
        deque.addLast(12);
        deque.addLast(42);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas offerFirst()");
        VisualHelper.print("Pridedame: " + 79);
        VisualHelper.print("Pridedame: " + 84);
        deque.offerFirst(79);
        deque.offerFirst(84);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas offerLast()");
        VisualHelper.print("Pridedame: " + 48);
        VisualHelper.print("Pridedame: " + 71);
        deque.offerLast(48);
        deque.offerLast(71);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas removeFirst()");
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeFirst());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeFirst());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeFirst());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas removeLast()");
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeLast());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeLast());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.removeLast());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas pollFirst()");
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollFirst());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollFirst());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollFirst());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas pollLast()");
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollLast());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollLast());
        VisualHelper.print("Atliekame šalinimą. Ištrintas elementas: " + deque.pollLast());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas add()");
        VisualHelper.print("Pridedame " + 4);
        VisualHelper.print("Pridedame " + 15);
        VisualHelper.print("Pridedame " + 15);
        deque.add(4);
        deque.add(15);
        deque.add(15);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas offer()");
        VisualHelper.print("Pridedame: " + 45);
        VisualHelper.print("Pridedame: " + 45);
        VisualHelper.print("Pridedame: " + 19);
        deque.offer(45);
        deque.offer(45);
        deque.offer(19);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas getFirst()");
        VisualHelper.print("Gautas elementas: " + deque.getFirst());
        VisualHelper.printLine();

        new VisualHelper("Testuojamas getLast()");
        VisualHelper.print("Gautas elementas: " + deque.getLast());
        VisualHelper.printLine();

        new VisualHelper("Testuojamas peekFirst()");
        VisualHelper.print("Gautas elementas: " + deque.peekFirst());
        VisualHelper.printLine();

        new VisualHelper("Testuojamas peekLast()");
        VisualHelper.print("Gautas elementas: " + deque.peekLast());
        VisualHelper.printLine();

        new VisualHelper("Testuojamas removeFirstOccurrence()");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + 45);
        deque.removeFirstOccurrence(45);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas removeLastOccurrence()");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + 15);
        deque.removeLastOccurrence(15);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas remove()");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + deque.remove());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas poll()");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + deque.poll());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas element()");
        VisualHelper.print("Gautas elementas: " + deque.element());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas peek()");
        VisualHelper.print("Gautas elementas: " + deque.peek());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas push()");
        VisualHelper.print("Pridedame: " + 52);
        deque.push(52);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas pop()");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + deque.pop());
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas remove(Object o)");
        VisualHelper.print("Atliekame šalinimą. Pašalintas elementas: " + 19);
        deque.remove(19);
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas containsAll() (tikimasi true)");
        KTUDeque<Integer> testDeque = new KTUDeque<>(3);
        testDeque.add(8);
        testDeque.add(45);
        testDeque.add(15);
        VisualHelper.print("Testuojamas dekas");
        testDeque.printContent();
        VisualHelper.print("Rezultatas: " + deque.containsAll(testDeque));
        VisualHelper.printLine();

        new VisualHelper("Testuojamas containsAll() (tikimasi false)");
        KTUDeque<Integer> testDeque2 = new KTUDeque<>(3);
        testDeque2.add(8);
        testDeque2.add(64);
        testDeque2.add(15);
        VisualHelper.print("Testuojamas dekas");
        testDeque2.printContent();
        VisualHelper.print("Rezultatas: " + deque.containsAll(testDeque2));
        VisualHelper.printLine();

        new VisualHelper("Testuojamas addAll()");
        KTUDeque<Integer> testDeque3 = new KTUDeque<>(3);
        testDeque3.add(31);
        testDeque3.add(62);
        testDeque3.add(71);
        VisualHelper.print("Testuojamas dekas");
        testDeque3.printContent();
        deque.addAll(testDeque3);
        VisualHelper.print("Rezultatas: ");
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas removeAll()");
        KTUDeque<Integer> testDeque4 = new KTUDeque<>(3);
        testDeque4.add(4);
        testDeque4.add(15);
        testDeque4.add(45);
        VisualHelper.print("Testuojamas dekas");
        testDeque4.printContent();
        deque.removeAll(testDeque4);
        VisualHelper.print("Rezultatas: ");
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas retainAll()");
        KTUDeque<Integer> testDeque5 = new KTUDeque<>(3);
        testDeque5.add(45);
        testDeque5.add(62);
        testDeque5.add(71);
        VisualHelper.print("Testuojamas dekas");
        testDeque5.printContent();
        deque.retainAll(testDeque5);
        VisualHelper.print("Rezultatas: ");
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas contains() (tikimasi false)");
        VisualHelper.print("Tikrinamas elementas: " + 45);
        VisualHelper.print("Rezultatas: " + deque.contains(45));
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas contains() (tikimasi true)");
        VisualHelper.print("Tikrinamas elementas: " + 71);
        VisualHelper.print("Rezultatas: " + deque.contains(71));
        deque.printContent();
        VisualHelper.printLine();

        new VisualHelper("Testuojamas iteratorius ir iteratoriaus remove()");
        deque.addFirst(19);
        deque.addFirst(20);
        deque.addFirst(21);
        deque.addFirst(22);
        deque.addFirst(23);
        deque.addFirst(24);
        deque.addFirst(25);
        VisualHelper.print("Tikrinamas dekas: ");
        deque.printContent();

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            Integer item = (Integer) iterator.next();
            if (item != null)
                iterator.remove();
        }

        deque.printContent();
        VisualHelper.printLine();
    }

    private static class VisualHelper {
        private static int headerMessageLength;

        VisualHelper(String header) {
            String finalHeader = "-------------------- " + header + " --------------------";
            print(finalHeader);
            headerMessageLength = finalHeader.length();
        }

        public static void print(String message) {
            System.out.println(message);
        }

        public static void printLine() {
            String result = String.format("%" + headerMessageLength + "s", "").replace(' ', '-');
            System.out.println(result);
            print("");
        }
    }
}
