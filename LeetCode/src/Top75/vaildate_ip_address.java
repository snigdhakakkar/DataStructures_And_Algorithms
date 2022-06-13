package Top75;

/*
 * Problem statement: Given a string queryIP, return "IPv4" if IP is a valid IPv4 
 * address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a 
 * correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and 
xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are 
valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are 
invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, 
lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and 
"2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, 
while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 
are invalid IPv6 addresses.
 */
import java.util.regex.Pattern;
public class vaildate_ip_address {
	
	//Approach 1: Regex
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
        Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
        
    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
        Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
    
    public String validIPAddress(String IP) {
        if(pattenIPv4.matcher(IP).matches()) {
            return "IPv4";
        } 
        
        return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
    
    //time complexity: O(1) and space complexity: O(1)
       
    //Approach 2: Divide and conquer approach
    
    public String validateIPv4(String IP){
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            
            //3. only digits are allowed
            for (char ch : x.toCharArray()){
                 if (!Character.isDigit(ch)) {
                return "Neither";
                }
            }
           
            
            // 4. less than 255
            if (Integer.parseInt(x) > 255){
                return "Neither";
            }
        }           
        
        return "IPv4";
    }
    
    public String validateIPv6(String IP){
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums){
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4){
                return "Neither";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()){
                if (hexdigits.indexOf(ch) == -1){
                    return "Neither";
                }
            }
        }
        return "IPv6"; 
    }
    
    public String validIPAddressI(String IP) {
       if (IP.chars().filter(ch -> ch == '.').count() == 3){
           return validateIPv4(IP);
       }
        
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        
         else return "Neither";
    }

}
