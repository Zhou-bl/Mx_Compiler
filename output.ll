@n_global0 = dso_local global i32 zeroinitializer, align 4
@r_global0 = dso_local global i32 zeroinitializer, align 4
@c_global0 = dso_local global i32 zeroinitializer, align 4
@i_global0 = dso_local global i32 zeroinitializer, align 4
@j_global0 = dso_local global i32 zeroinitializer, align 4
define i32 @main() {
main_bb0:
	%_return.alloc1 = alloca i32, align 4
	%_call_f_getInt00 = call i32 @_f_getInt0()
	store i32 %_call_f_getInt00, i32* @n_global0, align 4
	store i32 0, i32* %_return.alloc1, align 4
	br label %main_bb1
main_bb1:					 ;preds = %main_bb0
	%_return.load1 = load i32, i32* %_return.alloc1, align 4
	ret i32 %_return.load1
}
declare i32 @_f_getInt0()
define i32 @_f_abs0(i32 %_arg0) {
_f_abs0_bb0:
	%_return.alloc0 = alloca i32, align 4
	%c.alloc0 = alloca i32, align 4
	store i32 %_arg0, i32* %c.alloc0, align 4
	%c.load0 = load i32, i32* %c.alloc0, align 4
	%sgt0 = icmp sgt i32 %c.load0, 0
	%zext_0 = zext i1 %sgt0 to i8
	%trunc_0 = trunc i8 %zext_0 to i1
	br i1 %trunc_0, label %if_then_bb0, label %_f_abs0_bb2
_f_abs0_bb1:					 ;preds = %if_then_bb0, %_f_abs0_bb2
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
if_then_bb0:					 ;preds = %_f_abs0_bb0
	%c.load1 = load i32, i32* %c.alloc0, align 4
	store i32 %c.load1, i32* %_return.alloc0, align 4
	br label %_f_abs0_bb1
_f_abs0_bb2:					 ;preds = %_f_abs0_bb0, %if_then_bb0
	%c.load2 = load i32, i32* %c.alloc0, align 4
	%sub0 = sub i32 0, %c.load2
	store i32 %sub0, i32* %_return.alloc0, align 4
	br label %_f_abs0_bb1
}

