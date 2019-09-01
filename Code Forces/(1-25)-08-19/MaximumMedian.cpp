#include <iostream>
#include <algorithm>   
#include <map>
using namespace std;

/**
 * Solution, Incompleto
 * Maximum Median
 * https://codeforces.com/problemset/problem/1201/C
 * @author Joe Hernandez
 */ 

int main() {
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
    int64_t n = 0, k = 0;
    int64_t arr[n];
    scanf("%lln &lln", &n, &k);
    map<int, int> mymap;

    for (size_t i = 0; i < n; i++)
        int64_t value = 0;
        scanf("%lln", &value);
        arr[i] = value;
        mymap[value]++;
    }

    fclose(stdin);
    fclose(stdout);

    return 0;
}