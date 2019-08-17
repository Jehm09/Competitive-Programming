#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
#define ll long long int
#define lenA(ar) sizeof(ar)/sizeof(*ar)
#define LENROWs(mat) sizeof(mat)/sizeof(*mat)
#define LENCOLs(mat) sizeof(*mat)/sizeof(**mat)
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define repI(i,x,y) for(ll i=x-1;i>=y;i--)

using namespace std;

/**
 * Solution
 * https://codeforces.com/contest/515/problem/C
 * @author Joe
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    int n;
    char arr[15];
    scanf("%d", &n);
    scanf("%s", arr);
    vector<int> num;

    rep(i, 0, n){
        if(arr[i] > '1'){
            if(arr[i] == '4'){
                num.push_back(2);
                num.push_back(2);
                num.push_back(3);
            }
            else if(arr[i] == '6'){
                num.push_back(3);
                num.push_back(5);
            }
            else if(arr[i] == '8'){
                num.push_back(2);
                num.push_back(2);
                num.push_back(2);
                num.push_back(7);
            }
            else if(arr[i] == '9'){
                num.push_back(2);
                num.push_back(3);
                num.push_back(3);
                num.push_back(7);
            }
            else{
                num.push_back(arr[i] -'0');
            }
        }
    }

    sort(num.begin(), num.end(), greater<int>());
    rep(i, 0, num.size()){
        printf("%d", num[i]);
    }
    printf("\n");

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}