package travel_route;

public class QuickSort {

  public int partition(int[] list, int left, int right) {
    int pivot, temp;
    int low, high;

    low = left;
    high = right + 1;
    pivot = list[left];

    do {
      do {
        low++;
      } while (low <= right && list[low] < pivot);

      do {
        high--;
      } while (high >= left && list[high] > pivot);

      if (low < high) {
        temp = list[low];
        list[low] = list[high];
        list[high] = temp;
      }
    } while (low < high);

    return high;
  }

  public void sort(int list[], int left, int right) {
    if (left < right) {
      int q = partition(list, left, right);

      sort(list, left, q - 1);
      sort(list, q + 1, right);
    }
  }

}
