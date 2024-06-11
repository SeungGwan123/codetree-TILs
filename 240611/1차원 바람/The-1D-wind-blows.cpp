#include <iostream>
#include <bits/stdc++.h>

using namespace std;

//check true : 왼 false : 오
vector<int> move(vector<int> v,int n,bool check){
    vector<int> temp = v;
    for(int i=0;i<v.size();i++){
        if(check) temp[(i+n)%v.size()] = v[i];
        else temp[((i-n)+v.size())%v.size()] = v[i];
    }
    return temp;
}
int main() {
    int n;int m;int q;int num;char d;
    cin>>n>>m>>q;
    vector<int> v[n];
    int line = 0;
    for(int i=0;i<n*m;i++){
        int temp;
        cin>>temp;
        v[line].push_back(temp);
        if(i%m==m-1)line++;
    }
    for(int Q=0;Q<q;Q++){
        cin>>num>>d;
        num--;
        bool dir = false;
        if(d=='L') dir = true;
        v[num] = move(v[num],1,dir);
        bool up_dir = !dir;
        int up_line = num;
        bool down_dir = !dir;
        int down_line = num;
        while(up_line>0){
            bool check = false;
            for(int i=0;i<v[up_line].size();i++){
                if(v[up_line][i]==v[up_line-1][i]){
                    check = true;
                    break;
                }
            }
            if(check){
                v[up_line-1] = move(v[up_line-1],1,up_dir);
                up_dir = !up_dir;
                up_line--;
            }else break;
        }
        while(down_line<n-1){
            bool check = false;
            for(int i=0;i<v[down_line].size();i++){
                if(v[down_line][i]==v[down_line+1][i]){
                    check = true;
                    break;
                }
            }
            if(check){
                v[down_line+1] = move(v[down_line+1],1,down_dir);
                down_dir = !down_dir;
                down_line++;
            }else break;
        }
    }
    for(auto iter : v){
        for(auto element : iter){
            cout<<element<<" ";
        }
        cout<<endl;
    }
    return 0;
}