#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <math.h>
#include <map>
// #include <bits/stdc++.h>

#define LL long long
#define INF 0x7fffffff
#define INFLL 0x7FFFFFFFFFFFFFFF
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define Fill(a,c) memset(&a, c, lenA(a))
#define rep(i,x,y) for(LL i=x;i<y;i++)
#define repI(i,x,y) for(LL i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/278/C
 * @author Joe
 */

void dfs(vector<int> ad[], int v, int vi[]){
    vi[v] = 0;

    for(auto v: ad[v]){
        if(vi[v]){
            dfs(ad, v, vi);
        }
    }
}

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    int n,m, empty = 0;
    cin >> n >> m;
    map<int, vector<int>> mymap;
    vector<int> adj[n];

    rep(i, 0, n) {
        int val;
        cin >> val;
        
        if(val == 0){
            empty++;
        }

        rep(j, 0, val){
            int idiom;
            cin >> idiom;
            mymap[idiom].push_back(i);
        }
    }

    for(auto v: mymap){
        vector<int> temp = v.second;
        int tam = temp.size();
        rep(i, 0, tam){
            rep(j, i+1, tam){
                adj[temp[i]].push_back(temp[j]);
                adj[temp[j]].push_back(temp[i]);
            }
        }
    }

    int vis[n];
    rep(i, 0, n){
        vis[i] = 1;
    }
    int conta = 0;

    rep(i, 0, n){
        if(vis[i]){
            dfs(adj, i, vis);
            conta++;
        }
    }
    if(empty != n){
        conta--;
    }

    rep(i, 0, n){
        if(vis[i]){
            conta++;
        }
    }

    cout << conta << endl;

    return 0;
}