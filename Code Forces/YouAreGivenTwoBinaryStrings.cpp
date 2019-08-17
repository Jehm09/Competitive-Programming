#include <iostream>
#include <string.h>
#include <algorithm>   
using namespace std;

/**
 * Solution
 * Code Forces You Are Given Two Binary Strings...
 * https://codeforces.com/problemset/problem/1202/A
 * @author Joe Hernandez
 */

int main() {
    // freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);

    int n = 0;
    scanf("%d", &n);
    char string1[100001];
    char string2[100001];
    int x1 = 0;
    int y1 = 0;

    while (n--) {
        scanf("%s %s", &string1, &string2);
        int len = strlen(string2);
        reverse(string2, string2+len);
        for (size_t i = 0; i < len; i++) {
            if (string2[i] == '1') {
                y1 = i;
                break;
            }
        }

        len = strlen(string1);
        reverse(string1, string1+len);
        for (size_t i = y1; i < len; i++) {
            if (string1[i] == '1') {
                x1 = i;
                break;
            }
        }
        printf("%d\n",(x1-y1));
    }
    
    // fclose(stdin);
    // fclose(stdout);
    return 0;
}