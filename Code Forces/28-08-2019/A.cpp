#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
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
 * https://codeforces.com/problemset/problem/281/A
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    char string[(int) 1e4];

    cin >> string;

    if(islower(string[0])){
        string [0] = toupper(string[0]);
        cout << string << endl;
    } else {
        cout << string << endl;
    }


    return 0;
}