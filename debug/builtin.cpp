#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void _f_print0(char *str) { printf("%s", str); }

void _f_println0(char *str) { printf("%s\n", str); }

void _f_printInt0(int n) { printf("%d", n); }

void _f_printlnInt0(int n) { printf("%d\n", n); }

int _f_getInt0() {
  int n;
  scanf("%d", &n);
  return n;
}

char *_f_getString0() {
  char *str = malloc(sizeof(char) * 256);
  scanf("%s", str);
  return str;
}

char *_f_toString0(int n) {
  char *str = malloc(20);
  sprintf(str, "%d", n);
  return str;
}

char *_f_malloc0(int mallocSize) { return malloc(mallocSize); }

char *_f_string_substring0(char *str, int start, int end) {
  char *substr = malloc(sizeof(char) * (end - start + 1));
  memcpy(substr, str + start, end - start);
  substr[end - start] = '\0';
  return substr;
}

int _string_length0(char *str) { return strlen(str); }

int _string_parseInt0(char *str) {
  int n;
  sscanf(str, "%d", &n);
  return n;
}

int _string_ord0(char *str, int index) { return str[index]; }

char *_string_concat0(char *str1, char *str2) {
  char *str = malloc(sizeof(char) * (strlen(str1) + strlen(str2) + 1));
  strcpy(str, str1);
  strcat(str, str2);
  // sprintf(str, "%s%s", str1, str2);
  return str;
}