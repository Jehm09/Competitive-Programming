#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <math.h>
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
 * https://codeforces.com/problemset/problem/405/A
 * @author Joe
 */

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

    rep(i, 0, n){
        rep(j, 0, n-1){
            if(arr[j] > arr[j+1]) {
                int val = arr[j] - arr[j+1];
                arr[j+1] = arr[j+1] + val;
                arr[j] = arr[j] - val;
            } 
        }
    }

    rep(i, 0, n){
        if (i == n-1) {
            cout << arr[i] << endl;
        } else {
            cout << arr[i] << " ";
        }
        
    }


    return 0;
}