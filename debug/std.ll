@_str = private unnamed_addr constant [2 x i8] c" \00", align 1
@_str1 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1
@n_glo = global i32 zeroinitializer, align 4
@a_glo = global i32* zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @_GLOBAL_, i8* null }]
define void @_global_var_init()	{
a_bb:
	store i32* null, i32** @a_glo, align 8
	br label %a_bb1
a_bb1:					 ;preds = %a_bb
	ret void
}

define void @_GLOBAL_()	{
_GLOBAL__bb:
	call void @_global_var_init()
	ret void
}

declare i8* @_f__str_splice(i8*, i8*)
define i32 @main()	{
main_bb:
	%_return.alloc3 = alloca i32, align 4
	%i.alloc2 = alloca i32, align 4
	%_call_f_getString = call i8* @_f_getString()
	%_call_class_string_parseInt = call i32 @_class_string_parseInt(i8* %_call_f_getString)
	store i32 %_call_class_string_parseInt, i32* @n_glo, align 4
	%n.load8 = load i32, i32* @n_glo, align 4
	%mul11 = mul i32 %n.load8, 4
	%add7 = add i32 %mul11, 4
	%_call_f__malloc = call i8* @_f__malloc(i32 %add7)
	%_call_f__malloc_BC = bitcast i8* %_call_f__malloc to i32*
	store i32 %n.load8, i32* %_call_f__malloc_BC, align 4
	%gep20 = getelementptr inbounds i32, i32* %_call_f__malloc_BC, i32 1
	%gep20_BC = bitcast i32* %gep20 to i32*
	store i32* %gep20_BC, i32** @a_glo, align 8
	store i32 0, i32* %i.alloc2, align 4
	br label %for_condition_bb1
main_bb1:					 ;preds = %main_bb3
	%_return.load3 = load i32, i32* %_return.alloc3, align 4
	ret i32 %_return.load3
for_condition_bb1:					 ;preds = %main_bb, %for_iter_bb1
	%a.load = load i32*, i32** @a_glo, align 8
	%a.load_BC = bitcast i32* %a.load to i32*
	%gep21 = getelementptr inbounds i32, i32* %a.load_BC, i32 -1
	%array_size.load = load i32, i32* %gep21, align 4
	%i.load18 = load i32, i32* %i.alloc2, align 4
	%slt6 = icmp slt i32 %i.load18, %array_size.load
	%zext_9 = zext i1 %slt6 to i8
	%trunc_9 = trunc i8 %zext_9 to i1
	br i1 %trunc_9, label %for_body_bb1, label %main_bb2
for_iter_bb1:					 ;preds = %for_body_bb1
	%i.load21 = load i32, i32* %i.alloc2, align 4
	%add8 = add i32 %i.load21, 1
	store i32 %add8, i32* %i.alloc2, align 4
	br label %for_condition_bb1
for_body_bb1:					 ;preds = %for_condition_bb1
	%i.load19 = load i32, i32* %i.alloc2, align 4
	%_array.load34 = load i32*, i32** @a_glo, align 8
	%i.load20 = load i32, i32* %i.alloc2, align 4
	%gep22 = getelementptr inbounds i32, i32* %_array.load34, i32 %i.load20
	store i32 %i.load19, i32* %gep22, align 4
	br label %for_iter_bb1
main_bb2:					 ;preds = %for_condition_bb1
	%_call_f_makeHeap = call i32 @_f_makeHeap()
	%_call_f_heapSort = call i32 @_f_heapSort()
	store i32 0, i32* %i.alloc2, align 4
	br label %for_condition_bb2
for_condition_bb2:					 ;preds = %main_bb2, %for_iter_bb2
	%a.load1 = load i32*, i32** @a_glo, align 8
	%a.load1_BC = bitcast i32* %a.load1 to i32*
	%gep23 = getelementptr inbounds i32, i32* %a.load1_BC, i32 -1
	%array_size.load1 = load i32, i32* %gep23, align 4
	%i.load22 = load i32, i32* %i.alloc2, align 4
	%slt7 = icmp slt i32 %i.load22, %array_size.load1
	%zext_10 = zext i1 %slt7 to i8
	%trunc_10 = trunc i8 %zext_10 to i1
	br i1 %trunc_10, label %for_body_bb2, label %main_bb3
for_iter_bb2:					 ;preds = %for_body_bb2
	%i.load24 = load i32, i32* %i.alloc2, align 4
	%add9 = add i32 %i.load24, 1
	store i32 %add9, i32* %i.alloc2, align 4
	br label %for_condition_bb2
for_body_bb2:					 ;preds = %for_condition_bb2
	%_array.load35 = load i32*, i32** @a_glo, align 8
	%i.load23 = load i32, i32* %i.alloc2, align 4
	%gep24 = getelementptr inbounds i32, i32* %_array.load35, i32 %i.load23
	%_array.load36 = load i32, i32* %gep24, align 4
	%_call_f_toString = call i8* @_f_toString(i32 %_array.load36)
	%gep25 = getelementptr inbounds [2 x i8], [2 x i8]* @_str, i32 0, i32 0
	%_call_f__str_splice = call i8* @_f__str_splice(i8* %_call_f_toString, i8* %gep25)
	call void @_f_print(i8* %_call_f__str_splice)
	br label %for_iter_bb2
main_bb3:					 ;preds = %for_condition_bb2
	%gep26 = getelementptr inbounds [2 x i8], [2 x i8]* @_str1, i32 0, i32 0
	call void @_f_print(i8* %gep26)
	store i32 0, i32* %_return.alloc3, align 4
	br label %main_bb1
}
declare i8* @_f_getString()
define i32 @_f_heapSort()	{
_f_heapSort_bb:
	%_return.alloc2 = alloca i32, align 4
	%t.alloc4 = alloca i32, align 4
	%k.alloc = alloca i32, align 4
	store i32 0, i32* %t.alloc4, align 4
	store i32 0, i32* %k.alloc, align 4
	br label %for_condition_bb
_f_heapSort_bb1:					 ;preds = %_f_heapSort_bb2
	%_return.load2 = load i32, i32* %_return.alloc2, align 4
	ret i32 %_return.load2
for_condition_bb:					 ;preds = %_f_heapSort_bb, %for_iter_bb
	%n.load4 = load i32, i32* @n_glo, align 4
	%k.load = load i32, i32* %k.alloc, align 4
	%slt5 = icmp slt i32 %k.load, %n.load4
	%zext_8 = zext i1 %slt5 to i8
	%trunc_8 = trunc i8 %zext_8 to i1
	br i1 %trunc_8, label %for_body_bb, label %_f_heapSort_bb2
for_iter_bb:					 ;preds = %for_body_bb
	%k.load4 = load i32, i32* %k.alloc, align 4
	%add6 = add i32 %k.load4, 1
	store i32 %add6, i32* %k.alloc, align 4
	br label %for_condition_bb
for_body_bb:					 ;preds = %for_condition_bb
	%_array.load28 = load i32*, i32** @a_glo, align 8
	%gep16 = getelementptr inbounds i32, i32* %_array.load28, i32 0
	%_array.load29 = load i32, i32* %gep16, align 4
	store i32 %_array.load29, i32* %t.alloc4, align 4
	%_array.load30 = load i32*, i32** @a_glo, align 8
	%k.load1 = load i32, i32* %k.alloc, align 4
	%n.load5 = load i32, i32* @n_glo, align 4
	%sub2 = sub i32 %n.load5, %k.load1
	%sub3 = sub i32 %sub2, 1
	%gep17 = getelementptr inbounds i32, i32* %_array.load30, i32 %sub3
	%_array.load31 = load i32, i32* %gep17, align 4
	%_array.load32 = load i32*, i32** @a_glo, align 8
	%gep18 = getelementptr inbounds i32, i32* %_array.load32, i32 0
	store i32 %_array.load31, i32* %gep18, align 4
	%t.load2 = load i32, i32* %t.alloc4, align 4
	%_array.load33 = load i32*, i32** @a_glo, align 8
	%k.load2 = load i32, i32* %k.alloc, align 4
	%n.load6 = load i32, i32* @n_glo, align 4
	%sub4 = sub i32 %n.load6, %k.load2
	%sub5 = sub i32 %sub4, 1
	%gep19 = getelementptr inbounds i32, i32* %_array.load33, i32 %sub5
	store i32 %t.load2, i32* %gep19, align 4
	%k.load3 = load i32, i32* %k.alloc, align 4
	%n.load7 = load i32, i32* @n_glo, align 4
	%sub6 = sub i32 %n.load7, %k.load3
	%sub7 = sub i32 %sub6, 1
	%_call_f_adjustHeap = call i32 @_f_adjustHeap(i32 %sub7)
	br label %for_iter_bb
_f_heapSort_bb2:					 ;preds = %for_condition_bb
	store i32 0, i32* %_return.alloc2, align 4
	br label %_f_heapSort_bb1
}
declare void @_f_print(i8*)
declare i8* @_f_toString(i32)
define void @_f_exchange(i32 %_arg, i32 %_arg1)	{
_f_exchange_bb:
	%x.alloc = alloca i32, align 4
	store i32 %_arg, i32* %x.alloc, align 4
	%y.alloc = alloca i32, align 4
	store i32 %_arg1, i32* %y.alloc, align 4
	%t.alloc = alloca i32, align 4
	%_array.load = load i32*, i32** @a_glo, align 8
	%x.load = load i32, i32* %x.alloc, align 4
	%gep = getelementptr inbounds i32, i32* %_array.load, i32 %x.load
	%_array.load1 = load i32, i32* %gep, align 4
	store i32 %_array.load1, i32* %t.alloc, align 4
	%_array.load2 = load i32*, i32** @a_glo, align 8
	%y.load = load i32, i32* %y.alloc, align 4
	%gep1 = getelementptr inbounds i32, i32* %_array.load2, i32 %y.load
	%_array.load3 = load i32, i32* %gep1, align 4
	%_array.load4 = load i32*, i32** @a_glo, align 8
	%x.load1 = load i32, i32* %x.alloc, align 4
	%gep2 = getelementptr inbounds i32, i32* %_array.load4, i32 %x.load1
	store i32 %_array.load3, i32* %gep2, align 4
	%t.load = load i32, i32* %t.alloc, align 4
	%_array.load5 = load i32*, i32** @a_glo, align 8
	%y.load1 = load i32, i32* %y.alloc, align 4
	%gep3 = getelementptr inbounds i32, i32* %_array.load5, i32 %y.load1
	store i32 %t.load, i32* %gep3, align 4
	br label %_f_exchange_bb1
_f_exchange_bb1:					 ;preds = %_f_exchange_bb
	ret void
}
define i32 @_f_adjustHeap(i32 %_arg2)	{
_f_adjustHeap_bb:
	%_return.alloc1 = alloca i32, align 4
	%n.alloc = alloca i32, align 4
	store i32 %_arg2, i32* %n.alloc, align 4
	%i.alloc1 = alloca i32, align 4
	store i32 0, i32* %i.alloc1, align 4
	%j.alloc1 = alloca i32, align 4
	store i32 0, i32* %j.alloc1, align 4
	%t.alloc2 = alloca i32, align 4
	store i32 0, i32* %t.alloc2, align 4
	%logic_and.alloc1 = alloca i8, align 4
	%t.alloc3 = alloca i32, align 4
	br label %while_condition_bb1
_f_adjustHeap_bb1:					 ;preds = %_f_adjustHeap_bb2
	%_return.load1 = load i32, i32* %_return.alloc1, align 4
	ret i32 %_return.load1
while_condition_bb1:					 ;preds = %_f_adjustHeap_bb, %_f_adjustHeap_bb4
	%n.load2 = load i32, i32* %n.alloc, align 4
	%i.load9 = load i32, i32* %i.alloc1, align 4
	%mul5 = mul i32 %i.load9, 2
	%slt2 = icmp slt i32 %mul5, %n.load2
	%zext_4 = zext i1 %slt2 to i8
	%trunc_4 = trunc i8 %zext_4 to i1
	br i1 %trunc_4, label %while_body_bb1, label %_f_adjustHeap_bb2
while_body_bb1:					 ;preds = %while_condition_bb1
	%i.load10 = load i32, i32* %i.alloc1, align 4
	%mul6 = mul i32 %i.load10, 2
	store i32 %mul6, i32* %j.alloc1, align 4
	%n.load3 = load i32, i32* %n.alloc, align 4
	%i.load11 = load i32, i32* %i.alloc1, align 4
	%mul7 = mul i32 %i.load11, 2
	%add3 = add i32 %mul7, 1
	%slt3 = icmp slt i32 %add3, %n.load3
	%zext_5 = zext i1 %slt3 to i8
	%trunc_5 = trunc i8 %zext_5 to i1
	br i1 %trunc_5, label %_sBlock_bb1, label %_dBlock_bb1
_f_adjustHeap_bb2:					 ;preds = %while_condition_bb1, %if_else_bb
	store i32 0, i32* %_return.alloc1, align 4
	br label %_f_adjustHeap_bb1
if_then_bb2:					 ;preds = %_tBlock_bb1
	%i.load14 = load i32, i32* %i.alloc1, align 4
	%mul10 = mul i32 %i.load14, 2
	%add5 = add i32 %mul10, 1
	store i32 %add5, i32* %j.alloc1, align 4
	br label %_f_adjustHeap_bb3
_f_adjustHeap_bb3:					 ;preds = %_tBlock_bb1, %if_then_bb2
	%_array.load18 = load i32*, i32** @a_glo, align 8
	%j.load2 = load i32, i32* %j.alloc1, align 4
	%gep10 = getelementptr inbounds i32, i32* %_array.load18, i32 %j.load2
	%_array.load19 = load i32, i32* %gep10, align 4
	%_array.load20 = load i32*, i32** @a_glo, align 8
	%i.load15 = load i32, i32* %i.alloc1, align 4
	%gep11 = getelementptr inbounds i32, i32* %_array.load20, i32 %i.load15
	%_array.load21 = load i32, i32* %gep11, align 4
	%sgt1 = icmp sgt i32 %_array.load21, %_array.load19
	%zext_7 = zext i1 %sgt1 to i8
	%trunc_7 = trunc i8 %zext_7 to i1
	br i1 %trunc_7, label %if_then_bb3, label %if_else_bb
_dBlock_bb1:					 ;preds = %while_body_bb1
	store i8 %zext_5, i8* %logic_and.alloc1, align 4
	br label %_tBlock_bb1
_sBlock_bb1:					 ;preds = %while_body_bb1
	%_array.load14 = load i32*, i32** @a_glo, align 8
	%i.load12 = load i32, i32* %i.alloc1, align 4
	%mul8 = mul i32 %i.load12, 2
	%gep8 = getelementptr inbounds i32, i32* %_array.load14, i32 %mul8
	%_array.load15 = load i32, i32* %gep8, align 4
	%_array.load16 = load i32*, i32** @a_glo, align 8
	%i.load13 = load i32, i32* %i.alloc1, align 4
	%mul9 = mul i32 %i.load13, 2
	%add4 = add i32 %mul9, 1
	%gep9 = getelementptr inbounds i32, i32* %_array.load16, i32 %add4
	%_array.load17 = load i32, i32* %gep9, align 4
	%slt4 = icmp slt i32 %_array.load17, %_array.load15
	%zext_6 = zext i1 %slt4 to i8
	store i8 %zext_6, i8* %logic_and.alloc1, align 4
	br label %_tBlock_bb1
_tBlock_bb1:					 ;preds = %_dBlock_bb1, %_sBlock_bb1
	%circuit.load1 = load i8, i8* %logic_and.alloc1, align 4
	%trunc_6 = trunc i8 %circuit.load1 to i1
	br i1 %trunc_6, label %if_then_bb2, label %_f_adjustHeap_bb3
if_then_bb3:					 ;preds = %_f_adjustHeap_bb3
	%_array.load22 = load i32*, i32** @a_glo, align 8
	%i.load16 = load i32, i32* %i.alloc1, align 4
	%gep12 = getelementptr inbounds i32, i32* %_array.load22, i32 %i.load16
	%_array.load23 = load i32, i32* %gep12, align 4
	store i32 %_array.load23, i32* %t.alloc3, align 4
	%_array.load24 = load i32*, i32** @a_glo, align 8
	%j.load3 = load i32, i32* %j.alloc1, align 4
	%gep13 = getelementptr inbounds i32, i32* %_array.load24, i32 %j.load3
	%_array.load25 = load i32, i32* %gep13, align 4
	%_array.load26 = load i32*, i32** @a_glo, align 8
	%i.load17 = load i32, i32* %i.alloc1, align 4
	%gep14 = getelementptr inbounds i32, i32* %_array.load26, i32 %i.load17
	store i32 %_array.load25, i32* %gep14, align 4
	%t.load1 = load i32, i32* %t.alloc3, align 4
	%_array.load27 = load i32*, i32** @a_glo, align 8
	%j.load4 = load i32, i32* %j.alloc1, align 4
	%gep15 = getelementptr inbounds i32, i32* %_array.load27, i32 %j.load4
	store i32 %t.load1, i32* %gep15, align 4
	%j.load5 = load i32, i32* %j.alloc1, align 4
	store i32 %j.load5, i32* %i.alloc1, align 4
	br label %_f_adjustHeap_bb4
_f_adjustHeap_bb4:					 ;preds = %if_else_bb, %if_then_bb3
	br label %while_condition_bb1
if_else_bb:					 ;preds = %_f_adjustHeap_bb3
	br label %_f_adjustHeap_bb2
}
declare i8* @_f__malloc(i32)
define i32 @_f_makeHeap()	{
_f_makeHeap_bb:
	%_return.alloc = alloca i32, align 4
	%i.alloc = alloca i32, align 4
	%t.alloc1 = alloca i32, align 4
	%j.alloc = alloca i32, align 4
	%n.load = load i32, i32* @n_glo, align 4
	%sub = sub i32 %n.load, 1
	%sdiv = sdiv i32 %sub, 2
	store i32 %sdiv, i32* %i.alloc, align 4
	store i32 0, i32* %t.alloc1, align 4
	store i32 0, i32* %j.alloc, align 4
	%logic_and.alloc = alloca i8, align 4
	br label %while_condition_bb
_f_makeHeap_bb1:					 ;preds = %_f_makeHeap_bb2
	%_return.load = load i32, i32* %_return.alloc, align 4
	ret i32 %_return.load
while_condition_bb:					 ;preds = %_f_makeHeap_bb, %_f_makeHeap_bb4
	%i.load = load i32, i32* %i.alloc, align 4
	%sge = icmp sge i32 %i.load, 0
	%zext_ = zext i1 %sge to i8
	%trunc_ = trunc i8 %zext_ to i1
	br i1 %trunc_, label %while_body_bb, label %_f_makeHeap_bb2
while_body_bb:					 ;preds = %while_condition_bb
	%i.load1 = load i32, i32* %i.alloc, align 4
	%mul = mul i32 %i.load1, 2
	store i32 %mul, i32* %j.alloc, align 4
	%n.load1 = load i32, i32* @n_glo, align 4
	%i.load2 = load i32, i32* %i.alloc, align 4
	%mul1 = mul i32 %i.load2, 2
	%add = add i32 %mul1, 1
	%slt = icmp slt i32 %add, %n.load1
	%zext_1 = zext i1 %slt to i8
	%trunc_1 = trunc i8 %zext_1 to i1
	br i1 %trunc_1, label %_sBlock_bb, label %_dBlock_bb
_f_makeHeap_bb2:					 ;preds = %while_condition_bb
	store i32 0, i32* %_return.alloc, align 4
	br label %_f_makeHeap_bb1
if_then_bb:					 ;preds = %_tBlock_bb
	%i.load5 = load i32, i32* %i.alloc, align 4
	%mul4 = mul i32 %i.load5, 2
	%add2 = add i32 %mul4, 1
	store i32 %add2, i32* %j.alloc, align 4
	br label %_f_makeHeap_bb3
_f_makeHeap_bb3:					 ;preds = %_tBlock_bb, %if_then_bb
	%_array.load10 = load i32*, i32** @a_glo, align 8
	%j.load = load i32, i32* %j.alloc, align 4
	%gep6 = getelementptr inbounds i32, i32* %_array.load10, i32 %j.load
	%_array.load11 = load i32, i32* %gep6, align 4
	%_array.load12 = load i32*, i32** @a_glo, align 8
	%i.load6 = load i32, i32* %i.alloc, align 4
	%gep7 = getelementptr inbounds i32, i32* %_array.load12, i32 %i.load6
	%_array.load13 = load i32, i32* %gep7, align 4
	%sgt = icmp sgt i32 %_array.load13, %_array.load11
	%zext_3 = zext i1 %sgt to i8
	%trunc_3 = trunc i8 %zext_3 to i1
	br i1 %trunc_3, label %if_then_bb1, label %_f_makeHeap_bb4
_dBlock_bb:					 ;preds = %while_body_bb
	store i8 %zext_1, i8* %logic_and.alloc, align 4
	br label %_tBlock_bb
_sBlock_bb:					 ;preds = %while_body_bb
	%_array.load6 = load i32*, i32** @a_glo, align 8
	%i.load3 = load i32, i32* %i.alloc, align 4
	%mul2 = mul i32 %i.load3, 2
	%gep4 = getelementptr inbounds i32, i32* %_array.load6, i32 %mul2
	%_array.load7 = load i32, i32* %gep4, align 4
	%_array.load8 = load i32*, i32** @a_glo, align 8
	%i.load4 = load i32, i32* %i.alloc, align 4
	%mul3 = mul i32 %i.load4, 2
	%add1 = add i32 %mul3, 1
	%gep5 = getelementptr inbounds i32, i32* %_array.load8, i32 %add1
	%_array.load9 = load i32, i32* %gep5, align 4
	%slt1 = icmp slt i32 %_array.load9, %_array.load7
	%zext_2 = zext i1 %slt1 to i8
	store i8 %zext_2, i8* %logic_and.alloc, align 4
	br label %_tBlock_bb
_tBlock_bb:					 ;preds = %_dBlock_bb, %_sBlock_bb
	%circuit.load = load i8, i8* %logic_and.alloc, align 4
	%trunc_2 = trunc i8 %circuit.load to i1
	br i1 %trunc_2, label %if_then_bb, label %_f_makeHeap_bb3
if_then_bb1:					 ;preds = %_f_makeHeap_bb3
	%i.load7 = load i32, i32* %i.alloc, align 4
	%j.load1 = load i32, i32* %j.alloc, align 4
	call void @_f_exchange(i32 %i.load7, i32 %j.load1)
	br label %_f_makeHeap_bb4
_f_makeHeap_bb4:					 ;preds = %_f_makeHeap_bb3, %if_then_bb1
	%i.load8 = load i32, i32* %i.alloc, align 4
	%sub1 = sub i32 %i.load8, 1
	store i32 %sub1, i32* %i.alloc, align 4
	br label %while_condition_bb
}
declare i32 @_class_string_parseInt(i8*)
