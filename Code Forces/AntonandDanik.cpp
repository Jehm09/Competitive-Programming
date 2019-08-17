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
 * https://codeforces.com/problemset/problem/734/A
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);

    int n, D = 0, A = 0;
    scanf("%d", &n);
    char arr[n];
    scanf("%s", arr);

    rep(i, 0, n) {
        if (arr[i] == 'A') {
            A++;
        } else{
            D++;
        }
    }
    if(A == D) {
        printf("Friendship\n");
    } else if(A > D){
        printf("Anton\n");
    } else {
        printf("Danik\n");
    }

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}