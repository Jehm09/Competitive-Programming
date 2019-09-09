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
 * https://codeforces.com/gym/101933/problem/C
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int n;
    int arr[500];
    scanf("%d", &n);

    rep(i, 0, n) {
        scanf("%d", &arr[i]);
    }
    int ans = 0, tot = 0, num = 0, ptr = 0;
    rep(i, 1, 366) {
        tot += num;
        if (ptr < n && arr[ptr] == i) {
            ptr++; num++;
        }

       if (tot+num >= 20) {
           ans++; tot = 0; num =0;
       } 
    }
    if (num) {
        ans++;
    }

    printf("%d\n", ans);
    
    // fclose(stdin);
    // fclose(stdout);
    return 0;
}