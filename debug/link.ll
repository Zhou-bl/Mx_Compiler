; ModuleID = 'link.bc'
source_filename = "llvm-link"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

@n_global0 = dso_local global i32 0, align 4
@a_global0 = dso_local global i32* null, align 8
@i_global0 = dso_local global i32 0, align 4
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]
@.str = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.1 = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.2 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

define void @Global_init0() {
global_all_bb_bb0:
  call void @global_init_a0()
  ret void
}

define void @global_init_a0() {
a_entry_bb_bb0:
  %mul2 = mul i32 20, 4
  %add6 = add i32 %mul2, 4
  %_call_f__malloc00 = call i8* @_f__malloc0(i32 %add6)
  %_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
  store i32 %mul2, i32* %_call_f__malloc00_BC0, align 4
  %gep3 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
  %gep3_BC0 = bitcast i32* %gep3 to i32*
  store i32* %gep3_BC0, i32** @a_global0, align 8
  br label %a_exit_bb_bb0

a_exit_bb_bb0:                                    ; preds = %a_entry_bb_bb0
  ret void
}

define i32 @main() {
main_bb0:
  %_return.alloc1 = alloca i32, align 8
  %_call_f_getInt00 = call i32 @_f_getInt0()
  store i32 %_call_f_getInt00, i32* @n_global0, align 4
  store i32 0, i32* @i_global0, align 4
  br label %for_condition_bb_bb2

main_bb1:                                         ; preds = %if_then_bb2, %main_bb3
  %_return.load1 = load i32, i32* %_return.alloc1, align 4
  ret i32 %_return.load1

for_condition_bb_bb2:                             ; preds = %for_iter_bb_bb2, %main_bb0
  %n.load1 = load i32, i32* @n_global0, align 4
  %i.load4 = load i32, i32* @i_global0, align 4
  %slt2 = icmp slt i32 %i.load4, %n.load1
  %zext_3 = zext i1 %slt2 to i8
  %trunc_4 = trunc i8 %zext_3 to i1
  br i1 %trunc_4, label %for_body_bb_bb2, label %main_bb2

for_iter_bb_bb2:                                  ; preds = %for_body_bb_bb2
  %i.load5 = load i32, i32* @i_global0, align 4
  %add5 = add i32 %i.load5, 1
  store i32 %add5, i32* @i_global0, align 4
  br label %for_condition_bb_bb2

for_body_bb_bb2:                                  ; preds = %for_condition_bb_bb2
  %_call_f_getInt01 = call i32 @_f_getInt0()
  %i.load6 = load i32, i32* @i_global0, align 4
  %array.load2 = load i32*, i32** @a_global0, align 8
  %gep2 = getelementptr inbounds i32, i32* %array.load2, i32 %i.load6
  store i32 %_call_f_getInt01, i32* %gep2, align 4
  br label %for_iter_bb_bb2

main_bb2:                                         ; preds = %for_condition_bb_bb2
  %n.load2 = load i32, i32* @n_global0, align 4
  store i32 %n.load2, i32* @i_global0, align 4
  br label %for_condition_bb_bb3

for_condition_bb_bb3:                             ; preds = %for_iter_bb_bb3, %main_bb2
  %i.load7 = load i32, i32* @i_global0, align 4
  %sgt1 = icmp sgt i32 %i.load7, 0
  %zext_4 = zext i1 %sgt1 to i8
  %trunc_5 = trunc i8 %zext_4 to i1
  br i1 %trunc_5, label %for_body_bb_bb3, label %main_bb3

for_iter_bb_bb3:                                  ; preds = %main_bb4
  %i.load8 = load i32, i32* @i_global0, align 4
  %sdiv1 = sdiv i32 %i.load8, 2
  store i32 %sdiv1, i32* @i_global0, align 4
  br label %for_condition_bb_bb3

for_body_bb_bb3:                                  ; preds = %for_condition_bb_bb3
  %i.load9 = load i32, i32* @i_global0, align 4
  %_call_f_jud00 = call i32 @_f_jud0(i32 %i.load9)
  %sgt2 = icmp sgt i32 %_call_f_jud00, 0
  %zext_5 = zext i1 %sgt2 to i8
  %trunc_6 = trunc i8 %zext_5 to i1
  br i1 %trunc_6, label %if_then_bb2, label %main_bb4

main_bb3:                                         ; preds = %for_condition_bb_bb3
  store i32 0, i32* %_return.alloc1, align 4
  br label %main_bb1

if_then_bb2:                                      ; preds = %for_body_bb_bb3
  %i.load10 = load i32, i32* @i_global0, align 4
  %_call_f_toString00 = call i8* @_f_toString0(i32 %i.load10)
  call void @_f_print0(i8* %_call_f_toString00)
  store i32 0, i32* %_return.alloc1, align 4
  br label %main_bb1

main_bb4:                                         ; preds = %for_body_bb_bb3
  br label %for_iter_bb_bb3
}

define i32 @_f_jud0(i32 %_arg0) {
_f_jud0_bb0:
  %_return.alloc0 = alloca i32, align 8
  %x.alloc0 = alloca i32, align 8
  store i32 %_arg0, i32* %x.alloc0, align 4
  %i.alloc0 = alloca i32, align 8
  %j.alloc0 = alloca i32, align 8
  store i32 0, i32* %i.alloc0, align 4
  %flag.alloc0 = alloca i8, align 8
  br label %for_condition_bb_bb0

_f_jud0_bb1:                                      ; preds = %if_then_bb1, %_f_jud0_bb2
  %_return.load0 = load i32, i32* %_return.alloc0, align 4
  ret i32 %_return.load0

for_condition_bb_bb0:                             ; preds = %for_iter_bb_bb0, %_f_jud0_bb0
  %x.load0 = load i32, i32* %x.alloc0, align 4
  %n.load0 = load i32, i32* @n_global0, align 4
  %sdiv0 = sdiv i32 %n.load0, %x.load0
  %i.load0 = load i32, i32* %i.alloc0, align 4
  %slt0 = icmp slt i32 %i.load0, %sdiv0
  %zext_0 = zext i1 %slt0 to i8
  %trunc_0 = trunc i8 %zext_0 to i1
  br i1 %trunc_0, label %for_body_bb_bb0, label %_f_jud0_bb2

for_iter_bb_bb0:                                  ; preds = %_f_jud0_bb5
  %i.load1 = load i32, i32* %i.alloc0, align 4
  %add0 = add i32 %i.load1, 1
  store i32 %add0, i32* %i.alloc0, align 4
  br label %for_condition_bb_bb0

for_body_bb_bb0:                                  ; preds = %for_condition_bb_bb0
  store i8 0, i8* %flag.alloc0, align 1
  store i32 0, i32* %j.alloc0, align 4
  br label %for_condition_bb_bb1

_f_jud0_bb2:                                      ; preds = %for_condition_bb_bb0
  store i32 0, i32* %_return.alloc0, align 4
  br label %_f_jud0_bb1

for_condition_bb_bb1:                             ; preds = %for_iter_bb_bb1, %for_body_bb_bb0
  %x.load1 = load i32, i32* %x.alloc0, align 4
  %sub0 = sub i32 %x.load1, 1
  %j.load0 = load i32, i32* %j.alloc0, align 4
  %slt1 = icmp slt i32 %j.load0, %sub0
  %zext_1 = zext i1 %slt1 to i8
  %trunc_1 = trunc i8 %zext_1 to i1
  br i1 %trunc_1, label %for_body_bb_bb1, label %_f_jud0_bb3

for_iter_bb_bb1:                                  ; preds = %_f_jud0_bb4
  %j.load1 = load i32, i32* %j.alloc0, align 4
  %add1 = add i32 %j.load1, 1
  store i32 %add1, i32* %j.alloc0, align 4
  br label %for_condition_bb_bb1

for_body_bb_bb1:                                  ; preds = %for_condition_bb_bb1
  %j.load2 = load i32, i32* %j.alloc0, align 4
  %x.load2 = load i32, i32* %x.alloc0, align 4
  %i.load2 = load i32, i32* %i.alloc0, align 4
  %mul0 = mul i32 %i.load2, %x.load2
  %add2 = add i32 %mul0, %j.load2
  %add3 = add i32 %add2, 1
  %array.load0 = load i32*, i32** @a_global0, align 8
  %gep0 = getelementptr inbounds i32, i32* %array.load0, i32 %add3
  %_array.load0 = load i32, i32* %gep0, align 4
  %j.load3 = load i32, i32* %j.alloc0, align 4
  %x.load3 = load i32, i32* %x.alloc0, align 4
  %i.load3 = load i32, i32* %i.alloc0, align 4
  %mul1 = mul i32 %i.load3, %x.load3
  %add4 = add i32 %mul1, %j.load3
  %array.load1 = load i32*, i32** @a_global0, align 8
  %gep1 = getelementptr inbounds i32, i32* %array.load1, i32 %add4
  %_array.load1 = load i32, i32* %gep1, align 4
  %sgt0 = icmp sgt i32 %_array.load1, %_array.load0
  %zext_2 = zext i1 %sgt0 to i8
  %trunc_2 = trunc i8 %zext_2 to i1
  br i1 %trunc_2, label %if_then_bb0, label %_f_jud0_bb4

_f_jud0_bb3:                                      ; preds = %for_condition_bb_bb1
  %flag.load0 = load i8, i8* %flag.alloc0, align 1
  %xor0 = xor i8 %flag.load0, 1
  %trunc_3 = trunc i8 %xor0 to i1
  br i1 %trunc_3, label %if_then_bb1, label %_f_jud0_bb5

if_then_bb0:                                      ; preds = %for_body_bb_bb1
  store i8 1, i8* %flag.alloc0, align 1
  br label %_f_jud0_bb4

_f_jud0_bb4:                                      ; preds = %if_then_bb0, %for_body_bb_bb1
  br label %for_iter_bb_bb1

if_then_bb1:                                      ; preds = %_f_jud0_bb3
  store i32 1, i32* %_return.alloc0, align 4
  br label %_f_jud0_bb1

_f_jud0_bb5:                                      ; preds = %_f_jud0_bb3
  br label %for_iter_bb_bb0
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_f_getInt0() #0 {
  %1 = alloca i32, align 4
  %2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32* %1)
  %3 = load i32, i32* %1, align 4
  ret i32 %3
}

declare dso_local i32 @__isoc99_scanf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_f_print0(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), i8* %3)
  ret void
}

declare dso_local i32 @printf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_f_println0(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.2, i64 0, i64 0), i8* %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_f_printInt0(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32 %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_f_printlnInt0(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i64 0, i64 0), i32 %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_f_toString0(i32 %0) #0 {
  %2 = alloca i32, align 4
  %3 = alloca i8*, align 8
  store i32 %0, i32* %2, align 4
  %4 = call noalias i8* @malloc(i64 20) #5
  store i8* %4, i8** %3, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i32, i32* %2, align 4
  %7 = call i32 (i8*, i8*, ...) @sprintf(i8* %5, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32 %6) #5
  %8 = load i8*, i8** %3, align 8
  ret i8* %8
}

; Function Attrs: nounwind
declare dso_local noalias i8* @malloc(i64) #2

; Function Attrs: nounwind
declare dso_local i32 @sprintf(i8*, i8*, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_f_getString0() #0 {
  %1 = alloca i8*, align 8
  %2 = call noalias i8* @malloc(i64 256) #5
  store i8* %2, i8** %1, align 8
  %3 = load i8*, i8** %1, align 8
  %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), i8* %3)
  %5 = load i8*, i8** %1, align 8
  ret i8* %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_f__malloc0(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = sext i32 %3 to i64
  %5 = call noalias i8* @malloc(i64 %4) #5
  ret i8* %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_ne0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp ne i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: nounwind readonly
declare dso_local i32 @strcmp(i8*, i8*) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_eq0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp eq i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_le0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp sle i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_lt0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp slt i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_ge0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp sge i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string__str_gt0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #6
  %8 = icmp sgt i32 %7, 0
  %9 = zext i1 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string_length0(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i64 @strlen(i8* %3) #6
  %5 = trunc i64 %4 to i32
  ret i32 %5
}

; Function Attrs: nounwind readonly
declare dso_local i64 @strlen(i8*) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string_ord0(i8* %0, i32 %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i32, align 4
  store i8* %0, i8** %3, align 8
  store i32 %1, i32* %4, align 4
  %5 = load i8*, i8** %3, align 8
  %6 = load i32, i32* %4, align 4
  %7 = sext i32 %6 to i64
  %8 = getelementptr inbounds i8, i8* %5, i64 %7
  %9 = load i8, i8* %8, align 1
  %10 = sext i8 %9 to i32
  ret i32 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_class_string_parseInt0(i8* %0) #0 {
  %2 = alloca i8*, align 8
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  store i8* %0, i8** %2, align 8
  store i32 0, i32* %3, align 4
  store i32 0, i32* %4, align 4
  br label %5

5:                                                ; preds = %13, %1
  %6 = load i8*, i8** %2, align 8
  %7 = load i32, i32* %4, align 4
  %8 = sext i32 %7 to i64
  %9 = getelementptr inbounds i8, i8* %6, i64 %8
  %10 = load i8, i8* %9, align 1
  %11 = sext i8 %10 to i32
  %12 = icmp ne i32 %11, 0
  br i1 %12, label %13, label %24

13:                                               ; preds = %5
  %14 = load i32, i32* %3, align 4
  %15 = mul nsw i32 %14, 10
  %16 = load i8*, i8** %2, align 8
  %17 = load i32, i32* %4, align 4
  %18 = sext i32 %17 to i64
  %19 = getelementptr inbounds i8, i8* %16, i64 %18
  %20 = load i8, i8* %19, align 1
  %21 = sext i8 %20 to i32
  %22 = add nsw i32 %15, %21
  %23 = sub nsw i32 %22, 48
  store i32 %23, i32* %3, align 4
  br label %5

24:                                               ; preds = %5
  %25 = load i32, i32* %3, align 4
  ret i32 %25
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_class_string_substring0(i8* %0, i32 %1, i32 %2) #0 {
  %4 = alloca i8*, align 8
  %5 = alloca i32, align 4
  %6 = alloca i32, align 4
  %7 = alloca i8*, align 8
  store i8* %0, i8** %4, align 8
  store i32 %1, i32* %5, align 4
  store i32 %2, i32* %6, align 4
  %8 = load i32, i32* %6, align 4
  %9 = load i32, i32* %5, align 4
  %10 = sub nsw i32 %8, %9
  %11 = add nsw i32 %10, 1
  %12 = sext i32 %11 to i64
  %13 = mul i64 1, %12
  %14 = call noalias i8* @malloc(i64 %13) #5
  store i8* %14, i8** %7, align 8
  %15 = load i8*, i8** %7, align 8
  %16 = load i8*, i8** %4, align 8
  %17 = load i32, i32* %5, align 4
  %18 = sext i32 %17 to i64
  %19 = getelementptr inbounds i8, i8* %16, i64 %18
  %20 = load i32, i32* %6, align 4
  %21 = load i32, i32* %5, align 4
  %22 = sub nsw i32 %20, %21
  %23 = sext i32 %22 to i64
  call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %15, i8* align 1 %19, i64 %23, i1 false)
  %24 = load i8*, i8** %7, align 8
  %25 = load i32, i32* %6, align 4
  %26 = load i32, i32* %5, align 4
  %27 = sub nsw i32 %25, %26
  %28 = sext i32 %27 to i64
  %29 = getelementptr inbounds i8, i8* %24, i64 %28
  store i8 0, i8* %29, align 1
  %30 = load i8*, i8** %7, align 8
  ret i8* %30
}

; Function Attrs: argmemonly nounwind willreturn
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg) #4

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_class_string_splice0(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  %5 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %6 = load i8*, i8** %3, align 8
  %7 = call i64 @strlen(i8* %6) #6
  %8 = load i8*, i8** %4, align 8
  %9 = call i64 @strlen(i8* %8) #6
  %10 = add i64 %7, %9
  %11 = add i64 %10, 1
  %12 = mul i64 1, %11
  %13 = call noalias i8* @malloc(i64 %12) #5
  store i8* %13, i8** %5, align 8
  %14 = load i8*, i8** %5, align 8
  %15 = load i8*, i8** %3, align 8
  %16 = call i8* @strcpy(i8* %14, i8* %15) #5
  %17 = load i8*, i8** %5, align 8
  %18 = load i8*, i8** %4, align 8
  %19 = call i8* @strcat(i8* %17, i8* %18) #5
  %20 = load i8*, i8** %5, align 8
  ret i8* %20
}

; Function Attrs: nounwind
declare dso_local i8* @strcpy(i8*, i8*) #2

; Function Attrs: nounwind
declare dso_local i8* @strcat(i8*, i8*) #2

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #2 = { nounwind "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #3 = { nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #4 = { argmemonly nounwind willreturn }
attributes #5 = { nounwind }
attributes #6 = { nounwind readonly }

!llvm.ident = !{!0}
!llvm.module.flags = !{!1}

!0 = !{!"clang version 10.0.0-4ubuntu1 "}
!1 = !{i32 1, !"wchar_size", i32 4}
