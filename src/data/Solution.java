package data;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<Variant> minHeap;

    public Solution() {
        minHeap = new PriorityQueue<>();
    }

    public void addVariant(Variant variant) {
        if (variant.getValue() == 0) {
            return; // Пропускаем нули
        }

        Variant current = new Variant(variant.getIndex(), variant.getValue());

        if (minHeap.size() < 10) {
            minHeap.add(current);
        } else if (current.compareTo(minHeap.peek()) > 0) {
            minHeap.poll(); // Удаляем минимальный элемент
            minHeap.add(current);
        }
    }

    public List<Variant> getResult() {
        List<Variant> result = new ArrayList<>(minHeap);
        result.sort((a, b) -> {
            var valueA = a.getValue();
            var valueB = b.getValue();

            if (valueA != valueB) {
                return Integer.compare(valueB, valueA);  // По value (убывание)
            }

            return Integer.compare(a.getIndex(), b.getIndex());       // По index (возрастание)
        });

        return result;
    }
}
