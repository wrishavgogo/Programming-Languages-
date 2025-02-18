
While solving a leetcode problem I tried to introduce strategy Pattern in the code to solve it 
and i was getting an error 

Code : 

interface RomanStrategy {

    public String getRomanRepresentation(String num , int divisor , int quotient , int remainder , int subtractFrom , Map<Integer , String> integerToRomanMap );

}

class SubtractiveStrategy implements RomanStrategy{

    String getRomanRepresentation(String num , int divisor , int quotient , int remainder , int subtractFrom, Map<Integer , String> integerToRomanMap ) {

        int len = num.length();
        len--;
        // to be subtracted from 5 or 50 or 500 
        // or to be subtracted from 10 , or 100 or 1000 
        int subtractee = (int) Math.pow(10 , len);
        StringBuilder romanStringBuilder = new StringBuilder(integerToRomanMap.get(subtractee));
        int multipleOf = subtractee * subtractFrom;
        romanStringBuilder.append(integerToRomanMap.get(multipleOf));
        return romanStringBuilder.toString();
    }

}

class NormalStrategy implements RomanStrategy{

    String getRomanRepresentation(String num , int divisor , int quotient , int remainder , int subtractFrom, Map<Integer , String> integerToRomanMap) {
        
        StringBuilder result = new StringBuilder();
        String romanString = integerToRomanMap.get(divisor);
        while(quotient > 0) {
            quotient--;
            result.append(romanString);
        }
        return result.toString();
    }

}




Error : String getRomanRepresentation(String num , int divisor , int quotient , int remainder , int subtractFrom, Map<Integer , String> integerToRomanMap ) {
           ^
  attempting to assign weaker access privileges; was public




********************************* 

Learning , if we dont provide any access specifier for the method then it considers it as default
  Since we made the method public in interface , by default all methods are public in interface , 
  hence in the class level also we need to give the public access specifer ,


public String getRomanRepresentation(String num , int divisor , int quotient , int remainder , int subtractFrom, Map<Integer , String> integerToRomanMap) {
        
        StringBuilder result = new StringBuilder();
        String romanString = integerToRomanMap.get(divisor);
        while(quotient > 0) {
            quotient--;
            result.append(romanString);
        }
        return result.toString();
    }

solved the problem 
