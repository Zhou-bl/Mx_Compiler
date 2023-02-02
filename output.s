	.text
	.global	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	addi	sp, sp, -332
	mv	t0, ra
	sw	t0, -20(s0)
	addi	s0, sp, 332
	mv	t0, s1
	sw	t0, -24(s0)
	mv	t0, s2
	sw	t0, -28(s0)
	mv	t0, s3
	sw	t0, -32(s0)
	mv	t0, s4
	sw	t0, -36(s0)
	mv	t0, s5
	sw	t0, -40(s0)
	mv	t0, s6
	sw	t0, -44(s0)
	mv	t0, s7
	sw	t0, -48(s0)
	mv	t0, s8
	sw	t0, -52(s0)
	mv	t0, s9
	sw	t0, -56(s0)
	mv	t0, s10
	sw	t0, -60(s0)
	mv	t0, s11
	sw	t0, -64(s0)
	call	Global_init0
	call	_f_getInt0
	mv	t0, a0
	sw	t0, -68(s0)
	lw	t1, -68(s0)
	lw	t0, 0(t1)
	sw	t0, -72(s0)
	la	t0, n_global0
	sw	t0, -76(s0)
	lw	t1, -76(s0)
	lw	t2, -72(s0)
	sw	t2, 0(t1)
	li	t0, 0
	sw	t0, -80(s0)
	la	t0, i_global0
	sw	t0, -84(s0)
	lw	t1, -84(s0)
	lw	t2, -80(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb_bb0

.main_bb1:
	lw	t0, -8(s0)
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	mv	a0, t1
	lw	t1, -24(s0)
	mv	s1, t1
	lw	t1, -28(s0)
	mv	s2, t1
	lw	t1, -32(s0)
	mv	s3, t1
	lw	t1, -36(s0)
	mv	s4, t1
	lw	t1, -40(s0)
	mv	s5, t1
	lw	t1, -44(s0)
	mv	s6, t1
	lw	t1, -48(s0)
	mv	s7, t1
	lw	t1, -52(s0)
	mv	s8, t1
	lw	t1, -56(s0)
	mv	s9, t1
	lw	t1, -60(s0)
	mv	s10, t1
	lw	t1, -64(s0)
	mv	s11, t1
	lw	t1, -20(s0)
	mv	ra, t1
	addi	sp, sp, 332
	ret

.for_condition_bb_bb0:
	la	t0, n_global0
	sw	t0, -92(s0)
	lw	t1, -92(s0)
	lw	t0, 0(t1)
	sw	t0, -96(s0)
	la	t0, i_global0
	sw	t0, -100(s0)
	lw	t1, -100(s0)
	lw	t0, 0(t1)
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	lw	t2, -96(s0)
	slt	t0, t1, t1
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	bne	t1, zero, .for_body_bb_bb0
	j	.main_bb2

.for_iter_bb_bb0:
	la	t0, i_global0
	sw	t0, -112(s0)
	lw	t1, -112(s0)
	lw	t0, 0(t1)
	sw	t0, -116(s0)
	lw	t1, -116(s0)
	addi	t0, t1, 1
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	lw	t0, 0(t1)
	sw	t0, -124(s0)
	la	t0, i_global0
	sw	t0, -128(s0)
	lw	t1, -128(s0)
	lw	t2, -124(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb_bb0

.for_body_bb_bb0:
	call	_f_getInt0
	mv	t0, a0
	sw	t0, -132(s0)
	lw	t1, -132(s0)
	lw	t0, 0(t1)
	sw	t0, -136(s0)
	la	t0, p_global0
	sw	t0, -140(s0)
	lw	t1, -140(s0)
	lw	t2, -136(s0)
	sw	t2, 0(t1)
	call	_f_getInt0
	mv	t0, a0
	sw	t0, -144(s0)
	lw	t1, -144(s0)
	lw	t0, 0(t1)
	sw	t0, -148(s0)
	la	t0, q_global0
	sw	t0, -152(s0)
	lw	t1, -152(s0)
	lw	t2, -148(s0)
	sw	t2, 0(t1)
	call	_f_getInt0
	mv	t0, a0
	sw	t0, -156(s0)
	lw	t1, -156(s0)
	lw	t0, 0(t1)
	sw	t0, -160(s0)
	la	t0, r_global0
	sw	t0, -164(s0)
	lw	t1, -164(s0)
	lw	t2, -160(s0)
	sw	t2, 0(t1)
	la	t0, p_global0
	sw	t0, -168(s0)
	lw	t1, -168(s0)
	lw	t0, 0(t1)
	sw	t0, -172(s0)
	la	t0, x_global0
	sw	t0, -176(s0)
	lw	t1, -176(s0)
	lw	t0, 0(t1)
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	lw	t2, -172(s0)
	add	t0, t1, t1
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	lw	t0, 0(t1)
	sw	t0, -188(s0)
	la	t0, x_global0
	sw	t0, -192(s0)
	lw	t1, -192(s0)
	lw	t2, -188(s0)
	sw	t2, 0(t1)
	la	t0, q_global0
	sw	t0, -196(s0)
	lw	t1, -196(s0)
	lw	t0, 0(t1)
	sw	t0, -200(s0)
	la	t0, y_global0
	sw	t0, -204(s0)
	lw	t1, -204(s0)
	lw	t0, 0(t1)
	sw	t0, -208(s0)
	lw	t1, -208(s0)
	lw	t2, -200(s0)
	add	t0, t1, t1
	sw	t0, -212(s0)
	lw	t1, -212(s0)
	lw	t0, 0(t1)
	sw	t0, -216(s0)
	la	t0, y_global0
	sw	t0, -220(s0)
	lw	t1, -220(s0)
	lw	t2, -216(s0)
	sw	t2, 0(t1)
	la	t0, r_global0
	sw	t0, -224(s0)
	lw	t1, -224(s0)
	lw	t0, 0(t1)
	sw	t0, -228(s0)
	la	t0, z_global0
	sw	t0, -232(s0)
	lw	t1, -232(s0)
	lw	t0, 0(t1)
	sw	t0, -236(s0)
	lw	t1, -236(s0)
	lw	t2, -228(s0)
	add	t0, t1, t1
	sw	t0, -240(s0)
	lw	t1, -240(s0)
	lw	t0, 0(t1)
	sw	t0, -244(s0)
	la	t0, z_global0
	sw	t0, -248(s0)
	lw	t1, -248(s0)
	lw	t2, -244(s0)
	sw	t2, 0(t1)
	j	.for_iter_bb_bb0

.main_bb2:
	la	t0, x_global0
	sw	t0, -252(s0)
	lw	t1, -252(s0)
	lw	t0, 0(t1)
	sw	t0, -256(s0)
	li	t0, 0
	sw	t0, -260(s0)
	lw	t1, -256(s0)
	lw	t2, -260(s0)
	xor	t0, t1, t1
	sw	t0, -264(s0)
	lw	t1, -264(s0)
	seqz	t0, t1
	sw	t0, -264(s0)
	lw	t1, -264(s0)
	bne	t1, zero, .long_block_bb0
	j	.short_block_bb0

.if_then_bb0:
	la	t0, _str_constant0
	sw	t0, -268(s0)
	lw	t1, -268(s0)
	mv	a0, t1
	call	_f_print0
	j	.main_bb3

.main_bb3:
	li	t0, 0
	sw	t0, -272(s0)
	lw	t2, -272(s0)
	sw	t2, -8(s0)
	j	.main_bb1

.short_block_bb0:
	lw	t1, -264(s0)
	lw	t0, 0(t1)
	sw	t0, -276(s0)
	lw	t2, -276(s0)
	sw	t2, -12(s0)
	j	.terminal_block_bb0

.long_block_bb0:
	la	t0, y_global0
	sw	t0, -280(s0)
	lw	t1, -280(s0)
	lw	t0, 0(t1)
	sw	t0, -284(s0)
	li	t0, 0
	sw	t0, -288(s0)
	lw	t1, -284(s0)
	lw	t2, -288(s0)
	xor	t0, t1, t1
	sw	t0, -292(s0)
	lw	t1, -292(s0)
	seqz	t0, t1
	sw	t0, -292(s0)
	lw	t1, -292(s0)
	lw	t0, 0(t1)
	sw	t0, -296(s0)
	lw	t2, -296(s0)
	sw	t2, -12(s0)
	j	.terminal_block_bb0

.terminal_block_bb0:
	lw	t0, -12(s0)
	sw	t0, -300(s0)
	lw	t1, -300(s0)
	bne	t1, zero, .long_block_bb1
	j	.short_block_bb1

.short_block_bb1:
	lw	t1, -300(s0)
	lw	t0, 0(t1)
	sw	t0, -304(s0)
	lw	t2, -304(s0)
	sw	t2, -16(s0)
	j	.terminal_block_bb1

.long_block_bb1:
	la	t0, z_global0
	sw	t0, -308(s0)
	lw	t1, -308(s0)
	lw	t0, 0(t1)
	sw	t0, -312(s0)
	li	t0, 0
	sw	t0, -316(s0)
	lw	t1, -312(s0)
	lw	t2, -316(s0)
	xor	t0, t1, t1
	sw	t0, -320(s0)
	lw	t1, -320(s0)
	seqz	t0, t1
	sw	t0, -320(s0)
	lw	t1, -320(s0)
	lw	t0, 0(t1)
	sw	t0, -324(s0)
	lw	t2, -324(s0)
	sw	t2, -16(s0)
	j	.terminal_block_bb1

.terminal_block_bb1:
	lw	t0, -16(s0)
	sw	t0, -328(s0)
	lw	t1, -328(s0)
	bne	t1, zero, .if_then_bb0
	j	.if_else_bb0

.if_else_bb0:
	la	t0, _str_constant1
	sw	t0, -332(s0)
	lw	t1, -332(s0)
	mv	a0, t1
	call	_f_print0
	j	.main_bb3

	.size	main, .-main
			 # -- End function
	.global	global_init_x0
	.p2align		1
	.type	global_init_x0,@function
global_init_x0:
.x_entry_bb_bb0:
	addi	sp, sp, -60
	mv	t0, ra
	sw	t0, -8(s0)
	addi	s0, sp, 60
	mv	t0, s1
	sw	t0, -12(s0)
	mv	t0, s2
	sw	t0, -16(s0)
	mv	t0, s3
	sw	t0, -20(s0)
	mv	t0, s4
	sw	t0, -24(s0)
	mv	t0, s5
	sw	t0, -28(s0)
	mv	t0, s6
	sw	t0, -32(s0)
	mv	t0, s7
	sw	t0, -36(s0)
	mv	t0, s8
	sw	t0, -40(s0)
	mv	t0, s9
	sw	t0, -44(s0)
	mv	t0, s10
	sw	t0, -48(s0)
	mv	t0, s11
	sw	t0, -52(s0)
	li	t0, 0
	sw	t0, -56(s0)
	la	t0, x_global0
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	lw	t2, -56(s0)
	sw	t2, 0(t1)
	j	.x_exit_bb_bb0

.x_exit_bb_bb0:
	lw	t1, -12(s0)
	mv	s1, t1
	lw	t1, -16(s0)
	mv	s2, t1
	lw	t1, -20(s0)
	mv	s3, t1
	lw	t1, -24(s0)
	mv	s4, t1
	lw	t1, -28(s0)
	mv	s5, t1
	lw	t1, -32(s0)
	mv	s6, t1
	lw	t1, -36(s0)
	mv	s7, t1
	lw	t1, -40(s0)
	mv	s8, t1
	lw	t1, -44(s0)
	mv	s9, t1
	lw	t1, -48(s0)
	mv	s10, t1
	lw	t1, -52(s0)
	mv	s11, t1
	lw	t1, -8(s0)
	mv	ra, t1
	addi	sp, sp, 60
	ret

	.size	global_init_x0, .-global_init_x0
			 # -- End function
	.global	global_init_y0
	.p2align		1
	.type	global_init_y0,@function
global_init_y0:
.y_entry_bb_bb0:
	addi	sp, sp, -60
	mv	t0, ra
	sw	t0, -8(s0)
	addi	s0, sp, 60
	mv	t0, s1
	sw	t0, -12(s0)
	mv	t0, s2
	sw	t0, -16(s0)
	mv	t0, s3
	sw	t0, -20(s0)
	mv	t0, s4
	sw	t0, -24(s0)
	mv	t0, s5
	sw	t0, -28(s0)
	mv	t0, s6
	sw	t0, -32(s0)
	mv	t0, s7
	sw	t0, -36(s0)
	mv	t0, s8
	sw	t0, -40(s0)
	mv	t0, s9
	sw	t0, -44(s0)
	mv	t0, s10
	sw	t0, -48(s0)
	mv	t0, s11
	sw	t0, -52(s0)
	li	t0, 0
	sw	t0, -56(s0)
	la	t0, y_global0
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	lw	t2, -56(s0)
	sw	t2, 0(t1)
	j	.y_exit_bb_bb0

.y_exit_bb_bb0:
	lw	t1, -12(s0)
	mv	s1, t1
	lw	t1, -16(s0)
	mv	s2, t1
	lw	t1, -20(s0)
	mv	s3, t1
	lw	t1, -24(s0)
	mv	s4, t1
	lw	t1, -28(s0)
	mv	s5, t1
	lw	t1, -32(s0)
	mv	s6, t1
	lw	t1, -36(s0)
	mv	s7, t1
	lw	t1, -40(s0)
	mv	s8, t1
	lw	t1, -44(s0)
	mv	s9, t1
	lw	t1, -48(s0)
	mv	s10, t1
	lw	t1, -52(s0)
	mv	s11, t1
	lw	t1, -8(s0)
	mv	ra, t1
	addi	sp, sp, 60
	ret

	.size	global_init_y0, .-global_init_y0
			 # -- End function
	.global	global_init_z0
	.p2align		1
	.type	global_init_z0,@function
global_init_z0:
.z_entry_bb_bb0:
	addi	sp, sp, -60
	mv	t0, ra
	sw	t0, -8(s0)
	addi	s0, sp, 60
	mv	t0, s1
	sw	t0, -12(s0)
	mv	t0, s2
	sw	t0, -16(s0)
	mv	t0, s3
	sw	t0, -20(s0)
	mv	t0, s4
	sw	t0, -24(s0)
	mv	t0, s5
	sw	t0, -28(s0)
	mv	t0, s6
	sw	t0, -32(s0)
	mv	t0, s7
	sw	t0, -36(s0)
	mv	t0, s8
	sw	t0, -40(s0)
	mv	t0, s9
	sw	t0, -44(s0)
	mv	t0, s10
	sw	t0, -48(s0)
	mv	t0, s11
	sw	t0, -52(s0)
	li	t0, 0
	sw	t0, -56(s0)
	la	t0, z_global0
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	lw	t2, -56(s0)
	sw	t2, 0(t1)
	j	.z_exit_bb_bb0

.z_exit_bb_bb0:
	lw	t1, -12(s0)
	mv	s1, t1
	lw	t1, -16(s0)
	mv	s2, t1
	lw	t1, -20(s0)
	mv	s3, t1
	lw	t1, -24(s0)
	mv	s4, t1
	lw	t1, -28(s0)
	mv	s5, t1
	lw	t1, -32(s0)
	mv	s6, t1
	lw	t1, -36(s0)
	mv	s7, t1
	lw	t1, -40(s0)
	mv	s8, t1
	lw	t1, -44(s0)
	mv	s9, t1
	lw	t1, -48(s0)
	mv	s10, t1
	lw	t1, -52(s0)
	mv	s11, t1
	lw	t1, -8(s0)
	mv	ra, t1
	addi	sp, sp, 60
	ret

	.size	global_init_z0, .-global_init_z0
			 # -- End function
	.global	Global_init0
	.p2align		1
	.type	Global_init0,@function
Global_init0:
.global_all_bb_bb0:
	addi	sp, sp, -52
	mv	t0, ra
	sw	t0, -8(s0)
	addi	s0, sp, 52
	mv	t0, s1
	sw	t0, -12(s0)
	mv	t0, s2
	sw	t0, -16(s0)
	mv	t0, s3
	sw	t0, -20(s0)
	mv	t0, s4
	sw	t0, -24(s0)
	mv	t0, s5
	sw	t0, -28(s0)
	mv	t0, s6
	sw	t0, -32(s0)
	mv	t0, s7
	sw	t0, -36(s0)
	mv	t0, s8
	sw	t0, -40(s0)
	mv	t0, s9
	sw	t0, -44(s0)
	mv	t0, s10
	sw	t0, -48(s0)
	mv	t0, s11
	sw	t0, -52(s0)
	call	global_init_x0
	call	global_init_y0
	call	global_init_z0
	lw	t1, -12(s0)
	mv	s1, t1
	lw	t1, -16(s0)
	mv	s2, t1
	lw	t1, -20(s0)
	mv	s3, t1
	lw	t1, -24(s0)
	mv	s4, t1
	lw	t1, -28(s0)
	mv	s5, t1
	lw	t1, -32(s0)
	mv	s6, t1
	lw	t1, -36(s0)
	mv	s7, t1
	lw	t1, -40(s0)
	mv	s8, t1
	lw	t1, -44(s0)
	mv	s9, t1
	lw	t1, -48(s0)
	mv	s10, t1
	lw	t1, -52(s0)
	mv	s11, t1
	lw	t1, -8(s0)
	mv	ra, t1
	addi	sp, sp, 52
	ret

	.size	Global_init0, .-Global_init0
			 # -- End function
	.type	_str_constant0,@object
	.section	.rodata
_str_constant0:
	.asciz	"YES"
	.size	_str_constant0, 4
	.type	_str_constant1,@object
	.section	.rodata
_str_constant1:
	.asciz	"NO"
	.size	_str_constant1, 3
	.type	p_global0,@object
	.section	.bss
	.globl	p_global0
p_global0:
	.word	0
	.size	p_global0, 4
	.type	q_global0,@object
	.section	.bss
	.globl	q_global0
q_global0:
	.word	0
	.size	q_global0, 4
	.type	r_global0,@object
	.section	.bss
	.globl	r_global0
r_global0:
	.word	0
	.size	r_global0, 4
	.type	x_global0,@object
	.section	.bss
	.globl	x_global0
x_global0:
	.word	0
	.size	x_global0, 4
	.type	y_global0,@object
	.section	.bss
	.globl	y_global0
y_global0:
	.word	0
	.size	y_global0, 4
	.type	z_global0,@object
	.section	.bss
	.globl	z_global0
z_global0:
	.word	0
	.size	z_global0, 4
	.type	n_global0,@object
	.section	.bss
	.globl	n_global0
n_global0:
	.word	0
	.size	n_global0, 4
	.type	i_global0,@object
	.section	.bss
	.globl	i_global0
i_global0:
	.word	0
	.size	i_global0, 4

