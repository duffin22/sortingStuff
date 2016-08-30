/**
 * Created by matthewtduffin on 06/07/2016.
 */
public class Main {
  public static void main(String[] args) {
    int[] ints = new int[]{0,-1,2,5,7,5,8,9,235,6,45,5,457,4357,5846,4568,45,345};
    int[] ints1 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] ints2 = new int[]{1};
    int[] ints3 = new int[]{};
    int[] ints4 = new int[]{1, 5, 4, 2};
    int[] ints5 = new int[]{1, 2, 3, 4, 6, 5};
    int[] ints6 = new int[]{1234, 1234, 12345};
    int[] unsorted = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
    System.out.println();
    int[] mergedList = mergeSort(ints);

    printIntArray(mergedList);

//    int size = 10000;
//    int[] randomInts = new int[size];
//    for (int i=0; i<size; i++) {
//      randomInts[i] = (int) (Math.random()*1000000);
//    }
//
//    int[] randomInts2 = randomInts.clone();

//    int[] insert = insertionSort(randomInts);
//    int[] bubble = bubbleSort(randomInts2);
//    System.out.println();
//    printIntArray(insert);
//    printIntArray(bubble);
  }

  public static int[] mergeSort(int[] array) {
    if (array.length < 2) {
      return array;
    }

    int size2 = array.length / 2;
    int size1 = array.length - size2;

    int[] firstArray = new int[size1];
    int[] secondArray = new int[size2];

    for (int i = 0; i < array.length; i++) {
      if (i < size1) {
        firstArray[i] = array[i];
      } else {
        secondArray[i - size1] = array[i];
      }
    }

    int[] firstList = mergeSort(firstArray);
    int[] secondList = mergeSort(secondArray);

    int[] returnStuff = merge(firstList,secondList);
    return returnStuff;

  }

  public static int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int count = 0;

    while (a.length > 0 || b.length > 0) {
      if (a.length == 0) {
        c[count] = b[0];
        int[] newB = new int[b.length - 1];
        for (int i = 0; i < b.length - 1; i++) {
          newB[i] = b[i + 1];
        }
        b = newB;
      } else if (b.length == 0) {
        c[count] = a[0];
        int[] newA = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
          newA[i] = a[i + 1];
        }
        a = newA;
      } else {
        if (a[0] < b[0]) {
          c[count] = a[0];
          int[] newA = new int[a.length - 1];
          for (int i = 0; i < a.length - 1; i++) {
            newA[i] = a[i + 1];
          }
          a = newA;
        } else {
          c[count] = b[0];
          int[] newB = new int[b.length - 1];
          for (int i = 0; i < b.length - 1; i++) {
            newB[i] = b[i + 1];
          }
          b = newB;
        }
      }
      count++;
    }

  return c;

  }


//  public static int[] mergeSort2(int[] array) {
//    if (array.length < 2) {
//      return array;
//    }
//
//    int[][] arrays = split(array);
//
//    return mergeArrays(mergeSort2(arrays[0]), mergeSort2(arrays[1]));
//
//  }

//  public static int[][] split(int[] original) {
//    if (original.length < 2) {
//      int[][] returnVal = new int[][] {original, new int[] {}};
//      return returnVal;
//    }
//    int size1 = (int) (original.length/2);
//    int size2 = original.length - size1;
//
//    int[] firstArray = new int[size1];
//    int[] secondArray = new int[size2];
//
//    for (int i=0; i<original.length; i++) {
//      if (i < size1) {
//        firstArray[i] = original[i];
//      } else {
//        secondArray[i-size1] = original[i];
//      }
//    }
//    return new int[][] {firstArray, secondArray};
//
//  }

//  public static int[] mergeArrays(int[] a, int[] b) {
//    if (a.length == 0) {
//      return b;
//    }
//    if (b.length == 0) {
//      return a;
//    }
//
//    if (a.length == 1 && b.length == 1) {
//      return new int[] {a[0], b[0]};
//    }
//
//    if (a[0] < b[0]) {
//      int[] newArray = new int[] {a[0]};
//      int[] otherNewArray = new int[a.length-1];
//      for (int i=1; i < a.length; i++) {
//        otherNewArray[i-1] = a[i];
//      }
//      return mergeArrays(newArray, mergeArrays(otherNewArray,b));
//    } else {
//      int[] newArray = new int[] {b[0]};
//      int[] otherNewArray = new int[b.length-1];
//      for (int i=1; i < b.length; i++) {
//        otherNewArray[i-1] = b[i];
//      }
//      return mergeArrays(newArray, mergeArrays(a,otherNewArray));
//    }
//  }



  public static int[] insertionSort(int[] array) {
    long millis = System.currentTimeMillis();
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j]<array[j-1]) {
          int k = array[j];
          array[j]=array[j-1];
          array[j-1] = k;
        }
      }
    }
    String s = "Time taken for insert: "+(System.currentTimeMillis()-millis);
    System.out.println(s);
    return array;
  }


  public static int[] bubbleSort(int[] array) {
    long millis = System.currentTimeMillis();
    for (int i = 0; i < array.length; i++) {
      boolean hasChangeBeenMade = false;
      for (int j = 0; j < array.length-1; j++) {
        if (array[j]>array[j+1]) {
          hasChangeBeenMade = true;
          int k = array[j];
          array[j]=array[j+1];
          array[j+1] = k;
        }
      }
      if (!hasChangeBeenMade) {
        String s = "Time taken for bubble: "+(System.currentTimeMillis()-millis);
        System.out.println(s);
        return array;
      }
    }
    String s = "Time taken for bubble: "+(System.currentTimeMillis()-millis);
    System.out.println(s);
    return array;
  }

  public static void printIntArray(int[] array) {
    System.out.print("{");
    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        String s = ""+array[i];
        System.out.print(s);
      } else {
        String s = ""+array[i];
        System.out.print(s + ",");
      }
    }
    System.out.println("}");
  }


}
