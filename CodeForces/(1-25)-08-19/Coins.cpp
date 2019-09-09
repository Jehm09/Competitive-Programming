#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <map>
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
 * https://codeforces.com/contest/47/problem/B
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif
    char f[4], s[4], t[4];
    map<int, int> arr;
    arr[0] = 0, arr[1] = 0, arr[2] = 0;
    char mayor = ' ', medio = ' ', menor = ' ';

    cin >> f >> s >> t;
    
    if(f[1] == '>'){
        arr[f[0] - 'A']++;
    } else {
        arr[f[2] - 'A']++;
    }
    if(s[1] == '>'){
        arr[s[0] - 'A']++;
    } else {
        arr[s[2] - 'A']++;
    }
    if(t[1] == '>'){
        arr[t[0] - 'A']++;
    } else {
        arr[t[2] - 'A']++;
    }

    int st = 1;
    for(auto v: arr){
        if(v.second == 2 && mayor == ' '){
            mayor = v.first+'A';
        }
        else if(v.second == 1 && medio == ' '){
            medio = v.first+'A';
        }
        else if(v.second == 0 && menor == ' '){
            menor = v.first+'A';
        } else {
            st = 0;
        }
    }
    if(st){
        cout << menor << medio << mayor << endl;
    } else {
        cout << "Impossible" << endl;
    }

    return 0;
}