@n_glo = global i32 zeroinitializer, align 4
@r_glo = global i32 zeroinitializer, align 4
@c_glo = global i32 zeroinitializer, align 4
@i_glo = global i32 zeroinitializer, align 4
@j_glo = global i32 zeroinitializer, align 4
define i32 @main()	{
main_bb:
	%_return.alloc1 = alloca i32, align 4
	%_call_f_getInt = call i32 @_f_getInt()
	store i32 %_call_f_getInt, i32* @n_glo, align 4
	store i32 0, i32* %_return.alloc1, align 4
	br label %main_bb1
main_bb1:					 ;preds = %main_bb
	%_return.load1 = load i32, i32* %_return.alloc1, align 4
	ret i32 %_return.load1
}
declare i32 @_f_getInt()
define i32 @_f_abs(i32 %_arg)	{
_f_abs_bb:
	%_return.alloc = alloca i32, align 4
	%c.alloc = alloca i32, align 4
	store i32 %_arg, i32* %c.alloc, align 4
	%c.load = load i32, i32* %c.alloc, align 4
	%sgt = icmp sgt i32 %c.load, 0
	%zext_ = zext i1 %sgt to i8
	%trunc_ = trunc i8 %zext_ to i1
	br i1 %trunc_, label %if_then_bb, label %_f_abs_bb2
_f_abs_bb1:					 ;preds = %if_then_bb, %_f_abs_bb2
	%_return.load = load i32, i32* %_return.alloc, align 4
	ret i32 %_return.load
if_then_bb:					 ;preds = %_f_abs_bb
	%c.load1 = load i32, i32* %c.alloc, align 4
	store i32 %c.load1, i32* %_return.alloc, align 4
	br label %_f_abs_bb1
_f_abs_bb2:					 ;preds = %_f_abs_bb, %if_then_bb
	%c.load2 = load i32, i32* %c.alloc, align 4
	%sub = sub i32 0, %c.load2
	store i32 %sub, i32* %_return.alloc, align 4
	br label %_f_abs_bb1
}

