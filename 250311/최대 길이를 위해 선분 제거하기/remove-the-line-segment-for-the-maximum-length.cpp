#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
#define MAX 1000000000

bool cmp(tuple<ll, bool, int> a, tuple<ll, bool, int> b) {
    auto [a_x, a_is_start, a_none] = a;
    auto [b_x, b_is_start, b_none] = b;
    if(a_x==b_x) return a_is_start > b_is_start;
    return a_x < b_x;
}

void init(const int& n, const vector<pair<ll, ll>>& line, vector<tuple<ll, bool, int>>& events) {
    for(int i=0; i<n; i++) {
        events.emplace_back(line[i].first, true, i);
        events.emplace_back(line[i].second, false, i);
    }
    sort(events.begin(), events.end(), cmp);
}

ll contribution(vector<tuple<ll, bool, int>>& events, vector<ll>& unique, set<int>& activeSet, int prev, int events_idx) {
    if(events_idx==events.size()) return 0;
    auto [cur, is_start, line_idx] = events[events_idx];
    ll len = 0;
    if(!activeSet.empty()) {
        len = cur - prev;
        if(activeSet.size()==1) {
            int idx = *(activeSet.begin());
            unique[idx] += len;
        }
    }
    if(is_start) activeSet.insert(line_idx);
    else activeSet.erase(line_idx);
    return len + contribution(events, unique, activeSet, cur, events_idx+1);
}

ll solution(const int& n, const vector<pair<ll, ll>>& line) {
    vector<tuple<ll, bool, int>> events;
    vector<ll> unique(n, 0);
    set<int> activeSet;
    init(n, line, events);
    ll _union = contribution(events, unique, activeSet, 0, 0);
    ll _min = MAX;
    for(const ll& u : unique) {
        _min = min(_min, u);
    }
    return _union - _min;
}

int main(){
    int n;
    cin >> n;

    vector<pair<ll, ll>> line;
    for (int i=0; i<n; i++){
        ll start, end;
        cin >> start >> end;
        line.emplace_back(start, end);
    }
    int answer = solution(n, line);
    cout<<answer;
    return 0;
}