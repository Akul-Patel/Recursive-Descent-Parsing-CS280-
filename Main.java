/*
Akulkumar Patel
CS 280, 450
NJIT-ID: 31504835
*/

import java.io.*;
import java.lang.String;
public class Main{
    public static String j = "";
    public static int i;
    public static void main(String[] args){

    BufferedWriter bw = null;
    FileWriter fw = null;

    String file_inp = "input.txt";
    String st_g;

    try{
        FileReader fr = new FileReader(file_inp);
        BufferedReader br = new BufferedReader(fr);

        fw = new FileWriter("output.txt");
        bw = new BufferedWriter (fw);
        while((st_g = br.readLine()) != null){
            j = st_g;
            i=0;

            if(A () && i == st_g.length()){
                bw.write("The string \"" + st_g + "\" is in the language.\n");
            }
            else{
                bw.write("The string \"" + st_g + "\" is not in the language.\n");
            }
        }
        br.close();
        bw.close();
    }

    catch(IOException ex){
        System.out.println("error!!!");
    }
    
    }

    private static boolean A(){
        if (I()){
            if(i<j.length() && (j.charAt(i) == '=')){
                ++i;
                if(E ()){
                    return true;
                }
                else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

private static boolean E(){
    if (P()){
        if (O ()){
            if (P()){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    return false;
}

private static boolean O(){
    if(i<j.length() && (j.charAt(i) == '/' || j.charAt(i) == '-' || j.charAt(i)== '+')){
        ++i;
        return true;
    }

    else if(i<j.length() && (j.charAt(i) == '*')){
        ++i;
        if(i<j.length() && (j.charAt(i) == '*')){
            ++i;
            return true;
        }
        return true;
    }

    return false;
}

private static boolean P(){
    if(I()){
        return true;
    }
    else if(L()){
        return true;
    }
    else if(U()){
        if(I()){
            return true;
        }
    }
    else if(U()){
        if(L()){
            return true;
        }
    }

    else if(i<j.length() && (j.charAt(i) == '(')){
        ++i;
        if(E()){
            if(i<j.length() && (j.charAt(i) == ')')){
                ++i;
                return true;
            }
            
        }
        
    }
    return false;

}

private static boolean U(){
    if(i<j.length() && (j.charAt(i) == '!' || j.charAt(i) == '-' || j.charAt(i)== '+')){
        ++i;
        return true;
    }
    return false;
}

private static boolean I(){
    if(C()){
        if(I()){
            return true;
        }
        return true;
    }
    return false;
}

private static boolean C(){
    if(i<j.length() && (j.charAt(i) >= 'a' && j.charAt(i) <= 'z')){
        ++i;
        return true;
    }
    return false;
}

private static boolean L(){
    if(D()){
        if(L()){
            return true;
        }
        return true;
    }
    return false;
}

private static boolean D(){
    if(i<j.length() && (j.charAt(i) >= '0' && j.charAt(i) <= '9')){
        ++i;
        return true;
    }
    return false;
}
}
