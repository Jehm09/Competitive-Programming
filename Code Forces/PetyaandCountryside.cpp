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
 * https://codeforces.com/problemset/problem/66/B
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);

    int n;
    scanf("%d", &n);
    int arr[n];

    rep(i, 0, n){
        scanf("%d", &arr[i]);
    }

    int ma = -1;
    rep(i, 0, n){
        int cont = 1;
        int act = arr[i];
        rep(j, i+1, n){
            if (arr[j] <= act){ 
                cont++;
                act = arr[j];
            } else {
                break;
            }
        }
        act = arr[i];
        repI(j, i, 0){
            if (arr[j] <= act){ 
                cont++;
                act = arr[j];
            } else {
                break;
            }
        }
        ma = max(ma, cont);
    }

    printf("%d\n", ma);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}
