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
#define mod 1000000007

using namespace std;

/**
 * Solution
 * 
 * @author Joe
 */

int dp(int k, int n){
    if(n == 0) {
        return 1;
    } else {
        return ((k * (dp(n-1, k-1) % mod) % mod) + ((k - 1) * dp(n-1, k)) % mod) % mod;
    }
}

int main() {
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
    int n, k;
    scanf("%d%d", &n, &k);

    printf("%d", dp(k, n));

    fclose(stdin);
    fclose(stdout);
    return 0;
}