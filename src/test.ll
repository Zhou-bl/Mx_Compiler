@_str_constant0 = private unnamed_addr constant [2 x i8] c" \00", align 1
@_str_constant1 = private unnamed_addr constant [8 x i8] c"Total: \00", align 1
@N_global0 = dso_local global i32 zeroinitializer, align 4
@b_global0 = dso_local global i8* zeroinitializer, align 8
@resultCount_global0 = dso_local global i32 zeroinitializer, align 4
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]
define void @global_init_N0() {
N_entry_bb_bb0:
	store i32 15000, i32* @N_global0, align 4
	br label %N_exit_bb_bb0
N_exit_bb_bb0:					 ;preds = %N_entry_bb_bb0
	ret void
}
define void @global_init_b0() {
b_entry_bb_bb0:
	%mul2 = mul i32 15001, 1
	%add4 = add i32 %mul2, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add4)
	%_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
	store i32 %mul2, i32* %_call_f__malloc00_BC0, align 4
	%gep6 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
	%gep6_BC0 = bitcast i32* %gep6 to i8*
	store i8* %gep6_BC0, i8** @b_global0, align 8
	br label %b_exit_bb_bb0
b_exit_bb_bb0:					 ;preds = %b_entry_bb_bb0
	ret void
}
define void @global_init_resultCount0() {
resultCount_entry_bb_bb0:
	store i32 0, i32* @resultCount_global0, align 4
	br label %resultCount_exit_bb_bb0
resultCount_exit_bb_bb0:					 ;preds = %resultCount_entry_bb_bb0
	ret void
}
define void @Global_init0() {
global_all_bb_bb0:
	call void @global_init_N0()
	call void @global_init_b0()
	call void @global_init_resultCount0()
	ret void
}
declare i8* @_f__str_splice0(i8*, i8*)
define i32 @main() {
main_bb0:
	%_return.alloc0 = alloca i32, align 8
	%i.alloc0 = alloca i32, align 8
	store i32 1, i32* %i.alloc0, align 4
	%count.alloc0 = alloca i32, align 8
	%sc_tmp_address_logic_and.alloc0 = alloca i8, align 8
	br label %for_condition_bb_bb0
main_bb1:					 ;preds = %main_bb3
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
for_condition_bb_bb0:					 ;preds = %main_bb0, %for_iter_bb_bb0
	%N.load0 = load i32, i32* @N_global0, align 4
	%i.load0 = load i32, i32* %i.alloc0, align 4
	%sle0 = icmp sle i32 %i.load0, %N.load0
	%zext_0 = zext i1 %sle0 to i8
	%trunc_0 = trunc i8 %zext_0 to i1
	br i1 %trunc_0, label %for_body_bb_bb0, label %main_bb2
for_iter_bb_bb0:					 ;preds = %for_body_bb_bb0
	%i.load1 = load i32, i32* %i.alloc0, align 4
	%add0 = add i32 %i.load1, 1
	store i32 %add0, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb0
for_body_bb_bb0:					 ;preds = %for_condition_bb_bb0
	%i.load2 = load i32, i32* %i.alloc0, align 4
	%array.load0 = load i8*, i8** @b_global0, align 8
	%gep0 = getelementptr inbounds i8, i8* %array.load0, i32 %i.load2
	store i8 1, i8* %gep0, align 1
	br label %for_iter_bb_bb0
main_bb2:					 ;preds = %for_condition_bb_bb0
	store i32 2, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb1
for_condition_bb_bb1:					 ;preds = %main_bb2, %for_iter_bb_bb1
	%N.load1 = load i32, i32* @N_global0, align 4
	%i.load3 = load i32, i32* %i.alloc0, align 4
	%sle1 = icmp sle i32 %i.load3, %N.load1
	%zext_1 = zext i1 %sle1 to i8
	%trunc_1 = trunc i8 %zext_1 to i1
	br i1 %trunc_1, label %for_body_bb_bb1, label %main_bb3
for_iter_bb_bb1:					 ;preds = %main_bb4
	%i.load4 = load i32, i32* %i.alloc0, align 4
	%add1 = add i32 %i.load4, 1
	store i32 %add1, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb1
for_body_bb_bb1:					 ;preds = %for_condition_bb_bb1
	%i.load5 = load i32, i32* %i.alloc0, align 4
	%array.load1 = load i8*, i8** @b_global0, align 8
	%gep1 = getelementptr inbounds i8, i8* %array.load1, i32 %i.load5
	%_array.load0 = load i8, i8* %gep1, align 1
	%trunc_2 = trunc i8 %_array.load0 to i1
	br i1 %trunc_2, label %if_then_bb0, label %main_bb4
main_bb3:					 ;preds = %for_condition_bb_bb1
	%resultCount.load1 = load i32, i32* @resultCount_global0, align 4
	%_call_f_toString02 = call i8* @_f_toString0(i32 %resultCount.load1)
	%gep5 = getelementptr inbounds [8 x i8], [8 x i8]* @_str_constant1, i32 0, i32 0
	%_call_f__str_splice02 = call i8* @_f__str_splice0([8 x i8]* @_str_constant1, i8* %_call_f_toString02)
	call void @_f_println0(i8* %_call_f__str_splice02)
	store i32 0, i32* %_return.alloc0, align 4
	br label %main_bb1
if_then_bb0:					 ;preds = %for_body_bb_bb1
	store i32 2, i32* %count.alloc0, align 4
	%i.load6 = load i32, i32* %i.alloc0, align 4
	%sgt0 = icmp sgt i32 %i.load6, 3
	%zext_2 = zext i1 %sgt0 to i8
	%trunc_3 = trunc i8 %zext_2 to i1
	br i1 %trunc_3, label %long_block_bb0, label %short_block_bb0
main_bb4:					 ;preds = %for_body_bb_bb1, %main_bb6
	br label %for_iter_bb_bb1
if_then_bb1:					 ;preds = %terminal_block_bb0
	%resultCount.load0 = load i32, i32* @resultCount_global0, align 4
	%add2 = add i32 %resultCount.load0, 1
	store i32 %add2, i32* @resultCount_global0, align 4
	%i.load8 = load i32, i32* %i.alloc0, align 4
	%_call_f_toString00 = call i8* @_f_toString0(i32 %i.load8)
	%i.load9 = load i32, i32* %i.alloc0, align 4
	%sub1 = sub i32 %i.load9, 2
	%_call_f_toString01 = call i8* @_f_toString0(i32 %sub1)
	%gep3 = getelementptr inbounds [2 x i8], [2 x i8]* @_str_constant0, i32 0, i32 0
	%_call_f__str_splice00 = call i8* @_f__str_splice0(i8* %_call_f_toString01, [2 x i8]* @_str_constant0)
	%_call_f__str_splice01 = call i8* @_f__str_splice0(i8* %_call_f__str_splice00, i8* %_call_f_toString00)
	call void @_f_println0(i8* %_call_f__str_splice01)
	br label %main_bb5
main_bb5:					 ;preds = %terminal_block_bb0, %if_then_bb1
	br label %while_condition_bb_bb0
short_block_bb0:					 ;preds = %if_then_bb0
	store i8 %zext_2, i8* %sc_tmp_address_logic_and.alloc0, align 1
	br label %terminal_block_bb0
long_block_bb0:					 ;preds = %if_then_bb0
	%i.load7 = load i32, i32* %i.alloc0, align 4
	%sub0 = sub i32 %i.load7, 2
	%array.load2 = load i8*, i8** @b_global0, align 8
	%gep2 = getelementptr inbounds i8, i8* %array.load2, i32 %sub0
	%_array.load1 = load i8, i8* %gep2, align 1
	store i8 %_array.load1, i8* %sc_tmp_address_logic_and.alloc0, align 1
	br label %terminal_block_bb0
terminal_block_bb0:					 ;preds = %short_block_bb0, %long_block_bb0
	%sc_terminal_address.load0 = load i8, i8* %sc_tmp_address_logic_and.alloc0, align 1
	%trunc_4 = trunc i8 %sc_terminal_address.load0 to i1
	br i1 %trunc_4, label %if_then_bb1, label %main_bb5
while_condition_bb_bb0:					 ;preds = %main_bb5, %while_body_bb_bb0
	%N.load2 = load i32, i32* @N_global0, align 4
	%count.load0 = load i32, i32* %count.alloc0, align 4
	%i.load10 = load i32, i32* %i.alloc0, align 4
	%mul0 = mul i32 %i.load10, %count.load0
	%sle2 = icmp sle i32 %mul0, %N.load2
	%zext_3 = zext i1 %sle2 to i8
	%trunc_5 = trunc i8 %zext_3 to i1
	br i1 %trunc_5, label %while_body_bb_bb0, label %main_bb6
while_body_bb_bb0:					 ;preds = %while_condition_bb_bb0
	%count.load1 = load i32, i32* %count.alloc0, align 4
	%i.load11 = load i32, i32* %i.alloc0, align 4
	%mul1 = mul i32 %i.load11, %count.load1
	%array.load3 = load i8*, i8** @b_global0, align 8
	%gep4 = getelementptr inbounds i8, i8* %array.load3, i32 %mul1
	store i8 0, i8* %gep4, align 1
	%count.load2 = load i32, i32* %count.alloc0, align 4
	%add3 = add i32 %count.load2, 1
	store i32 %add3, i32* %count.alloc0, align 4
	br label %while_condition_bb_bb0
main_bb6:					 ;preds = %while_condition_bb_bb0
	br label %main_bb4
}
declare void @_f_println0(i8*)
declare i8* @_f_toString0(i32)
declare i8* @_f__malloc0(i32)

