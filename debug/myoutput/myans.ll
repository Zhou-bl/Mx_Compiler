define i32 @main() {
main_bb0:
	%_return.alloc0 = alloca i32, align 8
	%a.alloc0 = alloca i32**, align 8
	%mul0 = mul i32 3, 8
	%add0 = add i32 %mul0, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add0)
	%_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
	store i32 3, i32* %_call_f__malloc00_BC0, align 4
	%gep0 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
	%gep0_BC0 = bitcast i32* %gep0 to i32**
	%alloc_iter_ptr.alloc0 = alloca i32, align 8
	store i32 0, i32* %alloc_iter_ptr.alloc0, align 4
	br label %alloc_condition_bb_bb0
main_bb1:					 ;preds = %main_bb2
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
alloc_condition_bb_bb0:					 ;preds = %main_bb0, %alloc_body_bb_bb0
	%alloc_iter_value.load0 = load i32, i32* %alloc_iter_ptr.alloc0, align 4
	%ne0 = icmp ne i32 %alloc_iter_value.load0, 3
	br i1 %ne0, label %alloc_body_bb_bb0, label %main_bb2
alloc_body_bb_bb0:					 ;preds = %alloc_condition_bb_bb0
	%gep1 = getelementptr inbounds i32*, i32** %gep0_BC0, i32 %alloc_iter_value.load0
	%mul1 = mul i32 3, 4
	%add1 = add i32 %mul1, 4
	%_call_f__malloc01 = call i8* @_f__malloc0(i32 %add1)
	%_call_f__malloc01_BC0 = bitcast i8* %_call_f__malloc01 to i32*
	store i32 3, i32* %_call_f__malloc01_BC0, align 4
	%gep2 = getelementptr inbounds i32, i32* %_call_f__malloc01_BC0, i32 1
	%gep2_BC0 = bitcast i32* %gep2 to i32*
	store i32* %gep2_BC0, i32** %gep1, align 8
	%add2 = add i32 1, %alloc_iter_value.load0
	store i32 %add2, i32* %alloc_iter_ptr.alloc0, align 4
	br label %main_bb2
main_bb2:					 ;preds = %alloc_condition_bb_bb0, %alloc_body_bb_bb0
	store i32** %gep0_BC0, i32*** %a.alloc0, align 8
	%array.load0 = load i32**, i32*** %a.alloc0, align 8
	%gep3 = getelementptr inbounds i32*, i32** %array.load0, i32 0
	%array.load1 = load i32*, i32** %gep3, align 8
	%gep4 = getelementptr inbounds i32, i32* %array.load1, i32 0
	store i32 114514, i32* %gep4, align 4
	%array.load2 = load i32**, i32*** %a.alloc0, align 8
	%gep5 = getelementptr inbounds i32*, i32** %array.load2, i32 1
	%array.load3 = load i32*, i32** %gep5, align 8
	%gep6 = getelementptr inbounds i32, i32* %array.load3, i32 0
	store i32 114514, i32* %gep6, align 4
	store i32 0, i32* %_return.alloc0, align 4
	br label %main_bb1
}
declare i8* @_f__malloc0(i32)
