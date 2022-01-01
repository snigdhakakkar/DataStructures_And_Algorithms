package array;

public class DuplicateZeros {
	static int[] duplicateZeros(int[] arr) {
        int[] duparr = new int[arr.length];
        int pos = 0;
        for(int i=0; i<arr.length; i++){
            if(pos < arr.length) {
                if(arr[i] == 0){
                	if(arr.length - pos >= 2) {
                    duparr[pos++] = 0;
                    duparr[pos++] = 0;
                	} 
                	else {
                	duparr[pos++] = 0;
                	}
                }
                else {
                    duparr[pos++] = arr[i];
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
        arr[i] = duparr[i];
    }
        return arr;
}
	
public static void main(String[] args) {
	int arr[] = {0,0,0,0,0,0,0};
	int result[] = duplicateZeros(arr);
	for(int n : result) {
		System.out.println(n);
	}
}


}
