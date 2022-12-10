@_str = private unnamed_addr constant [1 x i8] c"\00", align 1
@a_glo = global i32* zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @_GLOBAL_, i8* null }]
define void @_global_var_init()	{
a_bb:
	%mul1 = mul i32 4, 4
	%add5 = add i32 %mul1, 4
	%_call_f__malloc1 = call i8* @_f__malloc(i32 %add5)
	%_call_f__malloc1_BC = bitcast i8* %_call_f__malloc1 to i32*
	store i32 4, i32* %_call_f__malloc1_BC, align 4
	%gep23 = getelementptr inbounds i32, i32* %_call_f__malloc1_BC, i32 1
	%gep23_BC = bitcast i32* %gep23 to i32*
	store i32* %gep23_BC, i32** @a_glo, align 8
	br label %a_bb1
a_bb1:					 ;preds = %a_bb
	ret void
}

define void @_GLOBAL_()	{
_GLOBAL__bb:
	call void @_global_var_init()
	ret void
}

define i32 @main()	{
main_bb:
	%_return.alloc = alloca i32, align 4
	%b.alloc = alloca i32**, align 8
	%mul = mul i32 4, 8
	%add = add i32 %mul, 4
	%_call_f__malloc = call i8* @_f__malloc(i32 %add)
	%_call_f__malloc_BC = bitcast i8* %_call_f__malloc to i32*
	store i32 4, i32* %_call_f__malloc_BC, align 4
	%gep = getelementptr inbounds i32, i32* %_call_f__malloc_BC, i32 1
	%gep_BC = bitcast i32* %gep to i32**
	store i32** %gep_BC, i32*** %b.alloc, align 8
	%i.alloc = alloca i32, align 4
	%a.load = load i32*, i32** @a_glo, align 8
	%_array.load = load i32**, i32*** %b.alloc, align 8
	%gep1 = getelementptr inbounds i32*, i32** %_array.load, i32 0
	store i32* %a.load, i32** %gep1, align 8
	%a.load1 = load i32*, i32** @a_glo, align 8
	%_array.load1 = load i32**, i32*** %b.alloc, align 8
	%gep2 = getelementptr inbounds i32*, i32** %_array.load1, i32 1
	store i32* %a.load1, i32** %gep2, align 8
	%a.load2 = load i32*, i32** @a_glo, align 8
	%_array.load2 = load i32**, i32*** %b.alloc, align 8
	%gep3 = getelementptr inbounds i32*, i32** %_array.load2, i32 2
	store i32* %a.load2, i32** %gep3, align 8
	%a.load3 = load i32*, i32** @a_glo, align 8
	%_array.load3 = load i32**, i32*** %b.alloc, align 8
	%gep4 = getelementptr inbounds i32*, i32** %_array.load3, i32 3
	store i32* %a.load3, i32** %gep4, align 8
	%b.load = load i32**, i32*** %b.alloc, align 8
	%b.load_BC = bitcast i32** %b.load to i32*
	%gep5 = getelementptr inbounds i32, i32* %b.load_BC, i32 -1
	%array_size.load = load i32, i32* %gep5, align 4
	%_call_f_toString = call i8* @_f_toString(i32 %array_size.load)
	call void @_f_println(i8* %_call_f_toString)
	store i32 0, i32* %i.alloc, align 4
	br label %for_condition_bb
main_bb1:					 ;preds = %main_bb5
	%_return.load = load i32, i32* %_return.alloc, align 4
	ret i32 %_return.load
for_condition_bb:					 ;preds = %main_bb, %for_iter_bb
	%_array.load4 = load i32**, i32*** %b.alloc, align 8
	%gep6 = getelementptr inbounds i32*, i32** %_array.load4, i32 0
	%_array.load5 = load i32*, i32** %gep6, align 8
	%_array.load5_BC = bitcast i32* %_array.load5 to i32*
	%gep7 = getelementptr inbounds i32, i32* %_array.load5_BC, i32 -1
	%array_size.load1 = load i32, i32* %gep7, align 4
	%i.load = load i32, i32* %i.alloc, align 4
	%slt = icmp slt i32 %i.load, %array_size.load1
	%zext_ = zext i1 %slt to i8
	%trunc_ = trunc i8 %zext_ to i1
	br i1 %trunc_, label %for_body_bb, label %main_bb2
for_iter_bb:					 ;preds = %for_body_bb
	%i.load2 = load i32, i32* %i.alloc, align 4
	%add1 = add i32 %i.load2, 1
	store i32 %add1, i32* %i.alloc, align 4
	br label %for_condition_bb
for_body_bb:					 ;preds = %for_condition_bb
	%_call_f_getInt = call i32 @_f_getInt()
	%_array.load6 = load i32**, i32*** %b.alloc, align 8
	%gep8 = getelementptr inbounds i32*, i32** %_array.load6, i32 0
	%_array.load7 = load i32*, i32** %gep8, align 8
	%i.load1 = load i32, i32* %i.alloc, align 4
	%gep9 = getelementptr inbounds i32, i32* %_array.load7, i32 %i.load1
	store i32 %_call_f_getInt, i32* %gep9, align 4
	br label %for_iter_bb
main_bb2:					 ;preds = %for_condition_bb
	store i32 0, i32* %i.alloc, align 4
	br label %for_condition_bb1
for_condition_bb1:					 ;preds = %main_bb2, %for_iter_bb1
	%_array.load8 = load i32**, i32*** %b.alloc, align 8
	%gep10 = getelementptr inbounds i32*, i32** %_array.load8, i32 1
	%_array.load9 = load i32*, i32** %gep10, align 8
	%_array.load9_BC = bitcast i32* %_array.load9 to i32*
	%gep11 = getelementptr inbounds i32, i32* %_array.load9_BC, i32 -1
	%array_size.load2 = load i32, i32* %gep11, align 4
	%i.load3 = load i32, i32* %i.alloc, align 4
	%slt1 = icmp slt i32 %i.load3, %array_size.load2
	%zext_1 = zext i1 %slt1 to i8
	%trunc_1 = trunc i8 %zext_1 to i1
	br i1 %trunc_1, label %for_body_bb1, label %main_bb3
for_iter_bb1:					 ;preds = %for_body_bb1
	%i.load5 = load i32, i32* %i.alloc, align 4
	%add2 = add i32 %i.load5, 1
	store i32 %add2, i32* %i.alloc, align 4
	br label %for_condition_bb1
for_body_bb1:					 ;preds = %for_condition_bb1
	%_array.load10 = load i32**, i32*** %b.alloc, align 8
	%gep12 = getelementptr inbounds i32*, i32** %_array.load10, i32 1
	%_array.load11 = load i32*, i32** %gep12, align 8
	%i.load4 = load i32, i32* %i.alloc, align 4
	%gep13 = getelementptr inbounds i32, i32* %_array.load11, i32 %i.load4
	%_array.load12 = load i32, i32* %gep13, align 4
	%_call_f_toString1 = call i8* @_f_toString(i32 %_array.load12)
	call void @_f_print(i8* %_call_f_toString1)
	br label %for_iter_bb1
main_bb3:					 ;preds = %for_condition_bb1
	%gep14 = getelementptr inbounds [1 x i8], [1 x i8]* @_str, i32 0, i32 0
	call void @_f_println(i8* %gep14)
	store i32 0, i32* %i.alloc, align 4
	br label %for_condition_bb2
for_condition_bb2:					 ;preds = %main_bb3, %for_iter_bb2
	%_array.load13 = load i32**, i32*** %b.alloc, align 8
	%gep15 = getelementptr inbounds i32*, i32** %_array.load13, i32 2
	%_array.load14 = load i32*, i32** %gep15, align 8
	%_array.load14_BC = bitcast i32* %_array.load14 to i32*
	%gep16 = getelementptr inbounds i32, i32* %_array.load14_BC, i32 -1
	%array_size.load3 = load i32, i32* %gep16, align 4
	%i.load6 = load i32, i32* %i.alloc, align 4
	%slt2 = icmp slt i32 %i.load6, %array_size.load3
	%zext_2 = zext i1 %slt2 to i8
	%trunc_2 = trunc i8 %zext_2 to i1
	br i1 %trunc_2, label %for_body_bb2, label %main_bb4
for_iter_bb2:					 ;preds = %for_body_bb2
	%i.load8 = load i32, i32* %i.alloc, align 4
	%add3 = add i32 %i.load8, 1
	store i32 %add3, i32* %i.alloc, align 4
	br label %for_condition_bb2
for_body_bb2:					 ;preds = %for_condition_bb2
	%_array.load15 = load i32**, i32*** %b.alloc, align 8
	%gep17 = getelementptr inbounds i32*, i32** %_array.load15, i32 2
	%_array.load16 = load i32*, i32** %gep17, align 8
	%i.load7 = load i32, i32* %i.alloc, align 4
	%gep18 = getelementptr inbounds i32, i32* %_array.load16, i32 %i.load7
	store i32 0, i32* %gep18, align 4
	br label %for_iter_bb2
main_bb4:					 ;preds = %for_condition_bb2
	store i32 0, i32* %i.alloc, align 4
	br label %for_condition_bb3
for_condition_bb3:					 ;preds = %main_bb4, %for_iter_bb3
	%_array.load17 = load i32**, i32*** %b.alloc, align 8
	%gep19 = getelementptr inbounds i32*, i32** %_array.load17, i32 3
	%_array.load18 = load i32*, i32** %gep19, align 8
	%_array.load18_BC = bitcast i32* %_array.load18 to i32*
	%gep20 = getelementptr inbounds i32, i32* %_array.load18_BC, i32 -1
	%array_size.load4 = load i32, i32* %gep20, align 4
	%i.load9 = load i32, i32* %i.alloc, align 4
	%slt3 = icmp slt i32 %i.load9, %array_size.load4
	%zext_3 = zext i1 %slt3 to i8
	%trunc_3 = trunc i8 %zext_3 to i1
	br i1 %trunc_3, label %for_body_bb3, label %main_bb5
for_iter_bb3:					 ;preds = %for_body_bb3
	%i.load11 = load i32, i32* %i.alloc, align 4
	%add4 = add i32 %i.load11, 1
	store i32 %add4, i32* %i.alloc, align 4
	br label %for_condition_bb3
for_body_bb3:					 ;preds = %for_condition_bb3
	%_array.load19 = load i32**, i32*** %b.alloc, align 8
	%gep21 = getelementptr inbounds i32*, i32** %_array.load19, i32 3
	%_array.load20 = load i32*, i32** %gep21, align 8
	%i.load10 = load i32, i32* %i.alloc, align 4
	%gep22 = getelementptr inbounds i32, i32* %_array.load20, i32 %i.load10
	%_array.load21 = load i32, i32* %gep22, align 4
	%_call_f_toString2 = call i8* @_f_toString(i32 %_array.load21)
	call void @_f_print(i8* %_call_f_toString2)
	br label %for_iter_bb3
main_bb5:					 ;preds = %for_condition_bb3
	store i32 0, i32* %_return.alloc, align 4
	br label %main_bb1
}
declare i32 @_f_getInt()
declare void @_f_print(i8*)
declare void @_f_println(i8*)
declare i8* @_f_toString(i32)
declare i8* @_f__malloc(i32)


Process finished with exit code 0
