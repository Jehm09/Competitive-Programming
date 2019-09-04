#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <math.h>
// #include <bits/stdc++.h>

#define LL long long
#define ULL unsigned LL
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
 * https://codeforces.com/problemset/problem/439/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    LL n, x, cs[(int) 1e5];
    cin >> n >> x;
    rep(i, 0, n) {
        cin >> cs[i];
    }

    sort(cs, cs+n);

    ULL rst = 0;

    // cout << sizeof(rst);
    rep(i, 0, n) {
        rst += cs[i] * x;

        if(x > 1) {
            x--;
        }
    }

    cout << rst << endl;

    return 0;
}