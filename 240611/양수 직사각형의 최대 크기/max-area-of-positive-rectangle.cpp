#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int n;int m;
int board[20][20];
priority_queue<int> pq;
void big_square(vector<pair<int,int>> v,set<pair<int,int>> s){
    vector<pair<int,int>> temp_v = v;
    set<pair<int,int>> temp_s = s;
    bool check = true;
    for(int i=0;i<v.size();i++){
        int a = v[i].first+1;
        int b = v[i].second;
        if(a>=n) {
            check = false;
            break;
        }
        if(board[a][b]<0){
            check = false;
            break;
        }
        temp_v.push_back({a,b});
        temp_s.insert({a,b});
    }
    if(check){
        pq.push(temp_s.size());
        big_square(temp_v,temp_s);
    }
    vector<pair<int,int>> t_v = v;
    set<pair<int,int>> t_s = s;
    check = true;
    for(int i=0;i<v.size();i++){
        int a = v[i].first;
        int b = v[i].second+1;
        if(b>=m) {
            check = false;
            break;
        }
        if(board[a][b]<0){
            check = false;
            break;
        }
        t_v.push_back({a,b});
        t_s.insert({a,b});
    }
    if(check){
        pq.push(t_s.size());
        big_square(t_v,t_s);
    }
}
int main() {
    cin>>n>>m;    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int temp;
            cin>>temp;
            board[i][j] = temp;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]<0)continue;
            vector<pair<int,int>> v = {{i,j}};
            set<pair<int,int>> s = {{i,j}};
            big_square(v,s);
        }
    }
    if(pq.top()<0) cout<<"-1";
    else cout<<pq.top();
    return 0;
}