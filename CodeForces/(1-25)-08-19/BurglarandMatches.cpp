#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
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
 * https://codeforces.com/problemset/problem/16/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n, m;
    scanf("%d%d", &n, &m);
    vector<pair<int, int>> VPII;

    while (m--) {
        int f, s;
        scanf("%d%d", &f, &s);
        VPII.push_back(make_pair(s, f));
    }

    sort(VPII.begin(), VPII.end());
    
    int rst = 0;
    while (1) {
        if(n == 0 || VPII.empty()) {
            break;
        }   
        pair<int, int> tmp = VPII.back();
        VPII.pop_back();

        if (tmp.second <= n) {
            rst += tmp.first * tmp.second;
            n -= tmp.second;
        } else {
            rst += tmp.first * n;
            n = 0;
        }
    }

    printf("%d\n", rst);    

    return 0;
}