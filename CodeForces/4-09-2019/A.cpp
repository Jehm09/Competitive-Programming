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
 * https://codeforces.com/problemset/problem/431/A
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int a1, a2, a3, a4, rst = 0;
    char s[(int) 1e5+1];
    cin >> a1 >> a2 >> a3 >> a4 >> s;

    rep(i, 0 , strlen(s)) {
        if(s[i] == '1'){
            rst += a1;
        } else if(s[i] == '2') {
            rst += a2;
        } else if(s[i] == '3') {
            rst += a3;
        } else{
            rst += a4;
        }
    }

    cout << rst << endl;

    return 0;
}