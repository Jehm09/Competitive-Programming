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
 * https://codeforces.com/problemset/problem/268/A
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int n;
    cin >> n;
    vector<pair<int, int>> PII;

    rep(i, 0, n) {
        int v1, v2;
        cin >> v1 >> v2;
        PII.push_back(make_pair(v1, v2));
    }

    int rst = 0;
    rep(i, 0, n) {
        rep(j, 0, n){
            if(i != j && PII[i].first == PII[j].second){
                rst++;
            }
        }
    }

    cout << rst << endl;

    return 0;
}