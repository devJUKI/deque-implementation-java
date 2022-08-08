import java.util.*;

public class KTUDeque<E> implements Deque<E> {
    private E[] array;
    private int front;
    private int rear;

    private int size = 0;

    public KTUDeque(int size) {
        front = rear = -1;
        array = (E[]) new Object[size];
    }

    // Visi deque metodai yra O(1) asimptotinio sudėtingumo

    // Debug
    public void printContent() {
        System.out.println("Front: " + front + " | Rear: " + rear);
        System.out.println();

        String toPrint = "";
        int frontLineLength = -1;
        int rearLineLength = -1;

        for (int i = 0; i < array.length; i++) {
            if (i == front)
                frontLineLength = toPrint.length() + 1;

            if (i == rear)
                rearLineLength = toPrint.length() + 1;

            if (array[i] == null)
                toPrint += "| null ";
            else
                toPrint += "| " + array[i] + " ";
        }
        toPrint += "|";

        String result = "";
        if (frontLineLength != -1)
            result = String.format("%" + frontLineLength + "s", "") + "Front";
        System.out.println(result);
        System.out.println(toPrint);
        if (rearLineLength != -1)
            result = String.format("%" + rearLineLength + "s", "") + "Rear";
        System.out.println(result);
    }

    @Override
    public void addFirst(E e) {
        if (e == null)
            throw new NullPointerException();

        if (size == array.length)
            resize();

        if (isEmpty())
            rear = array.length - 1;

        front = (front - 1) < 0 ? array.length - 1 : front - 1;
        array[front] = e;

        size++;
    }

    public void resize() {
        E[] tempArray = (E[]) new Object[array.length * 2];
        int i = 0;
        int j = front;

        do {
            tempArray[i++] = array[j];
            j = (j + 1) % array.length;
        } while (j != front);

        front = 0;
        rear = array.length - 1;
        array = tempArray;
    }

    @Override
    public void addLast(E e) {
        if (e == null)
            throw new NullPointerException();

        if (size == array.length)
            resize();

        if (isEmpty())
            front++;

        rear = (rear + 1) % array.length;
        array[rear] = e;
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        try {
            addFirst(e);
            return true;
        } catch (NullPointerException exception) {
            return false;
        }
    }

    @Override
    public boolean offerLast(E e) {
        try {
            addLast(e);
            return true;
        } catch (NullPointerException exception) {
            return false;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        E temp = array[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % array.length;
        size--;

        return temp;
    }

    @Override
    public E removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        E temp = array[rear];
        if (front == rear)
            front = rear = -1;
        else
            rear = (rear - 1) < 0 ? array.length - 1 : rear - 1;
        size--;

        return temp;
    }

    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return array[front];
    }

    @Override
    public E getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return array[rear];
    }

    @Override
    public E peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public E peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        int j = front;

        do {
            if (array[j] != null && array[j].equals(o)) {
                array[j] = null;

                if (size - 1 <= 0) {
                    rear = front = -1;
                    size--;
                    return true;
                }

                if (j == front)
                    findNewFront();

                if (j == rear)
                    findNewRear();

                size--;
                return true;
            }

            j = (j + 1) % array.length;
        } while (j != front);

        return false;
    }

    private void findNewRear() {
        int j = rear;

        do {
            if (array[j] != null) {
                rear = j;
                return;
            }

            j = (j - 1 < 0) ? array.length - 1 : j - 1;
        } while (j != rear);
    }

    private void findNewFront() {
        int j = front;

        do {
            if (array[j] != null) {
                front = j;
                return;
            }

            j = (j + 1) % array.length;
        } while (j != front);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        int j = rear;
        boolean didLast = false;

        do {
            if (j == front)
                didLast = true;

            if (array[j] != null && array[j].equals(o)) {
                array[j] = null;

                if (size - 1 <= 0) {
                    rear = front = -1;
                    size--;
                    return true;
                }

                if (j == front)
                    findNewFront();

                if (j == rear)
                    findNewRear();

                size--;
                return true;
            }

            j = (j - 1 < 0) ? array.length - 1 : j - 1;
        } while (!didLast);

        return false;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o))
            return removeFirstOccurrence(o);

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()) {
            if (!contains(e.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E value : c) add(value);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        boolean allSucceded = true;
        while (e.hasNext()) {
            E item = (E) e.next();
            if (!contains(item))
                allSucceded = false;
            else
                remove(item);
        }
        return allSucceded;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int j = rear;
        boolean didLast = false;

        do {
            if (j == front)
                didLast = true;

            if (array[j] != null && !c.contains(array[j])) {
                array[j] = null;
                size--;
            }

            j = (j - 1 < 0) ? array.length - 1 : j - 1;
        } while (!didLast);

        return true;
    }

    @Override
    public void clear() {
        front = rear = -1;
    }

    @Override
    public boolean contains(Object o) {
        int j = front;
        boolean didLast = false;

        do {
            if (j == rear)
                didLast = true;

            if (array[j] != null && array[j].equals(o))
                return true;

            j = (j + 1) % array.length;
        } while (!didLast);

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        private int cursor = front;
        private int end = rear;
        private int lastRet = -1;
        private boolean didLast = false;

        public boolean hasNext() {
            return !didLast;
        }

        public E next() {
            if (cursor == end)
                didLast = true;

            E result = array[cursor];

            lastRet = cursor;
            cursor = (cursor + 1) % array.length;

            return result;
        }

        public void remove() {
            removeFirstOccurrence(array[lastRet]);
        }
    }

    @Override
    public Object[] toArray() {
        E[] tempArray = (E[]) new Object[size];
        int i = 0;
        int j = front;
        boolean didLast = false;

        do {
            if (j == rear)
                didLast = true;

            if (array[j] != null)
                tempArray[i++] = array[j];

            j = (j + 1) % array.length;
        } while (!didLast);

        return tempArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());

        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator<E> {
        private int cursor = rear;
        private int beginning = front;
        private int lastRet = -1;
        private boolean didLast = false;

        public boolean hasNext() {
            return !didLast;
        }

        public E next() {
            if (cursor == beginning)
                didLast = true;

            E result = array[cursor];

            lastRet = cursor;
            cursor = (cursor - 1) & (array.length - 1);

            return result;
        }

        public void remove() {
            removeLastOccurrence(array[lastRet]);
        }
    }
}
