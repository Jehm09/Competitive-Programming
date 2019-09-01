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
#define maxA 100000

using namespace std;

/**
 * Solution
 * https://codeforces.com/contest/1206/problem/B
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    
    int n, neg = 0, posit = 0, posC = -1, menor = INT_MAX;
    ll coins = 0;
    int arr[maxA], arrN[maxA];
    scanf("%d", &n);

    int j = 0;
    rep(i, 0, n) {
        scanf("%d", &arr[i]);

        if (arr[i] < 0) {
            neg++;
            arrN[j++] = arr[i];
        } else {
            if (arr[i] < menor) {
                menor = arr[i];
                posC = i;
            }
            
            posit++;
        }
    }
    sort(arrN, arrN + neg, greater<int>());

    j = 0;
    if (neg & 1) {
        if(posC != -1 && (1 + arr[posC]) < (1 - arrN[0])){
            coins += 1 + arr[posC];
            arr[posC] = -1;
        } else {
            coins += 1 - arrN[0];
            j = 1;
        }
    }
    

    rep(i, 0, n){
        if (j < neg) {
            coins += -1 - arrN[j++];
        }
        if (arr[i] >= 0) {
            if (arr[i]){
                coins += arr[i] - 1;
            } else {
                coins++;
            }
        }
    }

    printf("%lld\n", coins);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}