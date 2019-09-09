#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <math.h>
// #include <bits/stdc++.h>

#define LL long long
#define ULL unsigned LL
#define INF 0x7fffffff
#define INFLL 0x7FFFFFFFFFFFFFFF
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define Fill(a,c) memset(&a, c, sizeof(a))
#define rep(i,x,y) for(LL i=x;i<y;i++)
#define repI(i,x,y) for(LL i=x-1;i>=y;i--)
#define max2(a,b) ((a<b)?b:a)
#define max3(a,b,c) max2(max2(a,b),c)
#define min2(a,b) ((a>b)?b:a)
#define min3(a,b,c) min2(min2(a,b),c)

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/766/B
 * @author Joe
 */

int isnonDegenerateTriangle(int a, int b, int c){
    if(a + b > c && a + c > b && b + c > a) {
        return 1;
    }
    return 0;
}

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n;
    cin >> n;
    int arr[n];
    
    rep(i, 0, n) {
        cin >> arr[i];
    }

    sort(arr, arr+n);
    int st = 0;

    rep(i, 0, n-2) {
        if(isnonDegenerateTriangle(arr[i], arr[i+1], arr[i+2])) {
            st = 1;
            break;
        }
    }

    cout << ((st)?"YES":"NO") << endl; 

    return 0;
}