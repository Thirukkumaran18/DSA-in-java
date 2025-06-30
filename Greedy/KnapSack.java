import java.util.*;

class Main {
    static class Item {
        double ratio;
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;

        // Step 1: Create array of items with value, weight, and ratio
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        // Step 2: Sort items by descending ratio (value per weight)
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        // Step 3: Greedily add items (or fraction) into the knapsack
        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                // Take whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take fractional part
                totalValue += item.ratio * capacity;
                capacity = 0;
            }
        }

        // Step 4: Round to 6 decimal places and return
        return Math.round(totalValue * 1e6) / 1e6;
    }

    // Example usage
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        double result = fractionalKnapsack(values, weights, capacity);
        System.out.printf("Maximum value = %.6f\n", result);  // Output: 240.000000
    }
}
