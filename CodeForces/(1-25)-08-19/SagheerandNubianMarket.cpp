#include <iostream>
#include <string.h>
#include <algorithm>
#include <bits/stdc++.h> 
#define ll long long int
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define repI(i,x,y) for(ll i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/812/C
 * @author Joe
 */
ll cost(int k, int n, ll arr[]){
    ll temp[n];
    rep(i, 0 , n){
        temp[i] = arr[i] + (i+1) * k;
    }

    sort(temp, temp+n);

    ll rst = 0;
    rep(i, 0, k){
        rst += temp[i];
    }

    return rst;
}

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    
    int n; 
    ll s, minimun = LONG_MAX, sum = 0;
    scanf("%d%lld", &n, &s);
    ll arr[n];

    rep(i, 0, n){
        scanf("%lld", &arr[i]);
        sum += arr[i] + (i + 1 ) * n;
        minimun = min(minimun, arr[i] + i + 1);
    }
    if(sum <= s){
        printf("%d %ld\n", n, sum);
    } else if (minimun > s) {
        printf("0 0\n");
    } else {
        int l = 1, r = n, mid;

        while (l < r) {
            // mid = l + (r - l) / 2;
            mid = (r + l) / 2;
            if (cost(mid, n, arr) > s) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l -= 1;

        printf("%d %lld\n", l, cost(l, n, arr));
    }

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}