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
 * https://codeforces.com/problemset/problem/680/B
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int arr[100];
    int n, ini;
    scanf("%d%d", &n, &ini);
    rep(i, 0, n){
        scanf("%d", &arr[i]);
    }
    int cont = 0;
    int inc = 1;
    ini -= 1;

    if(arr[ini])
        cont++;

    while(1){
        int l = ini - inc;
        int r = ini + inc;

        if (l < 0 && r >= n) {
            printf("%d", cont);
            break;
        } else if(l < 0 && arr[r]) {
            cont++;
        } else if(r >= n && arr[l]) {
            cont++;
        } else if(arr[l] && arr[r]){
            cont += 2;
        }

        inc++;
    }

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}