//iterative, array implementation
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("""
        [BUBBLE SORT]
        The sample data set is: {1.69, 96.07, 0.005, 12, 35, 11.11, 12.05}
        """);
        double[] data={1.69, 96.07, 0.005, 12, 35, 11.11, 12.05};
        BubbleSort Test=new BubbleSort();
        System.out.print("The sorted data set is: ");
        Test.printArray(Test.bblsort(data));
    }
    BubbleSort(){
        //default constructor
    }
    double[] bblsort(double[] data){
        for(int i=0;i<data.length-1;i++){
            for(int j=data.length-1;j>i;j--){
                if(data[j]>data[j-1]){
                    double temp=data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                }
            }
        }
        return data;
    }
    void printArray(double[] data){
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