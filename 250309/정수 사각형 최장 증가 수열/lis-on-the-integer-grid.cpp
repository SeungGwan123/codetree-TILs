#include <bits/stdc++.h>

using namespace std;

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

bool bound_check(const int& n, int row, int col) {
    return row>=0 && col>=0 && row<n && col<n;
}

int dfs(const vector<vector<int>>& matrix, vector<vector<int>>& dp, int row, int col) {
    if(dp[row][col]!=1) return dp[row][col];
    for(int i=0; i<4; i++) {
        int nr = row+dr[i];
        int nc = col+dc[i];
        if(!bound_check(matrix.size(), nr, nc)) continue;
        if(matrix[row][col]>=matrix[nr][nc]) continue;
        dp[row][col] = max(dp[row][col], 1+dfs(matrix, dp, nr, nc));
    }
    return dp[row][col];
}

int solution(int n, vector<vector<int>> matrix) {
    int answer = 0;
    vector<vector<int>> dp(n, vector<int>(n, 1));
    for(int row=0; row<n; row++) {
        for(int col=0; col<n; col++) {
            if(dp[row][col]==1) {
                answer = max(answer, dfs(matrix, dp, row, col));
            }
        }
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> matrix(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }

    int answer = solution(n, matrix);

    cout << answer << endl;
    return 0;
}