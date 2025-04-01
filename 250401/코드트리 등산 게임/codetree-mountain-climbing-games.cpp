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

int b_search(Mountain* m, vector<set<Mountain*, set_cmp>>& lis2mountain) {
    if(lis2mountain.empty()) return 0;
    int right = lis2mountain.size()-1;
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

void addLIS(Mountain* m, vector<set<Mountain*, set_cmp>>& lis2mountain) {
    int k = b_search(m, lis2mountain);
    if(lis2mountain.size()==k) {
        lis2mountain.emplace_back(set<Mountain*, set_cmp> {m});
    }
    else {
        lis2mountain[k].insert(m);
    }
    if(k) {
        auto it = lis2mountain[k-1].upper_bound(m);
        m->prev = *(--it);
        m->lis = k;
        return;
    }
    else {
        m->lis = 0;
    }
}

void removeLIS(Mountain* m, vector<set<Mountain*, set_cmp>>& lis2mountain) {
    int k = m->lis;
    lis2mountain[k].erase(m);
    if(lis2mountain[k].empty())
        lis2mountain.pop_back();
}

void build_mountain(vector<Mountain*>& mountain, vector<set<Mountain*, set_cmp>>& lis2mountain, int h) {
    int i = mountain.size();
    Mountain* m = new Mountain(h, i);
    addLIS(m, lis2mountain);
    mountain.push_back(m);
}

void bigbang(vector<Mountain*>& mountain, vector<set<Mountain*, set_cmp>>& lis2mountain, int n) {
    for(int i=0; i<n; i++) {
        int h;
        cin >> h;
        build_mountain(mountain, lis2mountain, h);
    }
}

void earthquake(vector<Mountain*>& mountain, vector<set<Mountain*, set_cmp>>& lis2mountain) {
    Mountain* m = mountain[mountain.size()-1];
    removeLIS(m, lis2mountain);
    delete m;
    mountain.pop_back();
}

long long simulation(vector<Mountain*>& mountain, vector<set<Mountain*, set_cmp>>& lis2mountain, int idx) {
    long long score = 0;
    Mountain* m = mountain[idx];
    int lis = lis2mountain.size()-1;
    int highest = (*lis2mountain[lis].begin())->height;
    score += (m->lis + 1) * add_points;
    score += lis * add_points;
    score += highest;
    return score;
}

int main() {
    int Q;
    cin >> Q;

    vector<Mountain*> mountain;
    vector<set<Mountain*, set_cmp>> lis2mountain;
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