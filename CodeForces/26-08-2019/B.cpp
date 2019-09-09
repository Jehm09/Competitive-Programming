#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <map>
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
 * https://codeforces.com/problemset/problem/227/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int n, q;
    cin >> n;
    LL v = 0, p = 0;
    map<int, int> mymap;

    rep(i, 0, n){
        int val;
        cin >> val;
        mymap[val] = i+1;
    }

    cin >> q;
    rep(i, 0 ,q){
        int val;
        cin >> val;
        v += mymap[val];
        p += n + 1 - mymap[val];
    }

    cout << v << " " << p << endl;

    return 0;
}