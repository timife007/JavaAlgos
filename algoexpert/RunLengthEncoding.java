package algoexpert;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string){
        if(string.length() == 1){
            return "1" + string;
        }
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        while(pointer < string.length()){
            char curr = string.charAt(pointer);
            int count = 0;
            while(pointer < string.length() && string.charAt(pointer) == curr){
                count++;
                pointer++;
            }
            if(count >= 10){
                int diff = count - 9;
                result.append(9).append(curr);
                if(diff >= 10){
                    while(diff >= 10){
                        diff = diff - 9;
                        result.append(9).append(curr);
                    }
                }

                result.append(diff).append(curr);

            }else if(count > 0){
                result.append(count).append(curr);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String input = "ABAAAAAAAAAAAAAAAAAAAAAAAAN";
        System.out.println(runLengthEncoding(input));
    }
}
