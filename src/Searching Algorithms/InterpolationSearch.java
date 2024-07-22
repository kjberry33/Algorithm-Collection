//array implementation, iterative
public class InterpolationSearch {
    public static void main(String[] args){
        System.out.print("""
        [INTERPOLATION SEARCH]
        The sample data set is: {0.005, 1.69, 11.11, 12, 12.05, 35, 96.07}
        """);
        double[] data={0.005, 1.69, 11.11, 12, 12.05, 35, 96.07};
        double target=12.05;
        System.out.println("The target value is: "+target);
        InterpolationSearch Test=new InterpolationSearch();
        Test.intrplSearch(data,target);
    }
    InterpolationSearch(){

    }
    void intrplSearch(double[] data, double target){
        int left=0;
        int right=data.length-1;
        boolean found=false;
        while(target>=data[left] && target<=data[right] && left<=right) {
            int mid= (int) (left + (right - left) * (target - data[left]) / (data[right] - data[left]));
            if (data[mid] == target) {
                System.out.print("Target "+data[mid]+" is in the data set!");
                found=true;
                break;
            } else if (data[mid] < target) {
                left=mid+1;
            } else if(data[mid] > target){
                right=mid-1;
            }
        }
        if(!found) {
            System.out.print("Target is not found in the data set!");
        }
    }
}
