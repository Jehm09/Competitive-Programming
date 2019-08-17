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
 * https://codeforces.com/problemset/problem/303/A
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int n;
    scanf("%d", &n);

    if (n & 1) {
        repI(i, n, 0){
            if (i > 0) {
                printf("%d ", i);
            } else {
                printf("%d\n", i);
            }
        }
        repI(i, n, 0){
            if (i > 0) {
                printf("%d ", i);
            } else {
                printf("%d\n", i);
            }
        }
        repI(i, n, 0){
            if (i > 0) {
                printf("%d ", i * 2 % n);
            } else {
                printf("%d\n", i * 2 % n);
            }
        }
    } else {
            printf("-1\n");
    }

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}