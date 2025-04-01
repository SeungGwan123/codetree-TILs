#include <vector>
#include <iostream>
#include <map>
#include <set>
#include <cstdio>

#define add_points 1000000
using namespace std;

struct Mountain {
    int height;
    int idx;
    int lis;
    Mountain* prev;
    Mountain(int h, int i) : height(h), idx(i), prev(NULL), lis(0) {};
};

struct set_cmp {
    bool operator()(const Mountain* m1, const Mountain* m2) const {
        if (m1->height == m2->height) return m1->idx < m2->idx;
        return m1->height > m2->height;
    }
};

int b_search(Mountain* m, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain) {
    if(lis2mountain.empty()) return 0;
    auto it = lis2mountain.begin();
    int right = (*it).first;
    int left = 0;
    while(left<=right) {
        int mid = (left+right)/2;
        auto lis_min_value = lis2mountain[mid].end(); lis_min_value--;
        int min_value = (*lis_min_value)->height;
        if(min_value>=m->height) {
            right = mid-1;
        }
        else {
            left = mid+1;
        }
    }
    return left;
}

void addLIS(Mountain* m, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain) {
    int k = b_search(m, lis2mountain);
    if(k) {
        auto it = lis2mountain[k-1].upper_bound(m);
        lis2mountain[k].insert(m);
        m->prev = *(--it);
        m->lis = k;
        return;
    }
    else {
        lis2mountain[0].insert(m);
        m->lis = 0;
    }
}

void removeLIS(Mountain*m, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain) {
    int k = m->lis;
    lis2mountain[k].erase(m);
    if(lis2mountain[k].empty())
        lis2mountain.erase(k);
}

void build_mountain(vector<Mountain*>& mountain, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain, int h) {
    int i = mountain.size();
    Mountain* m = new Mountain(h, i);
    addLIS(m, lis2mountain);
    mountain.push_back(m);
}

void bigbang(vector<Mountain*>& mountain, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain, int n) {
    for(int i=0; i<n; i++) {
        int h;
        cin >> h;
        build_mountain(mountain, lis2mountain, h);
    }
}

void earthquake(vector<Mountain*>& mountain, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain) {
    Mountain* m = mountain[mountain.size()-1];
    removeLIS(m, lis2mountain);
    delete m;
    mountain.pop_back();
}

long long simulation(vector<Mountain*>& mountain, map<int, set<Mountain*, set_cmp>, greater<int>>& lis2mountain, int idx) {
    long long score = 0;
    Mountain* m = mountain[idx];
    int lis = (*lis2mountain.begin()).first;
    int highest = (*(*lis2mountain.begin()).second.begin())->height;
    score += (m->lis + 1) * add_points;
    score += lis * add_points;
    score += highest;
    return score;
}

int main() {
    int Q;
    cin >> Q;

    vector<Mountain*> mountain;
    map<int, set<Mountain*, set_cmp>, greater<int>> lis2mountain;
    for(int i=0; i<Q; i++) {
        int cmd;
        cin >> cmd;
        switch (cmd) {
        case 100:
            if(i!=0) {
                cout << "bigbang error" << endl;
                return 0;
            }
            int n;
            cin >> n;
            bigbang(mountain, lis2mountain, n);
            break;
        case 200:
            int h;
            cin >> h;
            build_mountain(mountain, lis2mountain, h);
            break;
        case 300:
            earthquake(mountain, lis2mountain);
            break;
        case 400:
            int idx;
            cin >> idx;
            cout << simulation(mountain, lis2mountain, idx-1) << endl;
            break;
        default:
            cout << "cmd error" << endl;
            return 0;
        }
    }

    return 0;
}