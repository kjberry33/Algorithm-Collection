public class InsertionSort {
    public static void main(String[] args){
        System.out.println("""
        [INSERTION SORT]
        The sample data set is: {1.69, 96.07, 0.005, 12, 35, 11.11, 12.05}
        """);
        double[] data={1.69, 96.07, 0.005, 12, 35, 11.11, 12.05};
        InsertionSort Test=new InsertionSort(data);
    }
    InsertionSort(double[] data){
        data=inSort(data);
        System.out.print("The sorted data set is: ");
        printArray(data);
    }
    double[] inSort(double[] data){
        for(int i=0;i< data.length;i++){
            double temp=data[i];
            int j=i-1;
            while(j>=0 && data[j]>temp){
                data[j+1]=data[j];
                j=j-1;
            }
            data[j+1]=temp;
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
