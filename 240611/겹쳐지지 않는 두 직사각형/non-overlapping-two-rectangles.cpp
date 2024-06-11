#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int n;int m;
int board[5][5];
set<tuple<int,int,int,int,int>> total_s;
priority_queue<tuple<int,int,int,int,int>> pq;
void square(vector<pair<int,int>> v,set<pair<int,int>> s,int value,int start_x,int start_y){
    vector<pair<int,int>> temp_v = v;
    set<pair<int,int>> temp_s = s;
    int temp_value = value;
    bool check = true;
    int temp_x = start_x;
    int temp_y = start_y;
    for(int i=0;i<v.size();i++){
        if(v[i].first+1>=n){
            check = false;
            break;
        }
        if(temp_s.count({v[i].first+1,v[i].second})==0){
            temp_v.push_back({v[i].first+1,v[i].second});
            temp_s.insert({v[i].first+1,v[i].second});
            temp_value+=board[v[i].first+1][v[i].second];
            temp_x = max(temp_x,v[i].first+1);
            temp_y = max(temp_y,v[i].second);
        }
    }
    if(check&&total_s.count({temp_value,start_x,start_y,temp_x,temp_y})==0){
        total_s.insert({temp_value,start_x,start_y,temp_x,temp_y});
        pq.push({temp_value,start_x,start_y,temp_x,temp_y});
        square(temp_v,temp_s,temp_value,start_x,start_y);
    }
    vector<pair<int,int>> vv = v;
    check = true;
    temp_x = start_x;
    temp_y = start_y;
    for(int i=0;i<vv.size();i++){
        if(v[i].second+1>=n){
            check = false;
            break;
        }
        if(temp_s.count({v[i].first,v[i].second+1})==0){
            v.push_back({v[i].first,v[i].second+1});
            s.insert({v[i].first,v[i].second+1});
            value+=board[v[i].first][v[i].second+1];
            temp_x = max(temp_x,v[i].first);
            temp_y = max(temp_y,v[i].second+1);
        }
    }
    if(check&&total_s.count({value,start_x,start_y,temp_x,temp_y})==0){
        total_s.insert({value,start_x,start_y,temp_x,temp_y});
        pq.push({value,start_x,start_y,temp_x,temp_y});
        square(v,s,value,start_x,start_y);
    }
}
int main() {
    int result = 0;
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
            total_s.insert({board[i][j],i,j,i,j});
            pq.push({board[i][j],i,j,i,j});
            vector<pair<int,int>> v;
            v.push_back({i,j});
            set<pair<int,int>> s;
            s.insert({i,j});
            square(v,s,board[i][j],i,j);
        }
    }
    vector<tuple<int,int,int,int,int>> check_value;
    check_value.push_back(pq.top());
    pq.pop();
    while(!pq.empty()){
        int value;int start_x;int start_y;int end_x;int end_y;
        tie(value,start_x,start_y,end_x,end_y) = pq.top();
        //cout<<value<<" "<<start_x<<" "<<start_y<<" "<<end_x<<" "<<end_y<<endl;
        pq.pop();
        bool check = true;
        for(int i=0;i<check_value.size();i++){
            int c_value;int start_a;int start_b;int end_a;int end_b;
            tie(c_value,start_a,start_b,end_a,end_b) = check_value[i];
            if((end_a<start_x||(end_a>=start_x&&end_b<start_y))||(end_x<start_a||(end_x>=start_a&&end_y<start_b))){
                result = max(result,value+c_value);
                // cout<<value<<" "<<c_value<<endl;
                // cout<<start_x<<" "<<start_y<<" "<<end_x<<" "<<end_y<<endl;
                // cout<<start_a<<" "<<start_b<<" "<<end_a<<" "<<end_b;
                //check = false;
                //break;
            }
        }
        if(check){
            check_value.push_back({value,start_x,start_y,end_x,end_y});
        }else break;
    }
    cout<<result;
    return 0;
}