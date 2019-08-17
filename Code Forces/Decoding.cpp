#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#include <queue>
#define ll long long int
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define repI(i,x,y) for(ll i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/contest/746/problem/B
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int n;
    char arr[2000];
    scanf("%d", &n);
    scanf("%s", arr);

    vector<int> vec;
    int rst[n];
    
    int c = 0;
    rep(i, 0, n){
        vec.push_back(c++);
    }

    int i = 0;
    while (!vec.empty()) {
        int v = vec.size()/2;
        if (vec.size() & 1) { //odd
            vector<int>::iterator it1 = vec.begin()+v;
            rst[*it1] = i++;
            vec.erase(it1);
        } else { //even
            vector<int>::iterator it1 = vec.begin()+(v-1);
            rst[*it1] = i++;
            vec.erase(it1);
        }
    }
    
    rep(i, 0, n){
        printf("%c", arr[rst[i]]);
    }
    printf("\n");
    
    // fclose(stdin);
    // fclose(stdout);
    return 0;
}
/**
5
logva
R//
volga
*/