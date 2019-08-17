#include <iostream>
#include <string.h>
#include <algorithm>
#define ll long long int
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define repI(i,x,y) for(ll i=x-1;i>y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/contest/677/problem/A
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);

    int n, h;
    scanf("%d%d", &n, &h);
    int arr[n];

    rep(i, 0, n){
        scanf("%d", &arr[i]);
    }
    int count = 0;
    rep(i, 0, n){
        if (arr[i] > h) {
            count += 2;
        }else{
            count += 1;
        }
    }

    printf("%d\n", count);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}