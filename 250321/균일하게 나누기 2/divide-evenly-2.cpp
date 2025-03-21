#include <bits/stdc++.h>

using namespace std;

bool x_asc(pair<int, int>& a, pair<int, int>& b) {
    if(a.first==b.first) return a.second < b.second;
    return a.first < b.first;
}

bool y_asc(pair<int, int>& a, pair<int, int>& b) {
    if(a.second==b.second) return a.first < b.first;
    return a.second < b.second;
}

int b_search(int start, int end, const vector<pair<int, int>>& points, int target) {
    int mid;
    int ret = start - 1;
    while(start<=end) {
        mid = (start+end)/2;
        if(target>points[mid].second) {
            ret = mid;
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }
    return ret;
}

int boundary_cnt(int left, int right, int left_points, int right_points, int cur) {
    int left_bottom = left+1;
    int left_top = left_points - left_bottom;
    int right_bottom = right-cur;
    int right_top = right_points - right_bottom;
    return max({left_bottom, left_top, right_bottom, right_top});
}

int progress_x(int cur, vector<pair<int, int>> points, const set<int>& y_points) {
    int size = points.size()-1;
    if(cur!=size&&points[cur].first==points[cur+1].first) return INT_MAX;
    int ret = INT_MAX;
    sort(points.begin(), points.begin()+cur+1, y_asc);
    sort(points.begin()+cur+1, points.end(), y_asc);
    for(const auto& y : y_points) {
        int left = b_search(0, cur, points, y+1);
        int right = b_search(cur+1, size, points, y+1);
        ret = min(ret, boundary_cnt(left, right, cur+1, size-cur, cur));
    }
    return ret;
}

int main() {
    int n;
    int ret = INT_MAX;
    vector<pair<int, int>> points;
    set<int> y_points;
    cin >> n;
    for(int i=0; i<n; i++) {
        int x, y;
        cin >> x >> y;
        points.emplace_back(x, y);
        y_points.insert(y);
    }
    sort(points.begin(), points.end(), x_asc);
    for(int i=0; i<n; i++) {
        ret = min(ret, progress_x(i, points, y_points));
    }
    cout << ret;
    return 0;
}