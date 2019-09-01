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
 * https://codeforces.com/problemset/problem/231/A
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n;
    scanf("%d", &n);
    int conta = 0;

    while (n--) {
        int i1, i2, i3;
        scanf("%d%d%d", &i1, &i2, &i3);
        if(i1+i2+i3 >= 2){
            conta++;
        }
    }   

    printf("%d", conta);

    return 0;
}