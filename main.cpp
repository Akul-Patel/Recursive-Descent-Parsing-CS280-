/*
Akulkumar Patel
CS 280, 450
NJIT-ID: 31504835
*/

#include <iostream>
#include <string>
#include <fstream>

using std::cout;
using std::endl;
using std::string;
using namespace std;

bool a_n(void);
bool expr(void);
bool opp(void);
bool p_n(void);
bool u_n(void);
bool i_n(void);
bool c_n(void);
bool l_n(void);
bool digit(void);

string s, t, a;


int main(int argc, char *argv[]) {

    s = t = argc == 2 ? argv[1] : "";

    std::string myText;
    std::ifstream fin ("input.txt");
    std::ofstream fout ("output.txt");

    while (getline (fin, myText)) {
      // Output the text from the file
        s = myText;
        if(a_n() && s == "") {
            fout << "The string \"" << myText << "\" is in the language."<< endl;
        }
        else {
                fout << "The string \"" << myText << "\" is not in the language."<< endl;
            }
    }
    cout << "Program finished running" << endl;
    fin.close();
    fout.close();
    return 0;


}
bool expr(){
    if (p_n()) {
        if (opp()) {
            if (p_n()) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
    return false;
}
bool a_n(){
    if (i_n()) {
        if (s[0]== '=') {
            s = s.substr(1);
            if (expr()) {
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
bool p_n(){
    if (i_n()) {
        return true;
    }
    else if (l_n()) {
        return true;
    }
    else if (u_n()) {
        if(i_n()){
            return true;
        }
    }
    else if (u_n()) {
        if(l_n()){
            return true;
        }
    }
    else if (s[0] == '(') {
        s = s.substr(1);
        if (expr()) {
            if (s[0] == ')') {
                s = s.substr(1);
                return true;
            }
        }
    }
    return false;
}
bool i_n(){
    if (c_n()) {
        if(i_n()){
            return true;
        }
        return true;
    }
    return false;
}
bool l_n(){
    if (digit()) {
        if(l_n()){
            return true;
        }
        return true;
    }
    return false;
}
bool c_n(){
    if ('a' <= s[0] && s[0] <= 'z') {
        s = s.substr(1);
        return true;
    }
    return false;
}
bool digit(){
    if ('0' <= s[0] && s[0] <= '9') {
        s = s.substr(1);
        return true;
    }
    return false;
}
bool opp(){
    if (s[0] == '+' || s[0] == '-'|| s[0] == '/') {
        s = s.substr(1);
        return true;
    }
    else if (s[0] == '*'){
        s = s.substr(1);
        if(s[0] == '*'){
            s = s.substr(1);
            return true;
        }
        return true;
    }
    return false;
}
bool u_n(){
    if (s[0] == '+' || s[0] == '-'|| s[0] == '!') {
        s = s.substr(1);
        return true;
    }
    return false;
}
