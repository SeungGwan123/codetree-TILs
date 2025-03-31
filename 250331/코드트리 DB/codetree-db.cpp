#include <iostream>
#include <map>
#include <string>

#define max_val 1000000000
using namespace std;

struct Leaf {
    int val;
    string name;
    Leaf(int v, string n) : val(v), name(n) {};
};

struct Node {
    int min;
    int max;
    int sum;
    Node* left;
    Node* right;
    Node* parents;
    Leaf* leaf;
    Node(int _min, int _max) : min(_min), max(_max), sum(0), left(NULL), right(NULL), leaf(NULL) {};
};

void delete_all(Node* cur) {
    if(!cur) return;
    delete_all(cur->left);
    delete_all(cur->right);
    delete cur->leaf;
    delete cur;
}

void _init(map<string, int>& name2val, map<int, string>& val2name, Node* root) {
    delete_all(root->left);
    delete_all(root->right);
    root->left = NULL;
    root->right = NULL;
    root->leaf = NULL;
    name2val.clear();
    val2name.clear();
}

int _insert(map<string, int>& name2val, map<int, string>& val2name, Node* root) {
    string name;
    int val;
    cin >> name >> val;
    if(name2val.find(name)!=name2val.end()) return 0;
    if(val2name.find(val)!=val2name.end()) return 0;
    name2val[name] = val;
    val2name[val] = name;
    Node* cur = root;
    Leaf* leaf = new Leaf(val, name);
    while(cur->min!=cur->max) {
        cur->sum += val;
        int mid = (cur->min + cur->max) / 2;
        if(val<=mid) {
            if(!cur->left) {
                Node* node = new Node(cur->min, mid);
                cur->left = node;
                node->parents = cur;
            }
            cur = cur->left;
        }
        else {
            if(!cur->right) {
                Node* node = new Node(mid+1, cur->max);
                cur->right = node;
                node->parents = cur;
            }
            cur = cur->right;
        }
    }
    cur->sum = val;
    cur->leaf = leaf;
    return 1;
}

int _delete(map<string, int>& name2val, map<int, string>& val2name, Node* root) {
    string name;
    int val;
    cin >> name;
    if(name2val.find(name)==name2val.end()) return 0;
    val = name2val[name];
    name2val.erase(name);
    val2name.erase(val);
    Node* cur = root;
    while(cur->min!=cur->max) {
        cur->sum -= val;
        int mid = (cur->min + cur->max) / 2;
        if(val<=mid) cur = cur->left;
        else cur = cur->right;
    }
    cur->sum = 0;
    delete cur->leaf;
    cur->leaf = NULL;
    while(cur!=root) {
        Node* par = cur->parents;
        if(!cur->left && !cur->right) {
            if(par->left==cur) {
                par->left = NULL;
            }
            if(par->right==cur) {
                par->right = NULL;
            }
            delete cur;
        }
        else {
            break;
        }
        cur = par;
    }
    return val;
}

string _rank(map<int, string>& val2name) {
    int k;
    cin >> k;
    if(val2name.size()<k) return "None";
    auto it = val2name.begin();
    advance(it, k-1);
    return it->second;
}

long long _sum(Node* root) {
    long long ret = 0;
    int k;
    cin >> k;
    Node* cur = root;
    while(cur->min!=cur->max) {
        int mid = (cur->min + cur->max) / 2;
        if(k<=mid) {
            if(!cur->left) break;
            cur = cur->left;
        }
        else {
            if(cur->left) {
                ret += cur->left->sum;
            }
            if(!cur->right) break;
            cur = cur->right;
        }
    }
    if(cur->leaf) ret += cur->sum;
    return ret;
}

int main() {
    int n;
    string cmd;
    Node* root = new Node(0, max_val);
    map<string, int> name2val;
    map<int, string> val2name;
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> cmd;
        if(cmd=="init") _init(name2val, val2name, root);
        if(cmd=="insert") cout << _insert(name2val, val2name, root) << endl;
        if(cmd=="delete") cout << _delete(name2val, val2name, root) << endl;
        if(cmd=="rank") cout << _rank(val2name) << endl;
        if(cmd=="sum") cout << _sum(root) << endl;
    }
    return 0;
}