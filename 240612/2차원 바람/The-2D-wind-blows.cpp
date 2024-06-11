#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int n;int m;int q;
vector<vector<int>> board;
void rot(int a,int b,int c,int d){
    vector<vector<int>> temp = board;
    for(int i=a;i<=c;i++){
        for(int j=b;j<=d;j++){
            if(i!=a&&i!=c&&j!=b&&j!=d) continue;
            if(j==d) {
                if(i==c) board[i][j-1] = temp[i][j];
                else board[i+1][j] = temp[i][j];
            }
            else if(j==b){
                if(i==a) board[i][j+1] = temp[i][j];
                else board[i-1][j] = temp[i][j];
            } 
            else if(i==a) board[i][j+1] = temp[i][j];
            else board[i][j-1] = temp[i][j];
        }
    }
}
void aver(int a,int b,int c,int d){
    vector<vector<int>> temp = board;
    int dir[4][2]={{1,0},{-1,0},{0,1},{0,-1}};
    for(int i=a;i<=c;i++){
        for(int j=b;j<=d;j++){
            int count = temp[i][j];
            int num = 1;
            for(int d=0;d<4;d++){
                int d_x = i+dir[d][0];
                int d_y = j+dir[d][1];
                if(d_x<0||d_x>=n||d_y<0||d_y>=m) continue;
                num++;
                count+=temp[d_x][d_y];
            }
            board[i][j] = count/num;
        }
    }
}
int main() {
    cin>>n>>m>>q;
    for(int i=0;i<n;i++){
        vector<int> temp;
        for(int j=0;j<m;j++){
            int t;
            cin>>t;
            temp.push_back(t);
        }
        board.push_back(temp);
    }
    for(int Q=0;Q<q;Q++){
        int a;int b;int c;int d;
        cin>>a>>b>>c>>d;
        rot(a-1,b-1,c-1,d-1);
        aver(a-1,b-1,c-1,d-1);
    }
    for(auto iter : board){
        for(auto e : iter){
            cout<<e<<" ";
        }
        cout<<endl;
    }
    return 0;
}