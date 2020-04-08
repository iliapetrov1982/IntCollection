import java.util.*;

public class IntCollection extends AbstractList<Integer>{
    Integer[] elementData;
    private int size;
    private static final Integer[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    IntCollection() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // add to the end
    @Override
    public boolean add(Integer e) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                elementData[i] = elementData[i] + e;
            }
        }
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    //remove by index
    @Override
    public Integer remove(int index) {
        Objects.checkIndex(index, size);
        int e = elementData[index];
        for (int i = 0; i < size; i++) {
            elementData[i] = elementData[i] - e;
        }
        System.out.println("ind ok");
        final Object[] es = elementData;
        Integer oldValue = (Integer) es[index];
        fastRemove(es, index);
        return oldValue;
    }

    // seach by index
    @Override
    public Integer get(int index) {
        return elementData[index];
    }

    // max search
    public int getMax() {
        int max = elementData[0];
        for (int i = 0; i < size; i++) {
            max = max > elementData[i] ? max : elementData[i];
        }
        return max;
    }

    // min search
    public int getMin() {
        int min = elementData[0];
        for (int i = 0; i < size; i++) {
            min = min < elementData[i] ? min : elementData[i];
        }
        return min;
    }

    // mean count
    public float countMean() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            count++;
            sum = sum + elementData[i];
        }
        return (float) sum / count;
    }

    @Override
    public String toString() {
        return "IntCollection{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
}