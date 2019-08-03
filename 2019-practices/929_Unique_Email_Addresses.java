// not fastest
class Solution {
    public int numUniqueEmails(String[] emails) {
        // 0. assume all emails are legal and emails never be null
        // 1. create a rule func to parse all emails to forward emails
        // 2. Use Set to store 
        HashSet<String> result = new HashSet<>();
        for(int i = 0 ; i < emails.length ; i++) {
            result.add(forwardTo(emails[i]));
        }
        return result.size();
    }
    
    public String forwardTo(String email) {
        String[] arr = email.split("@");
        String name = arr[0]; // local name
        String address = arr[1]; // address
            
        StringBuilder builder = new StringBuilder();
        
        char[] nameChar = name.toCharArray();
        for(int i = 0 ; i < nameChar.length ; i++) {
            char ch = nameChar[i];
            if( ch  == '.' ) continue;
            else if( ch  == '+') break;
            builder.append( ch );
        }
        builder.append('@');
        builder.append(address);
        return builder.toString();
    }
}
