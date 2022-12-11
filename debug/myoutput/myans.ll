@a_global0 = dso_local global i32** zeroinitializer, align 8
@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @Global_init0, i8* null }]
define void @global_init_a0() {
a_entry_bb_bb0:
	%mul0 = mul i32 30, 8
	%add1 = add i32 %mul0, 4
	%_call_f__malloc00 = call i8* @_f__malloc0(i32 %add1)
	%_call_f__malloc00_BC0 = bitcast i8* %_call_f__malloc00 to i32*
	store i32 30, i32* %_call_f__malloc00_BC0, align 4
	%gep2 = getelementptr inbounds i32, i32* %_call_f__malloc00_BC0, i32 1
	%gep2_BC0 = bitcast i32* %gep2 to i32**
	%alloc_iter_ptr.alloc0 = alloca i32, align 8
	store i32 0, i32* %alloc_iter_ptr.alloc0, align 4
	br label %alloc_condition_bb_bb0
a_exit_bb_bb0:					 ;preds = %global_init_a0_bb0
	ret void
alloc_condition_bb_bb0:					 ;preds = %a_entry_bb_bb0
	%alloc_iter_value.load0 = load i32, i32* %alloc_iter_ptr.alloc0, align 4
	%ne0 = icmp ne i32 %alloc_iter_value.load0, 30
	br i1 %ne0, label %alloc_body_bb_bb0, label %global_init_a0_bb0
alloc_body_bb_bb0:					 ;preds = %alloc_condition_bb_bb0
	%gep3 = getelementptr inbounds i32*, i32** %gep2_BC0, i32 %alloc_iter_value.load0
	%mul1 = mul i32 30, 4
	%add2 = add i32 %mul1, 4
	%_call_f__malloc01 = call i8* @_f__malloc0(i32 %add2)
	%_call_f__malloc01_BC0 = bitcast i8* %_call_f__malloc01 to i32*
	store i32 30, i32* %_call_f__malloc01_BC0, align 4
	%gep4 = getelementptr inbounds i32, i32* %_call_f__malloc01_BC0, i32 1
	%gep4_BC0 = bitcast i32* %gep4 to i32*
	store i32* %gep4_BC0, i32** %gep3, align 8
	%add3 = add i32 1, %alloc_iter_value.load0
	store i32 %add3, i32* %alloc_iter_ptr.alloc0, align 4
	br label %global_init_a0_bb0
global_init_a0_bb0:					 ;preds = %alloc_condition_bb_bb0, %alloc_body_bb_bb0
	store i32** %gep2_BC0, i32*** @a_global0, align 8
	br label %a_exit_bb_bb0
}
define void @Global_init0() {
global_all_bb_bb0:
	call void @global_init_a0()
	ret void
}
define i32 @main() {
main_bb0:
	%_return.alloc0 = alloca i32, align 8
	%i.alloc0 = alloca i32, align 8
	%i.alloc1 = alloca i32, align 8
	store i32 0, i32* %i.alloc1, align 4
	br label %for_condition_bb_bb0
main_bb1:					 ;preds = %main_bb2
	%_return.load0 = load i32, i32* %_return.alloc0, align 4
	ret i32 %_return.load0
for_condition_bb_bb0:					 ;preds = %main_bb0, %for_iter_bb_bb0
	%i.load0 = load i32, i32* %i.alloc1, align 4
	%sle0 = icmp sle i32 %i.load0, 29
	%zext_0 = zext i1 %sle0 to i8
	%trunc_0 = trunc i8 %zext_0 to i1
	br i1 %trunc_0, label %for_body_bb_bb0, label %main_bb2
for_iter_bb_bb0:					 ;preds = %for_body_bb_bb0
	%i.load2 = load i32, i32* %i.alloc1, align 4
	%add0 = add i32 %i.load2, 1
	store i32 %add0, i32* %i.alloc1, align 4
	br label %for_condition_bb_bb0
for_body_bb_bb0:					 ;preds = %for_condition_bb_bb0
	%i.load1 = load i32, i32* %i.alloc1, align 4
	%array.load0 = load i32**, i32*** @a_global0, align 8
	%gep0 = getelementptr inbounds i32*, i32** %array.load0, i32 0
	%array.load1 = load i32*, i32** %gep0, align 8
	%gep1 = getelementptr inbounds i32, i32* %array.load1, i32 %i.load1
	store i32 114514, i32* %gep1, align 4
	br label %for_iter_bb_bb0
main_bb2:					 ;preds = %for_condition_bb_bb0
	store i32 0, i32* %_return.alloc0, align 4
	br label %main_bb1
}
declare i8* @_f__malloc0(i32)
