#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <stack>
#include <math.h>
// #include <bits/stdc++.h>

#define LL long long
#define INF 0x7fffffff
#define INFLL 0x7FFFFFFFFFFFFFFF
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define Fill(a,c) memset(&a, c, sizeof(a))
#define rep(i,x,y) for(LL i=x;i<y;i++)
#define repI(i,x,y) for(LL i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/5/C
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    string str;
    stack<char> mystack;
    cin >> str;
    int n = str.length(); 
  
    // Create a stack and push -1 as initial index to it. 
    stack<int> stk; 
    stk.push(-1); 
  
    // Initialize result 
    int result = 0, cant = 1; 
  
    for (int i=0; i<n; i++) { 
        if (str[i] == '(') 
          stk.push(i); 
        else { 
            stk.pop(); 
            if (!stk.empty()) {
                if(result < i - stk.top()) {
                    result = i - stk.top();
                    cant = 1;
                } else if(result == i - stk.top()){
                    cant++;
                } 
            }   
            else stk.push(i); 
        } 
    } 
  
    cout << result << " " << cant << endl;

    return 0;
}