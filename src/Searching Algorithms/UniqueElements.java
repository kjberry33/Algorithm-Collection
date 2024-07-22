//array implementation, iterative, utilizes Array package
import java.util.ArrayList;
import java.util.Arrays;
public class UniqueElements {
    public static void main(String[] args){
        System.out.println("[UNIQUE ELEMENTS]");
        int[] list1={1,2,4,7,8};
        int[] list2={0,2,3,4,7,8,10};
        System.out.print("The list are \nlist 1: ");printArray(list1);
        System.out.print("\nlist 2: ");printArray(list2);
        int[] unique=uniqueElementFinder(list1,list2);
        System.out.print("\nThe unique element subset list is: ");printArray(unique);
    }
    static int[] uniqueElementFinder(int[] list1, int[] list2){
        int[] allElements=combineArray(list1,list2);
        Arrays.sort(allElements);
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < allElements.length; i++) {
            if ((i==0 || allElements[i]!=allElements[i-1]) && (i == allElements.length - 1 || allElements[i] != allElements[i + 1])){
                uniqueList.add(allElements[i]);
            }
        }
        int[] uniqueArray = new int[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            uniqueArray[i] = uniqueList.get(i);
        }
        return uniqueArray;
    }
    static int[] combineArray(int[] one,int[] two){
        int[] elements=new int [one.length+two.length];
        for(int i=0;i<elements.length;i++){
            if(i<one.length){
                elements[i]=one[i];
            }else{
                elements[i]=two[i-one.length];
            }
        }
        return elements;
    }
    static void printArray(int[] data){
        for(int i=0;i< data.length;i++){
            if(i==0){
                System.out.print("{"+data[i]+", ");
            } else if (i<data.length-1) {
                System.out.print(data[i]+", ");
            }else{
                System.out.print(data[i]+"}");
            }
        }
    }
}
