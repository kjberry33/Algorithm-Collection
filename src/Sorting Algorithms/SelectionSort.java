public class SelectionSort {
    public static void main(String[] args){
        System.out.println("""
        [SELECTION SORT]
        The sample data set is: {1.69, 96.07, 0.005, 12, 35, 11.11, 12.05}
        """);
        double[] data={1.69, 96.07, 0.005, 12, 35, 11.11, 12.05};
        SelectionSort Test=new SelectionSort();
        System.out.print("The sorted data set is: ");
        Test.printArray(Test.selSort(data));
    }
    SelectionSort(){
        //default constructor
    }
    double[] selSort(double[] data){
        for(int i=0;i< data.length;i++){
            for(int j=i+1;j< data.length;j++){
                if(data[i]>data[j]){
                    double temp=data[j];
                    data[j]=data[i];
                    data[i]=temp;
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
