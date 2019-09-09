#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <map>
#include <math.h>
// #include <bits/stdc++.h>

#define ll long long
#define INF 0x7fffffff
#define INFLL 0x7FFFFFFFFFFFFFFF
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define Fill(a,c) memset(&a, c, sizeof(a))
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define repI(i,x,y) for(ll i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/651/C
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n;
    scanf("%d", &n);
    // pair<double, double> arr[n];
    map<string, int> both;
    map<ll, ll> x;
    map<ll, ll> y;

    rep (i, 0, n){
        int val1, val2;
        scanf("%d%d", &val1, &val2);
        string key = to_string(val1) + "," + to_string(val2);
        x[val1]++;
        y[val2]++;
        both[key]++;
    }

    ll rst = 0;
    
    for(auto v: x){
        ll val = v.second;
        rst += (val*(val - 1))/2;
    }
    for(auto v: y){
        ll val = v.second;
        rst += (val*(val - 1))/2;
    }
    for(auto v: both){
        ll val = v.second;
        rst -= (val*(val - 1))/2;
    }

    printf("%lld\n", rst);

    return 0;
}