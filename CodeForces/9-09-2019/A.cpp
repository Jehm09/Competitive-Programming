#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <set>
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
 * https://codeforces.com/problemset/problem/228/A
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    set<int> myset;
    int h = 4;
    rep(i, 0, 4) {
        int val;
        cin >> val;
        myset.insert(val);
    }

    cout << h - myset.size() << endl;

    return 0;
}