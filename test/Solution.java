import java.util.Collections;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args){
        int[] nums1 = new int[20];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 4;
        int[] nums2 = {1 ,2, 3, 5, 6, 7, 11};
        int[] result = merge(nums1, 3, nums2, 7);
        for(int i = 0 ; i < 10; i++){
            System.out.println(result[i]);
        }
    }
    
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int[] result = new int[ m + n ];// create a array result, same size as num1
        
        int i = 0, j = 0, k = 0;// initialize i to traverse num1 and j to traverse num2
        
        while( i < m && j < n){
        
            result[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        
        if( i == m && j < n ){ //concat remaining num2 to result
            for( int x = j; x < n; x++, k++ ){
                result[k] = nums2[x];
            }
        }
        
        if( j == n && j < m ){
            for( int x = i; x < m; x++, k++ ){
                result[k] = nums1[x];
            }
        }
        
        for( int x = 0; x < m+n; x++ ){
                nums1[x] = result[x];
        }
        return nums1;
    }

    
}
