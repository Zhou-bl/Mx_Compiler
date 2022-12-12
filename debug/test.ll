@_str_constant0 = private unnamed_addr constant [2 x i8] c" \00", align 1
@_str_constant1 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1
@n_global0 = dso_local global i32 zeroinitializer, align 4
@a_global0 = dso_local global i32* zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]
define void @global_init_a0() {
a_entry_bb_bb0:
	store i32* null, i32** @a_global0, align 8
	br label %a_exit_bb_bb0
a_exit_bb_bb0:					 ;preds = %a_entry_bb_bb0
	ret void
}
define void @Global_init0() {
global_all_bb_bb0:
	call void @global_init_a0()
	ret void
}
declare i8* @_f__str_splice0(i8*, i8*)
define i32 @main() {
main_bb0:
	%_return.alloc3 = alloca i32, align 8
	%i.alloc2 = alloca i32, align 8
	%_call_f_getString00 = call i8* @_f_getString0()
	%_call_class_string_parseInt00 = call i32 @_class_string_parseInt0(i8* %_call_f_getString00)
	store i32 %_call_class_string_parseInt00, i32* @n_global0, align 4
	%n.load8 = load i32, i32* @n_global0, align 4
	%mul11 = mul i32 %n.load8, 4
	%add7 = add i32 %mul11, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add7)
	%_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
	store i32 %n.load8, i32* %_call_f__malloc00_BC0, align 4
	%gep20 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
	%gep20_BC0 = bitcast i32* %gep20 to i32*
	store i32* %gep20_BC0, i32** @a_global0, align 8
	store i32 0, i32* %i.alloc2, align 4
	br label %for_condition_bb_bb1
main_bb1:					 ;preds = %main_bb3
	%_return.load3 = load i32, i32* %_return.alloc3, align 4
	ret i32 %_return.load3
for_condition_bb_bb1:					 ;preds = %main_bb0, %for_iter_bb_bb1
	%a.load0 = load i32*, i32** @a_global0, align 8
	%a.load0_BC0 = bitcast i32* %a.load0 to i32*
	%gep21 = getelementptr inbounds i32, i32* %a.load0_BC0, i32 -1
	%array_size.load0 = load i32, i32* %gep21, align 4
	%i.load18 = load i32, i32* %i.alloc2, align 4
	%slt6 = icmp slt i32 %i.load18, %array_size.load0
	%zext_9 = zext i1 %slt6 to i8
	%trunc_9 = trunc i8 %zext_9 to i1
	br i1 %trunc_9, label %for_body_bb_bb1, label %main_bb2
for_iter_bb_bb1:					 ;preds = %for_body_bb_bb1
	%i.load21 = load i32, i32* %i.alloc2, align 4
	%add8 = add i32 %i.load21, 1
	store i32 %add8, i32* %i.alloc2, align 4
	br label %for_condition_bb_bb1
for_body_bb_bb1:					 ;preds = %for_condition_bb_bb1
	%i.load19 = load i32, i32* %i.alloc2, align 4
	%i.load20 = load i32, i32* %i.alloc2, align 4
	%array.load34 = load i32*, i32** @a_global0, align 8
	%gep22 = getelementptr inbounds i32, i32* %array.load34, i32 %i.load20
	store i32 %i.load19, i32* %gep22, align 4
	br label %for_iter_bb_bb1
main_bb2:					 ;preds = %for_condition_bb_bb1
	%_call_f_makeHeap00 = call i32 @_f_makeHeap0()
	%_call_f_heapSort00 = call i32 @_f_heapSort0()
	store i32 0, i32* %i.alloc2, align 4
	br label %for_condition_bb_bb2
for_condition_bb_bb2:					 ;preds = %main_bb2, %for_iter_bb_bb2
	%a.load1 = load i32*, i32** @a_global0, align 8
	%a.load1_BC0 = bitcast i32* %a.load1 to i32*
	%gep23 = getelementptr inbounds i32, i32* %a.load1_BC0, i32 -1
	%array_size.load1 = load i32, i32* %gep23, align 4
	%i.load22 = load i32, i32* %i.alloc2, align 4
	%slt7 = icmp slt i32 %i.load22, %array_size.load1
	%zext_10 = zext i1 %slt7 to i8
	%trunc_10 = trunc i8 %zext_10 to i1
	br i1 %trunc_10, label %for_body_bb_bb2, label %main_bb3
for_iter_bb_bb2:					 ;preds = %for_body_bb_bb2
	%i.load24 = load i32, i32* %i.alloc2, align 4
	%add9 = add i32 %i.load24, 1
	store i32 %add9, i32* %i.alloc2, align 4
	br label %for_condition_bb_bb2
for_body_bb_bb2:					 ;preds = %for_condition_bb_bb2
	%i.load23 = load i32, i32* %i.alloc2, align 4
	%array.load35 = load i32*, i32** @a_global0, align 8
	%gep24 = getelementptr inbounds i32, i32* %array.load35, i32 %i.load23
	%array.load36 = load i32, i32* %gep24, align 4
	%_call_f_toString00 = call i8* @_f_toString0(i32 %array.load36)
	%gep25 = getelementptr inbounds [2 x i8], [2 x i8]* @_str_constant0, i32 0, i32 0
	%_call_f__str_splice00 = call i8* @_f__str_splice0(i8* %_call_f_toString00, i8* %gep25)
	call void @_f_print0(i8* %_call_f__str_splice00)
	br label %for_iter_bb_bb2
main_bb3:					 ;preds = %for_condition_bb_bb2
	%gep26 = getelementptr inbounds [2 x i8], [2 x i8]* @_str_constant1, i32 0, i32 0
	call void @_f_print0(i8* %gep26)
	store i32 0, i32* %_return.alloc3, align 4
	br label %main_bb1
}
declare i8* @_f_getString0()
define i32 @_f_heapSort0() {
_f_heapSort0_bb0:
	%_return.alloc2 = alloca i32, align 8
	%t.alloc4 = alloca i32, align 8
	%k.alloc0 = alloca i32, align 8
	store i32 0, i32* %t.alloc4, align 4
	store i32 0, i32* %k.alloc0, align 4
	br label %for_condition_bb_bb0
_f_heapSort0_bb1:					 ;preds = %_f_heapSort0_bb2
	%_return.load2 = load i32, i32* %_return.alloc2, align 4
	ret i32 %_return.load2
for_condition_bb_bb0:					 ;preds = %_f_heapSort0_bb0, %for_iter_bb_bb0
	%n.load4 = load i32, i32* @n_global0, align 4
	%k.load0 = load i32, i32* %k.alloc0, align 4
	%slt5 = icmp slt i32 %k.load0, %n.load4
	%zext_8 = zext i1 %slt5 to i8
	%trunc_8 = trunc i8 %zext_8 to i1
	br i1 %trunc_8, label %for_body_bb_bb0, label %_f_heapSort0_bb2
for_iter_bb_bb0:					 ;preds = %for_body_bb_bb0
	%k.load4 = load i32, i32* %k.alloc0, align 4
	%add6 = add i32 %k.load4, 1
	store i32 %add6, i32* %k.alloc0, align 4
	br label %for_condition_bb_bb0
for_body_bb_bb0:					 ;preds = %for_condition_bb_bb0
	%array.load28 = load i32*, i32** @a_global0, align 8
	%gep16 = getelementptr inbounds i32, i32* %array.load28, i32 0
	%array.load29 = load i32, i32* %gep16, align 4
	store i32 %array.load29, i32* %t.alloc4, align 4
	%k.load1 = load i32, i32* %k.alloc0, align 4
	%n.load5 = load i32, i32* @n_global0, align 4
	%sub2 = sub i32 %n.load5, %k.load1
	%sub3 = sub i32 %sub2, 1
	%array.load30 = load i32*, i32** @a_global0, align 8
	%gep17 = getelementptr inbounds i32, i32* %array.load30, i32 %sub3
	%array.load31 = load i32, i32* %gep17, align 4
	%array.load32 = load i32*, i32** @a_global0, align 8
	%gep18 = getelementptr inbounds i32, i32* %array.load32, i32 0
	store i32 %array.load31, i32* %gep18, align 4
	%t.load2 = load i32, i32* %t.alloc4, align 4
	%k.load2 = load i32, i32* %k.alloc0, align 4
	%n.load6 = load i32, i32* @n_global0, align 4
	%sub4 = sub i32 %n.load6, %k.load2
	%sub5 = sub i32 %sub4, 1
	%array.load33 = load i32*, i32** @a_global0, align 8
	%gep19 = getelementptr inbounds i32, i32* %array.load33, i32 %sub5
	store i32 %t.load2, i32* %gep19, align 4
	%k.load3 = load i32, i32* %k.alloc0, align 4
	%n.load7 = load i32, i32* @n_global0, align 4
	%sub6 = sub i32 %n.load7, %k.load3
	%sub7 = sub i32 %sub6, 1
	%_call_f_adjustHeap00 = call i32 @_f_adjustHeap0(i32 %sub7)
	br label %for_iter_bb_bb0
_f_heapSort0_bb2:					 ;preds = %for_condition_bb_bb0
	store i32 0, i32* %_return.alloc2, align 4
	br label %_f_heapSort0_bb1
}
declare void @_f_print0(i8*)
declare i8* @_f_toString0(i32)
define void @_f_exchange0(i32 %_arg0, i32 %_arg1) {
_f_exchange0_bb0:
	%x.alloc0 = alloca i32, align 8
	store i32 %_arg0, i32* %x.alloc0, align 4
	%y.alloc0 = alloca i32, align 8
	store i32 %_arg1, i32* %y.alloc0, align 4
	%t.alloc0 = alloca i32, align 8
	%x.load0 = load i32, i32* %x.alloc0, align 4
	%array.load0 = load i32*, i32** @a_global0, align 8
	%gep0 = getelementptr inbounds i32, i32* %array.load0, i32 %x.load0
	%array.load1 = load i32, i32* %gep0, align 4
	store i32 %array.load1, i32* %t.alloc0, align 4
	%y.load0 = load i32, i32* %y.alloc0, align 4
	%array.load2 = load i32*, i32** @a_global0, align 8
	%gep1 = getelementptr inbounds i32, i32* %array.load2, i32 %y.load0
	%array.load3 = load i32, i32* %gep1, align 4
	%x.load1 = load i32, i32* %x.alloc0, align 4
	%array.load4 = load i32*, i32** @a_global0, align 8
	%gep2 = getelementptr inbounds i32, i32* %array.load4, i32 %x.load1
	store i32 %array.load3, i32* %gep2, align 4
	%t.load0 = load i32, i32* %t.alloc0, align 4
	%y.load1 = load i32, i32* %y.alloc0, align 4
	%array.load5 = load i32*, i32** @a_global0, align 8
	%gep3 = getelementptr inbounds i32, i32* %array.load5, i32 %y.load1
	store i32 %t.load0, i32* %gep3, align 4
	br label %_f_exchange0_bb1
_f_exchange0_bb1:					 ;preds = %_f_exchange0_bb0
	ret void
}
define i32 @_f_adjustHeap0(i32 %_arg2) {
_f_adjustHeap0_bb0:
	%_return.alloc1 = alloca i32, align 8
	%n.alloc0 = alloca i32, align 8
	store i32 %_arg2, i32* %n.alloc0, align 4
	%i.alloc1 = alloca i32, align 8
	store i32 0, i32* %i.alloc1, align 4
	%j.alloc1 = alloca i32, align 8
	store i32 0, i32* %j.alloc1, align 4
	%t.alloc2 = alloca i32, align 8
	store i32 0, i32* %t.alloc2, align 4
	%sc_tmp_address_logic_and.alloc1 = alloca i8, align 8
	%t.alloc3 = alloca i32, align 8
	br label %while_condition_bb_bb1
_f_adjustHeap0_bb1:					 ;preds = %_f_adjustHeap0_bb2
	%_return.load1 = load i32, i32* %_return.alloc1, align 4
	ret i32 %_return.load1
while_condition_bb_bb1:					 ;preds = %_f_adjustHeap0_bb0, %_f_adjustHeap0_bb4
	%n.load2 = load i32, i32* %n.alloc0, align 4
	%i.load9 = load i32, i32* %i.alloc1, align 4
	%mul5 = mul i32 %i.load9, 2
	%slt2 = icmp slt i32 %mul5, %n.load2
	%zext_4 = zext i1 %slt2 to i8
	%trunc_4 = trunc i8 %zext_4 to i1
	br i1 %trunc_4, label %while_body_bb_bb1, label %_f_adjustHeap0_bb2
while_body_bb_bb1:					 ;preds = %while_condition_bb_bb1
	%i.load10 = load i32, i32* %i.alloc1, align 4
	%mul6 = mul i32 %i.load10, 2
	store i32 %mul6, i32* %j.alloc1, align 4
	%n.load3 = load i32, i32* %n.alloc0, align 4
	%i.load11 = load i32, i32* %i.alloc1, align 4
	%mul7 = mul i32 %i.load11, 2
	%add3 = add i32 %mul7, 1
	%slt3 = icmp slt i32 %add3, %n.load3
	%zext_5 = zext i1 %slt3 to i8
	%trunc_5 = trunc i8 %zext_5 to i1
	br i1 %trunc_5, label %long_block_bb1, label %short_block_bb1
_f_adjustHeap0_bb2:					 ;preds = %while_condition_bb_bb1, %if_else_bb0
	store i32 0, i32* %_return.alloc1, align 4
	br label %_f_adjustHeap0_bb1
if_then_bb2:					 ;preds = %terminal_block_bb1
	%i.load14 = load i32, i32* %i.alloc1, align 4
	%mul10 = mul i32 %i.load14, 2
	%add5 = add i32 %mul10, 1
	store i32 %add5, i32* %j.alloc1, align 4
	br label %_f_adjustHeap0_bb3
_f_adjustHeap0_bb3:					 ;preds = %terminal_block_bb1, %if_then_bb2
	%j.load2 = load i32, i32* %j.alloc1, align 4
	%array.load18 = load i32*, i32** @a_global0, align 8
	%gep10 = getelementptr inbounds i32, i32* %array.load18, i32 %j.load2
	%array.load19 = load i32, i32* %gep10, align 4
	%i.load15 = load i32, i32* %i.alloc1, align 4
	%array.load20 = load i32*, i32** @a_global0, align 8
	%gep11 = getelementptr inbounds i32, i32* %array.load20, i32 %i.load15
	%array.load21 = load i32, i32* %gep11, align 4
	%sgt1 = icmp sgt i32 %array.load21, %array.load19
	%zext_7 = zext i1 %sgt1 to i8
	%trunc_7 = trunc i8 %zext_7 to i1
	br i1 %trunc_7, label %if_then_bb3, label %if_else_bb0
short_block_bb1:					 ;preds = %while_body_bb_bb1
	store i8 %zext_5, i8* %sc_tmp_address_logic_and.alloc1, align 1
	br label %terminal_block_bb1
long_block_bb1:					 ;preds = %while_body_bb_bb1
	%i.load12 = load i32, i32* %i.alloc1, align 4
	%mul8 = mul i32 %i.load12, 2
	%array.load14 = load i32*, i32** @a_global0, align 8
	%gep8 = getelementptr inbounds i32, i32* %array.load14, i32 %mul8
	%array.load15 = load i32, i32* %gep8, align 4
	%i.load13 = load i32, i32* %i.alloc1, align 4
	%mul9 = mul i32 %i.load13, 2
	%add4 = add i32 %mul9, 1
	%array.load16 = load i32*, i32** @a_global0, align 8
	%gep9 = getelementptr inbounds i32, i32* %array.load16, i32 %add4
	%array.load17 = load i32, i32* %gep9, align 4
	%slt4 = icmp slt i32 %array.load17, %array.load15
	%zext_6 = zext i1 %slt4 to i8
	store i8 %zext_6, i8* %sc_tmp_address_logic_and.alloc1, align 1
	br label %terminal_block_bb1
terminal_block_bb1:					 ;preds = %short_block_bb1, %long_block_bb1
	%sc_terminal_address.load1 = load i8, i8* %sc_tmp_address_logic_and.alloc1, align 1
	%trunc_6 = trunc i8 %sc_terminal_address.load1 to i1
	br i1 %trunc_6, label %if_then_bb2, label %_f_adjustHeap0_bb3
if_then_bb3:					 ;preds = %_f_adjustHeap0_bb3
	%i.load16 = load i32, i32* %i.alloc1, align 4
	%array.load22 = load i32*, i32** @a_global0, align 8
	%gep12 = getelementptr inbounds i32, i32* %array.load22, i32 %i.load16
	%array.load23 = load i32, i32* %gep12, align 4
	store i32 %array.load23, i32* %t.alloc3, align 4
	%j.load3 = load i32, i32* %j.alloc1, align 4
	%array.load24 = load i32*, i32** @a_global0, align 8
	%gep13 = getelementptr inbounds i32, i32* %array.load24, i32 %j.load3
	%array.load25 = load i32, i32* %gep13, align 4
	%i.load17 = load i32, i32* %i.alloc1, align 4
	%array.load26 = load i32*, i32** @a_global0, align 8
	%gep14 = getelementptr inbounds i32, i32* %array.load26, i32 %i.load17
	store i32 %array.load25, i32* %gep14, align 4
	%t.load1 = load i32, i32* %t.alloc3, align 4
	%j.load4 = load i32, i32* %j.alloc1, align 4
	%array.load27 = load i32*, i32** @a_global0, align 8
	%gep15 = getelementptr inbounds i32, i32* %array.load27, i32 %j.load4
	store i32 %t.load1, i32* %gep15, align 4
	%j.load5 = load i32, i32* %j.alloc1, align 4
	store i32 %j.load5, i32* %i.alloc1, align 4
	br label %_f_adjustHeap0_bb4
_f_adjustHeap0_bb4:					 ;preds = %if_then_bb3, %if_else_bb0
	br label %while_condition_bb_bb1
if_else_bb0:					 ;preds = %_f_adjustHeap0_bb3
	br label %_f_adjustHeap0_bb2
}
declare i8* @_f__malloc0(i32)
define i32 @_f_makeHeap0() {
_f_makeHeap0_bb0:
	%_return.alloc0 = alloca i32, align 8
	%i.alloc0 = alloca i32, align 8
	%t.alloc1 = alloca i32, align 8
	%j.alloc0 = alloca i32, align 8
	%n.load0 = load i32, i32* @n_global0, align 4
	%sub0 = sub i32 %n.load0, 1
	%sdiv0 = sdiv i32 %sub0, 2
	store i32 %sdiv0, i32* %i.alloc0, align 4
	store i32 0, i32* %t.alloc1, align 4
	store i32 0, i32* %j.alloc0, align 4
	%sc_tmp_address_logic_and.alloc0 = alloca i8, align 8
	br label %while_condition_bb_bb0
_f_makeHeap0_bb1:					 ;preds = %_f_makeHeap0_bb2
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
while_condition_bb_bb0:					 ;preds = %_f_makeHeap0_bb0, %_f_makeHeap0_bb4
	%i.load0 = load i32, i32* %i.alloc0, align 4
	%sge0 = icmp sge i32 %i.load0, 0
	%zext_0 = zext i1 %sge0 to i8
	%trunc_0 = trunc i8 %zext_0 to i1
	br i1 %trunc_0, label %while_body_bb_bb0, label %_f_makeHeap0_bb2
while_body_bb_bb0:					 ;preds = %while_condition_bb_bb0
	%i.load1 = load i32, i32* %i.alloc0, align 4
	%mul0 = mul i32 %i.load1, 2
	store i32 %mul0, i32* %j.alloc0, align 4
	%n.load1 = load i32, i32* @n_global0, align 4
	%i.load2 = load i32, i32* %i.alloc0, align 4
	%mul1 = mul i32 %i.load2, 2
	%add0 = add i32 %mul1, 1
	%slt0 = icmp slt i32 %add0, %n.load1
	%zext_1 = zext i1 %slt0 to i8
	%trunc_1 = trunc i8 %zext_1 to i1
	br i1 %trunc_1, label %long_block_bb0, label %short_block_bb0
_f_makeHeap0_bb2:					 ;preds = %while_condition_bb_bb0
	store i32 0, i32* %_return.alloc0, align 4
	br label %_f_makeHeap0_bb1
if_then_bb0:					 ;preds = %terminal_block_bb0
	%i.load5 = load i32, i32* %i.alloc0, align 4
	%mul4 = mul i32 %i.load5, 2
	%add2 = add i32 %mul4, 1
	store i32 %add2, i32* %j.alloc0, align 4
	br label %_f_makeHeap0_bb3
_f_makeHeap0_bb3:					 ;preds = %terminal_block_bb0, %if_then_bb0
	%j.load0 = load i32, i32* %j.alloc0, align 4
	%array.load10 = load i32*, i32** @a_global0, align 8
	%gep6 = getelementptr inbounds i32, i32* %array.load10, i32 %j.load0
	%array.load11 = load i32, i32* %gep6, align 4
	%i.load6 = load i32, i32* %i.alloc0, align 4
	%array.load12 = load i32*, i32** @a_global0, align 8
	%gep7 = getelementptr inbounds i32, i32* %array.load12, i32 %i.load6
	%array.load13 = load i32, i32* %gep7, align 4
	%sgt0 = icmp sgt i32 %array.load13, %array.load11
	%zext_3 = zext i1 %sgt0 to i8
	%trunc_3 = trunc i8 %zext_3 to i1
	br i1 %trunc_3, label %if_then_bb1, label %_f_makeHeap0_bb4
short_block_bb0:					 ;preds = %while_body_bb_bb0
	store i8 %zext_1, i8* %sc_tmp_address_logic_and.alloc0, align 1
	br label %terminal_block_bb0
long_block_bb0:					 ;preds = %while_body_bb_bb0
	%i.load3 = load i32, i32* %i.alloc0, align 4
	%mul2 = mul i32 %i.load3, 2
	%array.load6 = load i32*, i32** @a_global0, align 8
	%gep4 = getelementptr inbounds i32, i32* %array.load6, i32 %mul2
	%array.load7 = load i32, i32* %gep4, align 4
	%i.load4 = load i32, i32* %i.alloc0, align 4
	%mul3 = mul i32 %i.load4, 2
	%add1 = add i32 %mul3, 1
	%array.load8 = load i32*, i32** @a_global0, align 8
	%gep5 = getelementptr inbounds i32, i32* %array.load8, i32 %add1
	%array.load9 = load i32, i32* %gep5, align 4
	%slt1 = icmp slt i32 %array.load9, %array.load7
	%zext_2 = zext i1 %slt1 to i8
	store i8 %zext_2, i8* %sc_tmp_address_logic_and.alloc0, align 1
	br label %terminal_block_bb0
terminal_block_bb0:					 ;preds = %short_block_bb0, %long_block_bb0
	%sc_terminal_address.load0 = load i8, i8* %sc_tmp_address_logic_and.alloc0, align 1
	%trunc_2 = trunc i8 %sc_terminal_address.load0 to i1
	br i1 %trunc_2, label %if_then_bb0, label %_f_makeHeap0_bb3
if_then_bb1:					 ;preds = %_f_makeHeap0_bb3
	%i.load7 = load i32, i32* %i.alloc0, align 4
	%j.load1 = load i32, i32* %j.alloc0, align 4
	call void @_f_exchange0(i32 %i.load7, i32 %j.load1)
	br label %_f_makeHeap0_bb4
_f_makeHeap0_bb4:					 ;preds = %_f_makeHeap0_bb3, %if_then_bb1
	%i.load8 = load i32, i32* %i.alloc0, align 4
	%sub1 = sub i32 %i.load8, 1
	store i32 %sub1, i32* %i.alloc0, align 4
	br label %while_condition_bb_bb0
}
declare i32 @_class_string_parseInt0(i8*)

