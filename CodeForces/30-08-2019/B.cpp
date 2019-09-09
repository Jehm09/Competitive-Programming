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
 * https://codeforces.com/problemset/problem/363/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int n, k, pos, min = INF;
    cin >> n >> k;
    int arr[n], acum[n+1];
    rep(i, 0, n) {
        cin >> arr[i];
    }

    rep(i, 1, n+1) {
        acum[i] = acum[i-1] + arr[i-1];
    }

    rep(i,0, n+1-k) {
        int val = acum[i+k] - acum[i];
        if(val < min) {
            min = val;
            pos = i;
        }
    }

    cout << pos+1 << endl;

    return 0;
}