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
 * https://codeforces.com/problemset/problem/433/B
 * @author Joe
 */

const int N = (int) 1e5;  
  
// Max size of tree 
LL tree1[2 * N]; 
LL tree2[2 * N]; 
  
// function to build the tree 
void build(LL arr[], int n, LL tree[]) {  
    // insert leaf nodes in tree 
    for (int i=0; i<n; i++) 
        tree[n+i] = arr[i]; 
      
    // build the tree by calculating parents 
    for (int i = n - 1; i > 0; --i)      
        tree[i] = tree[i<<1] + tree[i<<1 | 1];     
} 
  
// function to update a tree node 
void updateTreeNode(int p, int value, int n, LL tree[]) {  
    // set value at position p 
    tree[p+n] = value; 
    p = p+n; 
      
    // move upward and update parents 
    for (int i=p; i > 1; i >>= 1) 
        tree[i>>1] = tree[i] + tree[i^1]; 
} 
  
// function to get sum on interval [l, r) 
LL query(int l, int r, int n, LL tree[]) {  
    LL res = 0; 
      
    // loop to find the sum in the range 
    for (l += n, r += n; l < r; l >>= 1, r >>= 1) { 
        if (l&1)  
            res += tree[l++]; 
      
        if (r&1)  
            res += tree[--r]; 
    } 
      
    return res; 
} 

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n, m;
    cin >> n;
    LL arr1[n], arr2[n];

    rep(i, 0, n) {
        int val;
        cin >> val;
        arr1[i] = val;
        arr2[i] = val;
    }

    sort(arr2, arr2+n);
    LL ac1[n+1], ac2[n+1];
    ac1[0] = 0;
    ac2[0] = 0;

    rep(i, 1, n+1) {
        ac1[i] = ac1[i-1] + arr1[i-1];
        ac2[i] = ac2[i-1] + arr2[i-1];
    }

    cin >> m;//querys

    rep(i, 0, m) {
        int t, l, r;
        cin >> t >> l >> r;
        if(t & 1) {
            cout << (ac1[r] - ac1[l-1]) << endl;
        } else {
            cout << (ac2[r] - ac2[l-1]) << endl;
        }
    }

    return 0;
}