#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

const int STR_BUF_SIZE = 256;
const int INT_BUF_SIZE = 20;

char* _f__heap_malloc(int size) { return malloc(size); }
char* _f__string_merge(char* s1, char* s2) {
    char* s = malloc(strlen(s1) + strlen(s2) + 1);
    strcpy(s, s1);
    strcat(s, s2);
    return s;
}
bool _f__stringcmp_eq(char* s1, char* s2) { return strcmp(s1, s2) == 0; }
bool _f__stringcmp_neq(char* s1, char* s2) { return strcmp(s1, s2) != 0; }
bool _f__stringcmp_less(char* s1, char* s2) { return strcmp(s1, s2) < 0; }
bool _f__stringcmp_leq(char* s1, char* s2) { return strcmp(s1, s2) <= 0; }
bool _f__stringcmp_greater(char* s1, char* s2) { return strcmp(s1, s2) > 0; }
bool _f__stringcmp_geq(char* s1, char* s2) { return strcmp(s1, s2) >= 0; }
int  _class_string_length(char* s) { return strlen(s); }
char* _class_string_substring(char* s, int start, int end) {
    char* sub = malloc(end - start + 1);
    strncpy(sub, s + start, end - start);
    sub[end - start] = '\0';
    return sub;
}
int _class_string_parseInt(char* s) { return atoi(s); }
int _class_string_ord(char* s, int i) { return s[i]; }

void _f_print(char* str) { printf("%s", str); }
void _f_println(char* str) { printf("%s\n", str); }
void _f_printInt(int i) { printf("%d", i); }
void _f_printlnInt(int i) { printf("%d\n", i); }

char* _f_getString() {
    char* buf = (char*)malloc(256);
    scanf("%s", buf);
    return buf;
}
int _f_getInt() {
    int i;
    scanf("%d", &i);
    return i;
}
char* _f_toString(int i) {
    char* buf = (char*)malloc(12);
    sprintf(buf, "%d", i);
    return buf;
}