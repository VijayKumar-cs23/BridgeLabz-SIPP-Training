package Day3_SortingAlgorithms;

import java.util.Scanner;

public class QuickSortProductPrices {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] prices = new double[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }
        quickSort(prices, 0, n - 1);
        for (double price : prices) {
            System.out.print(price + " ");
        }
        sc.close();
    }
}
