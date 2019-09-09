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
 * https://codeforces.com/problemset/problem/599/A
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    int rst = INT_MAX;

    rst = min((a+b+c) ,rst);
    rst = min((2*a+2*b) ,rst);
    rst = min((2*a+2*c) ,rst);
    rst = min((2*b+2*c) ,rst);
    
    printf("%d\n", rst);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}