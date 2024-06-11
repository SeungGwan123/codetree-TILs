#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;int t;
    cin>>n>>t;
    vector<int> v[3];
    vector<int> temp_v[3];
    int row = 0;
    for(int i=0;i<n*3;i++){
        int temp;
        cin>>temp;
        v[row].push_back(temp);
        temp_v[row].push_back(temp);
        if(i%n==n-1) row++;
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<n;j++){
            int now = v[i][j];
            int time = j+t;
            temp_v[(i+time/n)%3][time%n] = now;
        }
    }
    for(auto iter : temp_v){
        for(auto a : iter){
            cout<<a<<" ";
        }
        cout<<endl;
    }
    return 0;
}