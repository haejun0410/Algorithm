#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<vector<int>> img;
string result;

bool isPossible(int x, int y, int size) {
    int value = img[x][y];
    for (int i = x; i < x + size; ++i) {
        for (int j = y; j < y + size; ++j) {
            if (img[i][j] != value) {
                return false;
            }
        }
    }
    return true;
}

void QuadTree(int x, int y, int size) {
    if (isPossible(x, y, size)) {
        result += to_string(img[x][y]);
        return;
    }

    int newSize = size / 2;
    result += '(';

    QuadTree(x, y, newSize);                      // 왼쪽 위
    QuadTree(x, y + newSize, newSize);            // 오른쪽 위
    QuadTree(x + newSize, y, newSize);            // 왼쪽 아래
    QuadTree(x + newSize, y + newSize, newSize);  // 오른쪽 아래

    result += ')';
}

int main() {
    int N;
    cin >> N;
    img.resize(N, vector<int>(N));

    for (int i = 0; i < N; ++i) {
        string line;
        cin >> line;
        for (int j = 0; j < N; ++j) {
            img[i][j] = line[j] - '0';
        }
    }

    QuadTree(0, 0, N);
    cout << result << endl;

    return 0;
}
