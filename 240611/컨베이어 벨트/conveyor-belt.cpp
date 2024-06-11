#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;int t;
    cin>>n>>t;
    vector<vector<int>> v;
    vector<int> one;
    vector<int> two;
    for(int i=0;i<n;i++){
        int temp;
        cin>>temp;
        one.push_back(temp);
    }
    for(int i=0;i<n;i++){
        int temp;
        cin>>temp;
        two.push_back(temp);
    }
    v.push_back(one);
    v.push_back(two);
    vector<vector<int>> temp = v;
    for(int i=0;i<2;i++){
        for(int j=0;j<n;j++){
            int now = temp[i][j];
            if(j+t>=n){
                if((j+t)/n%2==1){
                    if(i==0) v[1][(j+t)%n] = now;
                    else v[0][(j+t)%n] = now;
                }else v[i][(j+t)%n] = now;
            }else v[i][j+t] = now;
        }
    }
    for(int i=0;i<2;i++){
        for(int j=0;j<n;j++){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}