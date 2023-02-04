define i32 @main() {
main_bb0:
	%_return.alloc0 = alloca i32, align 4
	store i32 0, i32* %_return.alloc0, align 4
	br label %main_bb1
main_bb1:					 ;preds = %main_bb0
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
}

