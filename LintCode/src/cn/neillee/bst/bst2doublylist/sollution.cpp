# include<stdio.h>
# include<stdlib.h>

typedef struct Node{
	int val;
	Node* pre;
	Node* nxt;
}Node;

typedef struct Tree{
	int val;
	Tree* left;
	Tree* rght;
}Tree;

Node* reverseDLR(Tree* pTree);
Node* reverseLDR(Tree* pTree);
Node* reverseLRD(Tree* pTree);
Node* tail(Node* pNode);
Tree* initTree();
void printNodeList(Node* pNode);
void freeNodeList(Node* pNode);
void freeTree(Tree* pTree);
void msetTree(Tree *pHead);
Node * mallocNode();
Tree * mallocTree();
void printTree(Tree* pTree);

int main(){
	Tree* pTree = initTree();
	printTree(pTree);
	Node* pNodeDLR = reverseDLR(pTree);
//	Node* pNodeLDR = reverseLDR(pTree);
//	Node* pNodeLRD = reverseLRD(pTree);
	freeTree(pTree);
	printf("DLR:");
	printNodeList(pNodeDLR);
//	printf("\nLDR:");
//	printNodeList(pNodeLDR);
//	printf("\nLRD:");
//	printNodeList(pNodeLRD);
	freeNodeList(pNodeDLR);
//	freeNodeList(pNodeLDR);
//	freeNodeList(pNodeLRD);
}

Node* reverseDLR(Tree* pTree){
	Node* pNode = mallocNode();
	pNode->val = pTree->val;
	if(pTree->left){
		printf("%d",pNode->val);
		pNode->nxt = reverseDLR(pTree->left);
		pNode->nxt->pre = pNode;
	}
	if(pTree->rght){
		Node* ptail = tail(pNode);
		ptail->nxt = reverseDLR(pTree->rght);
		ptail->nxt->pre = ptail;
	}
	return pNode;
}

Node* reverseLDR(Tree* pTree){
	Node* pNode = mallocNode();
	Node* ptail;
	Node* phead;
	if(pTree->left != NULL){
		phead = reverseDLR(pTree->left);
		ptail = tail(phead);
		ptail->nxt = pNode;
		ptail->nxt->pre = pNode;
	}
	if(pTree->rght != NULL){
		pNode->nxt = reverseDLR(pTree->rght);
		ptail->nxt->pre = ptail;
	}
	return phead;
}

Node* reverseLRD(Tree* pTree){
	Node* pNode = mallocNode();
	if(pTree->rght != NULL){
		Node* head = reverseDLR(pTree->rght);
		Node* ptail = tail(head);
		pNode->pre = ptail;
		pNode->pre->nxt = pNode;
		pNode = head;
	}
	if(pTree->left != NULL){
		Node* head = reverseDLR(pTree->left);
		Node* ptail = tail(head);
		pNode->pre = ptail;
		pNode->pre->nxt = pNode;
		pNode = head;
	}
	return pNode;
}

Node* tail(Node* pNode){
	while(pNode->nxt != NULL){
		pNode = pNode->nxt;
	}
	return pNode;
}

Tree* initTree(){
	Tree *pHead = mallocTree();
	pHead->val = 4;
	pHead->left = mallocTree();
	pHead->rght = mallocTree();
	pHead->rght->val = 5;
	pHead->left->val = 2;
	pHead->left->left = mallocTree();
	pHead->left->left->val = 1;
	pHead->left->rght = mallocTree();
	pHead->left->rght->val = 3;
}

void printTree(Tree* pTree){
	if(pTree->left) printTree(pTree->left);
	if(pTree->rght) printTree(pTree->rght);
	printf("$%d\n",pTree->val);
}

Tree * mallocTree(){
	Tree* tree = (Tree*)malloc(sizeof(Tree));
	tree->val = -1;
	tree->left = NULL;
	tree->rght = NULL;
}

Node * mallocNode(){
	Node* node = (Node*)malloc(sizeof(Node));
	node->val = -1;
	node->pre = NULL;
	node->nxt = NULL;
}


void msetTree(Tree *pHead){
	pHead->val = -1;
	pHead->left = NULL;
	pHead->rght = NULL;
}

void printNodeList(Node* pNode){
	while(pNode != NULL){
		printf("%d,", pNode->val);
		pNode = pNode->nxt;
	}
}

void freeTree(Tree* pTree){
	if(pTree->left != NULL) freeTree(pTree->left);
	if(pTree->rght != NULL) freeTree(pTree->rght);
	free(pTree);
}

void freeNodeList(Node* pNode){
	if(pNode->nxt != NULL) freeNodeList(pNode->nxt);
	free(pNode);
}

