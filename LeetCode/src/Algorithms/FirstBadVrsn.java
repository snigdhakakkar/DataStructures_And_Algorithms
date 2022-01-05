package Algorithms;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class FirstBadVrsn extends VersionControl {
public int firstBadVersion(int n) {
  
  //checking for certain edge cases
  if (isBadVersion(1)) {
      return 1; //version 1 is bad
  }
  
 if (!isBadVersion(n)) {
      return -1; //none of the versions are bad
  } 
  int low = 1, high = n;
  
  while (low < high) {
      // To avoid integer overflow use high-low/2
      int mid = low + (high - low)/2;
      
      if (isBadVersion(mid)) {

          if (!isBadVersion(mid-1)) { //checking if mid-1 is a bad version 
              return mid;
          } else {
              high = mid;
          } 
          
      } else { //if mid is a good version, checking for mid+1
          
          if (isBadVersion(mid+1)) {
              return mid+1; 
          } else { 
              low = mid;
          }
      }
  }
  
return -2; 
}
}
