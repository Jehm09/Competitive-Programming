// #include <iostream>
// #include <string.h>
// #include <algorithm>
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
 * https://codeforces.com/contest/1206/problem/A
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int n, m;
    int arrA[200], arrB[200];
    scanf("%d", &n);
    rep(i, 0, n) {
        scanf("%d", &arrA[i]);
    }
    scanf("%d", &m);
    rep(i, 0, m) {
        scanf("%d", &arrB[i]);
    }
    sort(arrA, arrA+n);
    sort(arrB, arrB+m);

    printf("%d %d\n", arrA[n-1], arrB[m-1]);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}