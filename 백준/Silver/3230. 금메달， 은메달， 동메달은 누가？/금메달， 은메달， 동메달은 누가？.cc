#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int arr[101];
int ans[101];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, m, rank, player, temp;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        cin >> rank;

        if (arr[rank] != 0 && i != 1) {
            for (int j = i - 1; j >= rank; j--) {
                arr[j + 1] = arr[j];
            }
            arr[rank] = i;
        }
        else { arr[rank] = i; }
    }

    for (int i = 1; i <= m; i++) {
        cin >> rank;

        player = arr[m - i + 1];

        if (ans[rank] != 0 && i != 1) {
            for (int j = i - 1; j >= rank; j--) {
                ans[j + 1] = ans[j];
            }
            ans[rank] = player;
        }
        else { ans[rank] = player; }
    }

    for (int i = 1; i <= 3; i++) { cout << ans[i] << '\n'; }

    return 0;
}