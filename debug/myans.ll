@_str_constant0 = private unnamed_addr constant [1 x i8] c"\00", align 1
@a_global0 = dso_local global i32* zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]
define void @global_init_a0() {
a_entry_bb_bb0:
	%mul1 = mul i32 4, 4
	%add5 = add i32 %mul1, 4
	%_call_f__malloc01 = call i8* @_f__malloc0(i32 %add5)
	%_call_f__malloc01_BC0 = bitcast i8* %_call_f__malloc01 to i32*
	store i32 %mul1, i32* %_call_f__malloc01_BC0, align 4
	%gep23 = getelementptr inbounds i32, i32* %_call_f__malloc01_BC0, i32 1
	%gep23_BC0 = bitcast i32* %gep23 to i32*
	store i32* %gep23_BC0, i32** @a_global0, align 8
	br label %a_exit_bb_bb0
a_exit_bb_bb0:					 ;preds = %a_entry_bb_bb0
	ret void
}
define void @Global_init0() {
global_all_bb_bb0:
	call void @global_init_a0()
	ret void
}
define i32 @main() {
main_bb0:
	%_return.alloc0 = alloca i32, align 8
	%b.alloc0 = alloca i32**, align 8
	%mul0 = mul i32 4, 8
	%add0 = add i32 %mul0, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add0)
	%_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
	store i32 %mul0, i32* %_call_f__malloc00_BC0, align 4
	%gep0 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
	%gep0_BC0 = bitcast i32* %gep0 to i32**
	store i32** %gep0_BC0, i32*** %b.alloc0, align 8
	%i.alloc0 = alloca i32, align 8
	%a.load0 = load i32*, i32** @a_global0, align 8
	%array.load0 = load i32**, i32*** %b.alloc0, align 8
	%gep1 = getelementptr inbounds i32*, i32** %array.load0, i32 0
	store i32* %a.load0, i32** %gep1, align 8
	%a.load1 = load i32*, i32** @a_global0, align 8
	%array.load1 = load i32**, i32*** %b.alloc0, align 8
	%gep2 = getelementptr inbounds i32*, i32** %array.load1, i32 1
	store i32* %a.load1, i32** %gep2, align 8
	%a.load2 = load i32*, i32** @a_global0, align 8
	%array.load2 = load i32**, i32*** %b.alloc0, align 8
	%gep3 = getelementptr inbounds i32*, i32** %array.load2, i32 2
	store i32* %a.load2, i32** %gep3, align 8
	%a.load3 = load i32*, i32** @a_global0, align 8
	%array.load3 = load i32**, i32*** %b.alloc0, align 8
	%gep4 = getelementptr inbounds i32*, i32** %array.load3, i32 3
	store i32* %a.load3, i32** %gep4, align 8
	%b.load0 = load i32**, i32*** %b.alloc0, align 8
	%b.load0_BC0 = bitcast i32** %b.load0 to i32*
	%gep5 = getelementptr inbounds i32, i32* %b.load0_BC0, i32 -1
	%array_size.load0 = load i32, i32* %gep5, align 4
	%_call_f_toString00 = call i8* @_f_toString0(i32 %array_size.load0)
	call void @_f_println0(i8* %_call_f_toString00)
	store i32 0, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb0
main_bb1:					 ;preds = %main_bb5
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
for_condition_bb_bb0:					 ;preds = %main_bb0, %for_iter_bb_bb0
	%array.load4 = load i32**, i32*** %b.alloc0, align 8
	%gep6 = getelementptr inbounds i32*, i32** %array.load4, i32 0
	%_array.load0 = load i32*, i32** %gep6, align 8
	%_array.load0_BC0 = bitcast i32* %_array.load0 to i32*
	%gep7 = getelementptr inbounds i32, i32* %_array.load0_BC0, i32 -1
	%array_size.load1 = load i32, i32* %gep7, align 4
	%i.load0 = load i32, i32* %i.alloc0, align 4
	%slt0 = icmp slt i32 %i.load0, %array_size.load1
	%zext_0 = zext i1 %slt0 to i8
	%trunc_0 = trunc i8 %zext_0 to i1
	br i1 %trunc_0, label %for_body_bb_bb0, label %main_bb2
for_iter_bb_bb0:					 ;preds = %for_body_bb_bb0
	%i.load1 = load i32, i32* %i.alloc0, align 4
	%add1 = add i32 %i.load1, 1
	store i32 %add1, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb0
for_body_bb_bb0:					 ;preds = %for_condition_bb_bb0
	%_call_f_getInt00 = call i32 @_f_getInt0()
	%i.load2 = load i32, i32* %i.alloc0, align 4
	%array.load5 = load i32**, i32*** %b.alloc0, align 8
	%gep8 = getelementptr inbounds i32*, i32** %array.load5, i32 0
	%array.load6 = load i32*, i32** %gep8, align 8
	%gep9 = getelementptr inbounds i32, i32* %array.load6, i32 %i.load2
	store i32 %_call_f_getInt00, i32* %gep9, align 4
	br label %for_iter_bb_bb0
main_bb2:					 ;preds = %for_condition_bb_bb0
	store i32 0, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb1
for_condition_bb_bb1:					 ;preds = %main_bb2, %for_iter_bb_bb1
	%array.load7 = load i32**, i32*** %b.alloc0, align 8
	%gep10 = getelementptr inbounds i32*, i32** %array.load7, i32 1
	%_array.load1 = load i32*, i32** %gep10, align 8
	%_array.load1_BC0 = bitcast i32* %_array.load1 to i32*
	%gep11 = getelementptr inbounds i32, i32* %_array.load1_BC0, i32 -1
	%array_size.load2 = load i32, i32* %gep11, align 4
	%i.load3 = load i32, i32* %i.alloc0, align 4
	%slt1 = icmp slt i32 %i.load3, %array_size.load2
	%zext_1 = zext i1 %slt1 to i8
	%trunc_1 = trunc i8 %zext_1 to i1
	br i1 %trunc_1, label %for_body_bb_bb1, label %main_bb3
for_iter_bb_bb1:					 ;preds = %for_body_bb_bb1
	%i.load4 = load i32, i32* %i.alloc0, align 4
	%add2 = add i32 %i.load4, 1
	store i32 %add2, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb1
for_body_bb_bb1:					 ;preds = %for_condition_bb_bb1
	%i.load5 = load i32, i32* %i.alloc0, align 4
	%array.load8 = load i32**, i32*** %b.alloc0, align 8
	%gep12 = getelementptr inbounds i32*, i32** %array.load8, i32 1
	%array.load9 = load i32*, i32** %gep12, align 8
	%gep13 = getelementptr inbounds i32, i32* %array.load9, i32 %i.load5
	%_array.load2 = load i32, i32* %gep13, align 4
	%_call_f_toString01 = call i8* @_f_toString0(i32 %_array.load2)
	call void @_f_print0(i8* %_call_f_toString01)
	br label %for_iter_bb_bb1
main_bb3:					 ;preds = %for_condition_bb_bb1
	%gep14 = getelementptr inbounds [1 x i8], [1 x i8]* @_str_constant0, i32 0, i32 0
	call void @_f_println0(i8* %gep14)
	store i32 0, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb2
for_condition_bb_bb2:					 ;preds = %main_bb3, %for_iter_bb_bb2
	%array.load10 = load i32**, i32*** %b.alloc0, align 8
	%gep15 = getelementptr inbounds i32*, i32** %array.load10, i32 2
	%_array.load3 = load i32*, i32** %gep15, align 8
	%_array.load3_BC0 = bitcast i32* %_array.load3 to i32*
	%gep16 = getelementptr inbounds i32, i32* %_array.load3_BC0, i32 -1
	%array_size.load3 = load i32, i32* %gep16, align 4
	%i.load6 = load i32, i32* %i.alloc0, align 4
	%slt2 = icmp slt i32 %i.load6, %array_size.load3
	%zext_2 = zext i1 %slt2 to i8
	%trunc_2 = trunc i8 %zext_2 to i1
	br i1 %trunc_2, label %for_body_bb_bb2, label %main_bb4
for_iter_bb_bb2:					 ;preds = %for_body_bb_bb2
	%i.load7 = load i32, i32* %i.alloc0, align 4
	%add3 = add i32 %i.load7, 1
	store i32 %add3, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb2
for_body_bb_bb2:					 ;preds = %for_condition_bb_bb2
	%i.load8 = load i32, i32* %i.alloc0, align 4
	%array.load11 = load i32**, i32*** %b.alloc0, align 8
	%gep17 = getelementptr inbounds i32*, i32** %array.load11, i32 2
	%array.load12 = load i32*, i32** %gep17, align 8
	%gep18 = getelementptr inbounds i32, i32* %array.load12, i32 %i.load8
	store i32 0, i32* %gep18, align 4
	br label %for_iter_bb_bb2
main_bb4:					 ;preds = %for_condition_bb_bb2
	store i32 0, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb3
for_condition_bb_bb3:					 ;preds = %main_bb4, %for_iter_bb_bb3
	%array.load13 = load i32**, i32*** %b.alloc0, align 8
	%gep19 = getelementptr inbounds i32*, i32** %array.load13, i32 3
	%_array.load4 = load i32*, i32** %gep19, align 8
	%_array.load4_BC0 = bitcast i32* %_array.load4 to i32*
	%gep20 = getelementptr inbounds i32, i32* %_array.load4_BC0, i32 -1
	%array_size.load4 = load i32, i32* %gep20, align 4
	%i.load9 = load i32, i32* %i.alloc0, align 4
	%slt3 = icmp slt i32 %i.load9, %array_size.load4
	%zext_3 = zext i1 %slt3 to i8
	%trunc_3 = trunc i8 %zext_3 to i1
	br i1 %trunc_3, label %for_body_bb_bb3, label %main_bb5
for_iter_bb_bb3:					 ;preds = %for_body_bb_bb3
	%i.load10 = load i32, i32* %i.alloc0, align 4
	%add4 = add i32 %i.load10, 1
	store i32 %add4, i32* %i.alloc0, align 4
	br label %for_condition_bb_bb3
for_body_bb_bb3:					 ;preds = %for_condition_bb_bb3
	%i.load11 = load i32, i32* %i.alloc0, align 4
	%array.load14 = load i32**, i32*** %b.alloc0, align 8
	%gep21 = getelementptr inbounds i32*, i32** %array.load14, i32 3
	%array.load15 = load i32*, i32** %gep21, align 8
	%gep22 = getelementptr inbounds i32, i32* %array.load15, i32 %i.load11
	%_array.load5 = load i32, i32* %gep22, align 4
	%_call_f_toString02 = call i8* @_f_toString0(i32 %_array.load5)
	call void @_f_print0(i8* %_call_f_toString02)
	br label %for_iter_bb_bb3
main_bb5:					 ;preds = %for_condition_bb_bb3
	store i32 0, i32* %_return.alloc0, align 4
	br label %main_bb1
}
declare i32 @_f_getInt0()
declare void @_f_print0(i8*)
declare void @_f_println0(i8*)
declare i8* @_f_toString0(i32)
declare i8* @_f__malloc0(i32)