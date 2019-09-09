#include <iostream>
#include <string.h>
#include <algorithm>
#include <map>

using namespace std;

/**
 * Solution
 * https://codeforces.com/problemset/problem/129/A
 * @author Joe
 */
int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);

    int n = 0;
    scanf("%d", &n);
    int arr[n];

    for (size_t i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    map<int, int> good;
    map<int, int> bad;

    for (size_t i = 0; i < n; i++) {
        int value = 0;
        if ((good.find(i) == good.end()) && (bad.find(i) == bad.end())){
            for (size_t j = 0; j < n; j++) {
                if (i != j){
                    value += arr[j];
                }
            }
        }
        if (!(value & 1) || (good.find(i) != good.end())) {
            good[i] += 1;       
        }
        else {
            bad[i] = 1;       
        }
    }
    
    int count = 0;

    for(auto i : good){
        count += i.second;
    }
    printf("%d\n", count);

    // fclose(stdin);
    // fclose(stdout);
    return 0;
}
/*
10 
1 2 2 3 4 4 4 2 2 2

11 
2 2 2 2 2 2 2 2 2 2 99

*/
