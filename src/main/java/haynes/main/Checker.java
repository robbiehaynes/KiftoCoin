package haynes.main;

public class Checker
{
    public static boolean formatCheckNums(String s) 
    {
        char[] nums = {'1','2','3','4','5','6','7','8','9','0','.',','};
        int count = 0;
        
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 0 ; j < nums.length ; j++) {
                if (s.charAt(i) == nums[j]) {
                    count++;
                }
            }
        }
        
        if (count == s.length()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean presenceCheck(String s) 
    {
        if (s.equals("")) 
        {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean checkCharacterFormat(String s) {
        char[] specials = {'!','@','#','$','%','^','&','*','(',')'};
        int specialCount = 0;
        
        for (int i = 0 ; i < s.length() ; i++) {
            for(int a = 0 ; a < specials.length; a++) {
                if(s.charAt(i) == specials[a]) {
                    specialCount++;
                }
            }
        }
        
        if (specialCount==0){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkdigits(String s) 
    {
        int checkdigit = Integer.parseInt(s.substring(12));
        int tempCheckdigit;
        int numSum = 0;
        int[] digits = new int[12];
        int[] secondRow = new int[12];
        int[] finalRow = new int[12];
        
        for (int i = 0 ; i < 12 ; i++) {
            digits[i] = Integer.parseInt(s.substring(i, i+1));
        }
        
        for (int a = 0 ; a < 12 ; a++) {
            if (a%2 != 0) {
                secondRow[a] = (digits[a])*2;
            } else {
                secondRow[a] = digits[a];
            }
        }
        
        for (int b = 0 ; b < 12 ; b++) {
            if (secondRow[b] > 9) {
                String num = Integer.toString(secondRow[b]);
                int digit1 = Integer.parseInt(num.substring(0, 1));
                int digit2 = Integer.parseInt(num.substring(1, 2));
                finalRow[b] = digit1+digit2;
            } else {
                finalRow[b] = secondRow[b];
            }    
            numSum = numSum + finalRow[b];
        }
       
        tempCheckdigit = ((numSum*9)%10);
        
        if (tempCheckdigit == checkdigit) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean lengthCheck(String s, int length) 
    {
        if (s.length() == length) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean passwordLengthCheck(String password) 
    {
        if (password.length() < 8) 
        {
            return false;
        } else {
            return true;            
        }
    }
    
    public static int[] countPasswordCharacters(String password)
    {
        char[] specials = {'!','@','#','$','%','^','&','*','(',')'};
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
        char[] capitals = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int specialCount = 0;
        int numCount = 0;
        int capitalCount = 0;
        int[] output = new int[3];

        for(int x = 0 ; x < password.length(); x++) {
            for(int a = 0 ; a < specials.length; a++) {
                if(password.charAt(x) == specials[a]) {
                    specialCount++;
                }
            }

            for(int b = 0 ; b < nums.length; b++) {
                if(password.charAt(x) == nums[b]) {
                    numCount++;
                }
            }

            for(int c = 0 ; c < capitals.length; c++) {
                if(password.charAt(x) == capitals[c]) {
                    capitalCount++;
                }
            }
        }
        output[0] = specialCount;
        output[1] = numCount;
        output[2] = capitalCount;
        
        return output;
    }
}
