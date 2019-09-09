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
 * https://codeforces.com/problemset/problem/463/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int n;
    scanf("%d", &n);
    int arr[n];

    rep(i, 0 , n) {
        scanf("%d", &arr[i]);
    } 

    int energy = 0, cost = arr[0];
    rep(i, 0 , n-1) {
        if (arr[i] >= arr[i+1]){
            energy += arr[i] - arr[i+1];
        } else{
            if(energy >= arr[i+1] - arr[i]) {
                energy -= arr[i+1] - arr[i];
            } else {
                cost += (arr[i+1] - arr[i]) - energy;
                energy = 0;
            }
        }
    } 
    printf("%d\n", cost);

    return 0;
}