package test;

import data.Variant;

import java.util.List;
import java.util.Objects;

public class ListComparator {
    public static boolean areListsEqual(List<Variant> list1, List<Variant> list2) {
        // Проверка на null и размер
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }

        // Поэлементное сравнение
        for (int i = 0; i < list1.size(); i++) {
            Variant elem1 = list1.get(i);
            Variant elem2 = list2.get(i);

            // Если compareTo возвращает не 0 или объекты разные
            if (elem1.compareTo(elem2) != 0 || !Objects.equals(elem1, elem2)) {
                return false;
            }
        }

        return true;
    }
}
