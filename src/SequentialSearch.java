//iterative, array implementation
public class SequentialSearch {
    public static void main(String[] args){
        System.out.print("""
        [SEQUENTIAL SEARCH]
        The sample data set is: {0.005, 1.69, 11.11, 12, 12.05, 35, 96.07}
        """);
        double[] data={0.005, 1.69, 11.11, 12, 12.05, 35, 96.07};
        double target=12.05;
        System.out.println("The target value is: "+target);
        SequentialSearch Test=new SequentialSearch();
        Test.sqntlSearch(data,target);
    }
    SequentialSearch(){
        //default constructor
    }
    void sqntlSearch(double[] data,double target){
        boolean found=false;
        for(int i=0;i< data.length;i++){
            if(data[i]==target){
                System.out.print("Target "+target+" is found at index "+i);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Target "+target+" not found in the data set.");
        }
    }
}
