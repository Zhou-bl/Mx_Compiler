int **a = new int*[30];
int main(){
    for(int i = 0; i <= 29; ++i){
        *a = new int[30];
    }
    for(int i = 0; i <= 29; ++i){
        a[i][0] = 114514;
    }
}