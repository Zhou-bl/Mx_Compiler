//
// Created by zbl on 2022/12/10.
//
int _f_getInt0(){
    int n;
    scanf("%d", &n);
    return n;
}
void _f_print0(char *str){ printf("%s", str); }
void _f_println0(char *str){ printf("%s\n", str); }
void _f_printInt0(int n){ printf("%d", n); }
void _f_printlnInt0(int n){ printf("%d\n", n); }
char *_f_toString0(int n){
    char *str = malloc(13);
    sprintf(str, "%d", n);
    return str;
}
char *_f_getString0(){
    char *str = malloc(sizeof (char) * 256);//最多256位
    scanf("%s", str);
    return str;
}
char *_f__malloc0(int mallocSize){ return malloc(mallocSize); }
char _f__str_ne0(char* left, char* right){return strcmp(left, right) != 0;}
char _f__str_eq0(char* left, char* right){return strcmp(left, right) == 0;}
char __f__str_le0(char* left, char* right){return strcmp(left, right) <= 0;}
char _f__str_lt0(char* left, char* right){return strcmp(left, right) < 0;}
char _f__str_ge0(char* left, char* right){return strcmp(left, right) >= 0;}
char _f__str_gt0(char* left, char* right){return strcmp(left, right) > 0;}
char* _f__str_splice0(char* str1, char* str2){
    char *splice_str = malloc(sizeof (char) * (strlen(str1) + strlen(str2) + 1));
    strcpy(splice_str, str1);
    strcat(splice_str, str2);
    return splice_str;
}

int _class_string_length0(char* str){return strlen(str);}
int _class_string_ord0(char* str, int pos){return (int)str[pos];}
int _class_string_parseInt0(char* str){
    //return atoi(str);
    int ans=0,i=0;
    	while(str[i]!='\0'){
    		ans=ans*10+str[i]-'0';
    		i++;
    	}
    	return ans;
}
char* _class_string_substring0(char* str, int l, int r){
    char *substr = malloc(sizeof (char) * (r - l + 1));
    memcpy(substr, str + l, r - l);
    substr[r - l] = '\0';
    return substr;
}

/*
//_f_getInt0
//_f_print0
//_f_println0
//_f_printInt0
//_f_printlnInt0
//_f_toString0
//_f_getString0
//_f__malloc0
//_class_string__str_lt0
//_class_string_parseInt0
//_class_string_ord0
//_class_string__str_ne0
//_class_string__str_le0
//_class_string__str_splice0
//_class_string_length0
//_class_string__str_eq0
//_class_string_substring0
//_class_string__str_ge0
*/