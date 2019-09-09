#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <math.h>
#include <map>
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
 * https://codeforces.com/problemset/problem/88/B
 * @author Joe
 */

int n, m, x, q, cont = 0;
bool can[26];
vector<pair<int, int>> shift, key[26];

int dist(int i, int j, int shr, int shc) {
	return (i - shr)*(i - shr) + (j - shc)*(j - shc);
}

int check(pair<int, int> xy) {

    rep(i, 0, shift.size()) {
        int dis = dist(xy.first, xy.second, shift[i].first, shift[i].second);
        if(dis <= x*x)
            return 1;
    }

    return 0;
}

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    cin >> n >> m >> x;

    rep(i, 0, n) {
        char s[m];
        cin >> s;
        rep(j, 0, m) {
            if(s[j] != 'S'){
                key[s[j] - 'a'].push_back(make_pair(i, j));
            } else {
                shift.push_back(make_pair(i, j));
            }
        }
    }

    rep(i, 0 , 26) {
        rep(j, 0, key[i].size()) {
            can[i] = can[i] || check(key[i][j]);
        }
    }


    cin >> q;
    char s[q];
    cin >> s;

    rep(i, 0, q) {
        char ch = tolower(s[i]);
        if(islower(s[i])){
            if(key[s[i] - 'a'].empty()){
                cont = -1;
                break;
            }
        } else {
            int d, temp = 1;
            if(key[ch - 'a'].empty() || shift.empty()){
                cont = -1;
                break;
            } else {
                if(!can[ch - 'a']) {
                    cont++;
                }
            }
        }
    }

    cout << cont << endl;


    return 0;
}