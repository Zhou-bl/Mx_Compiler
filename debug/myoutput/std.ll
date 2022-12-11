@a_glo = global i32** zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @_GLOBAL_, i8* null }]
define void @_global_var_init()	{
a_bb:
	%mul = mul i32 30, 8
	%add1 = add i32 %mul, 4
	%_call_f__malloc = call i8* @_f__malloc(i32 %add1)
	%_call_f__malloc_BC = bitcast i8* %_call_f__malloc to i32*
	store i32 30, i32* %_call_f__malloc_BC, align 4
	%gep2 = getelementptr inbounds i32, i32* %_call_f__malloc_BC, i32 1
	%gep2_BC = bitcast i32* %gep2 to i32**
	%array_ptr.alloc = alloca i32, align 4
	store i32 0, i32* %array_ptr.alloc, align 4
	br label %array_new_condition_bb
a_bb1:					 ;preds = %_global_var_init_bb
	ret void
array_new_condition_bb:					 ;preds = %a_bb, %array_new_body_bb
	%array_ptr.load = load i32, i32* %array_ptr.alloc, align 4
	%ne = icmp ne i32 %array_ptr.load, 30
	br i1 %ne, label %array_new_body_bb, label %_global_var_init_bb
array_new_body_bb:					 ;preds = %array_new_condition_bb
	%gep3 = getelementptr inbounds i32*, i32** %gep2_BC, i32 %array_ptr.load
	%mul1 = mul i32 30, 4
	%add2 = add i32 %mul1, 4
	%_call_f__malloc1 = call i8* @_f__malloc(i32 %add2)
	%_call_f__malloc1_BC = bitcast i8* %_call_f__malloc1 to i32*
	store i32 30, i32* %_call_f__malloc1_BC, align 4
	%gep4 = getelementptr inbounds i32, i32* %_call_f__malloc1_BC, i32 1
	%gep4_BC = bitcast i32* %gep4 to i32*
	store i32* %gep4_BC, i32** %gep3, align 8
	%add3 = add i32 %array_ptr.load, 1
	store i32 %add3, i32* %array_ptr.alloc, align 4
	br label %array_new_condition_bb
_global_var_init_bb:					 ;preds = %array_new_condition_bb
	store i32** %gep2_BC, i32*** @a_glo, align 8
	br label %a_bb1
}
define void @_GLOBAL_()	{
_GLOBAL__bb:
	call void @_global_var_init()
	ret void
}
define i32 @main()	{
main_bb:
	%_return.alloc = alloca i32, align 4
	%i.alloc = alloca i32, align 4
	%i.alloc1 = alloca i32, align 4
	store i32 0, i32* %i.alloc1, align 4
	br label %for_condition_bb
main_bb1:					 ;preds = %main_bb2
	%_return.load = load i32, i32* %_return.alloc, align 4
	ret i32 %_return.load
for_condition_bb:					 ;preds = %main_bb, %for_iter_bb
	%i.load = load i32, i32* %i.alloc1, align 4
	%sle = icmp sle i32 %i.load, 29
	%zext_ = zext i1 %sle to i8
	%trunc_ = trunc i8 %zext_ to i1
	br i1 %trunc_, label %for_body_bb, label %main_bb2
for_iter_bb:					 ;preds = %for_body_bb
	%i.load2 = load i32, i32* %i.alloc1, align 4
	%add = add i32 %i.load2, 1
	store i32 %add, i32* %i.alloc1, align 4
	br label %for_condition_bb
for_body_bb:					 ;preds = %for_condition_bb
	%_array.load = load i32**, i32*** @a_glo, align 8
	%i.load1 = load i32, i32* %i.alloc1, align 4
	%gep = getelementptr inbounds i32*, i32** %_array.load, i32 %i.load1
	%_array.load1 = load i32*, i32** %gep, align 8
	%gep1 = getelementptr inbounds i32, i32* %_array.load1, i32 0
	store i32 114514, i32* %gep1, align 4
	br label %for_iter_bb
main_bb2:					 ;preds = %for_condition_bb
	store i32 0, i32* %_return.alloc, align 4
	br label %main_bb1
}
declare i8* @_f__malloc(i32)
