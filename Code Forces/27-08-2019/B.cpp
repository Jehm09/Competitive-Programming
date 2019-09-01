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
 * https://codeforces.com/problemset/problem/78/B
 * @author Joe
 */

char color[] = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    
    int n;
    cin >> n;
    string s1;

    rep(i, 0, 7){
    }

    rep(i, 0, n){
        if(i < 7) {
            s1 += color[i % 7];
        } else {
            s1 += s1[i-4];
        }
    }

    cout << s1 << endl;

    return 0;
}