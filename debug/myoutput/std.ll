define i32 @main()	{
main_bb0:
	%_return.alloc0 = alloca i32, align 4
	%a.alloc0 = alloca i32**, align 8
	%mul0 = mul i32 3, 8
	%add0 = add i32 %mul0, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add0)
	%_call_f__malloc_BC = bitcast i8* %_call_f__malloc to i32*
	store i32 3, i32* %_call_f__malloc_BC, align 4
	%gep = getelementptr inbounds i32, i32* %_call_f__malloc_BC, i32 1
	%gep_BC = bitcast i32* %gep to i32**
	%array_ptr.alloc = alloca i32, align 4
	store i32 0, i32* %array_ptr.alloc, align 4
	br label %array_new_condition_bb
main_bb1:					 ;preds = %main_bb2
	%_return.load = load i32, i32* %_return.alloc, align 4
	ret i32 %_return.load
array_new_condition_bb:					 ;preds = %main_bb, %array_new_body_bb
	%array_ptr.load = load i32, i32* %array_ptr.alloc, align 4
	%ne = icmp ne i32 %array_ptr.load, 3
	br i1 %ne, label %array_new_body_bb, label %main_bb2
array_new_body_bb:					 ;preds = %array_new_condition_bb
	%gep1 = getelementptr inbounds i32*, i32** %gep_BC, i32 %array_ptr.load
	%mul1 = mul i32 3, 4
	%add1 = add i32 %mul1, 4
	%_call_f__malloc1 = call i8* @_f__malloc(i32 %add1)
	%_call_f__malloc1_BC = bitcast i8* %_call_f__malloc1 to i32*
	store i32 3, i32* %_call_f__malloc1_BC, align 4
	%gep2 = getelementptr inbounds i32, i32* %_call_f__malloc1_BC, i32 1
	%gep2_BC = bitcast i32* %gep2 to i32*
	store i32* %gep2_BC, i32** %gep1, align 8
	%add2 = add i32 %array_ptr.load, 1
	store i32 %add2, i32* %array_ptr.alloc, align 4
	br label %array_new_condition_bb
main_bb2:					 ;preds = %array_new_condition_bb
	store i32** %gep_BC, i32*** %a.alloc, align 8
	%_array.load = load i32**, i32*** %a.alloc, align 8
	%gep3 = getelementptr inbounds i32*, i32** %_array.load, i32 0
	%_array.load1 = load i32*, i32** %gep3, align 8
	%gep4 = getelementptr inbounds i32, i32* %_array.load1, i32 0
	store i32 114514, i32* %gep4, align 4
	%_array.load2 = load i32**, i32*** %a.alloc, align 8
	%gep5 = getelementptr inbounds i32*, i32** %_array.load2, i32 1
	%_array.load3 = load i32*, i32** %gep5, align 8
	%gep6 = getelementptr inbounds i32, i32* %_array.load3, i32 0
	store i32 114514, i32* %gep6, align 4
	store i32 0, i32* %_return.alloc, align 4
	br label %main_bb1
}
declare i8* @_f__malloc(i32)
