package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

import com.epam.mjc.MethodSignature.Argument;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        signatureString = signatureString.trim();
        int start = signatureString.indexOf('(');
        int end = signatureString.indexOf(')');
        String arguments = signatureString.substring(start + 1, end).trim();
        String str = signatureString.substring(0, start).trim(); 
        List<Argument> args = new ArrayList<>();
        if (!arguments.isEmpty()) {
            String[] arrOfArguments = arguments.split(",\\s*");
            for (String str1 : arrOfArguments) {
                String[] tmp = str1.trim().split("\\s+");
                args.add(new Argument(tmp[0], tmp[1]));
            }
        }
    
        String[] arr = str.split("\\s+");
        String name;
        String modif = null;
        String type;
        if (arr.length == 3) {
            modif = arr[0];
            type = arr[1];
            name = arr[2];
        } else{
            type = arr[0];
            name = arr[1];
        }
        MethodSignature res =  new MethodSignature(name, args);
        res.setReturnType(type);
        if (modif != null) {
            res.setAccessModifier(modif);
        }
        return res;
        //throw new UnsupportedOperationException("You should implement this method.");
    }
   /*  public static void main(String[] args) {
        System.out.println(parseFunction(" public DateTime getCurrentDateTime()"));
    }*/
}
