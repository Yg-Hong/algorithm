#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
#include <cmath>

using namespace std;

struct node {
    char left;		//왼쪽 자식노드
    char right; 	//오른쪽 자식노드
};

vector<node> tree(26);

void preorder(char node) {
    if (node == '.')
        return;

    printf("%c", node);
    preorder(tree[node - 65].left);
    preorder(tree[node - 65].right);
}

void inorder(char node) {
    if (node == '.')
        return;
   
    inorder(tree[node - 65].left);
    printf("%c", node);
    inorder(tree[node - 65].right);
}

void postorder(char node) {
    if (node == '.')
        return;

    postorder(tree[node - 65].left);
    postorder(tree[node - 65].right);
    printf("%c", node);     
}


int main() {
    int n;
    scanf("%d", &n);

    char p, lc, rc;
    for (int i = 0;i < n;i++) {
        cin >> p >> lc >> rc;
        tree[p - 65].left = lc;
        tree[p - 65].right = rc;
    }

    preorder('A');
    printf("\n");
    inorder('A');
    printf("\n");
    postorder('A');
}