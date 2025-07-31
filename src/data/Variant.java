package data;

import java.util.Objects;

public class Variant implements Comparable<Variant> {
    private int value;
    private int index;

    public Variant(int index, int value) {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Variant other) {
        if (this.value != other.value) {
            return Integer.compare(this.value, other.value);  // Сначала по value (возрастание)
        }
        return Integer.compare(other.index, this.index);     // Если value равны, по index (убывание)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Variant that = (Variant) o;
        return value == that.value && index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, index);
    }
}
