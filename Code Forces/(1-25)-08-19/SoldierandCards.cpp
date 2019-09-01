#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <deque>
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
 * https://codeforces.com/problemset/problem/546/C
 * @author Joe
 */

int main() {
    #ifndef ONLINE_JUDGE
        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);
    #endif

    int n, k1, k2;
    deque<int> deck1;
    deque<int> deck2;
    scanf("%d", &n);
    scanf("%d", &k1);
    rep(i, 0, k1) {
        int val;
        scanf("%d", &val);
        deck1.push_back(val);
    }
    scanf("%d", &k2);
    rep(i, 0, k2) {
        int val;
        scanf("%d", &val);
        deck2.push_back(val);
    }

    int conta = 0;

    while(1){
        if (deck1.empty() || deck2.empty()) {
            break;
        } else if(conta == 1e5) {
            conta = -1;
            break;
        }
        
        conta++;
        int card1 = deck1.front(); 
        deck1.pop_front();
        int card2 = deck2.front();
        deck2.pop_front();

        if (card1 > card2) {
            deck1.push_back(card2);
            deck1.push_back(card1);
        } else {
            deck2.push_back(card1);
            deck2.push_back(card2);
        }
    }
    if (conta == -1) {
        printf("-1\n");
    } else {
        if (deck1.empty()) {
            printf("%d 2\n", conta);
        } else {
            printf("%d 1\n", conta);
        }
    }

    return 0;
}