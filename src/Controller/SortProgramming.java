package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;

public class SortProgramming extends Menu<String> {

    static String[] mc = {"Sort", "Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SortProgramming(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                sort();
                break;
            case 2:
                search();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void sort() {
    final String[] mcSort = {"Bubble Sort", "Quick Sort", "Exit"};
    class SortMenu extends Menu<String> {
        public SortMenu() {
            super("Sort Option", mcSort);
        }

        @Override
        public void execute(int n) {
            System.out.println("Unsorted array: ");
            library.display(array);
            switch (n) {
                case 1:
                    algorithm.bubbleSort(array); 
                    System.out.println("\nSorted array by Bubble Sort: ");
                    library.display(array);
                    System.out.println("");
                    break;
                case 2:
                    algorithm.quickSort(array, 0, size_array - 1);
                    System.out.println("\nSorted array by Quick Sort: ");
                    library.display(array);
                    System.out.println("");
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    SortMenu sm = new SortMenu();
    sm.run();
}


    public void search() {
    final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
    class SearchMenu extends Menu<String> {
        public SearchMenu() {
            super("Search Option", mcSearch);
        }

        @Override
        public synchronized void execute(int n) {
            int value = library.getInt("\nEnter number to find: ", 1, 100);
            switch (n) {
                case 1:
                    int index = linearSearch(array, value);
                    if (index != -1) {
                        System.out.println("Found value: " + value + " at index: " + index);
                    } else {
                        System.out.println("Value not found in the array.");
                    }
                    break;
                case 2:
                    index = algorithm.binarySearch(array, value);
                    if (index != -1) {
                        System.out.println("Found value: " + value + " at index: " + index);
                    } else {
                        System.out.println("Value not found in the array.");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    SearchMenu sm = new SearchMenu();
    sm.run();
}

// Phương thức tìm kiếm tuyến tính
public int linearSearch(int[] array, int value) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == value) {
            return i; // Trả về chỉ số nếu tìm thấy
        }
    }
    return -1; // Trả về -1 nếu không tìm thấy
}
}
