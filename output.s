	.text
	.globl	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	addi	sp, sp, -324
	mv	s1, s0
	addi	s0, sp, 324
	mv	t0, s1
	sw	t0, -16(s0)
	mv	t0, ra
	sw	t0, -20(s0)
	call	_f_getInt0
	lw	t1, -20(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -24(s0)
	la	t0, n_global0
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	lw	t2, -24(s0)
	sw	t2, 0(t1)
	mv	t0, ra
	sw	t0, -32(s0)
	call	_f_getInt0
	lw	t1, -32(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -36(s0)
	la	t0, p_global0
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sw	t2, 0(t1)
	mv	t0, ra
	sw	t0, -44(s0)
	call	_f_getInt0
	lw	t1, -44(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -48(s0)
	la	t0, k_global0
	sw	t0, -52(s0)
	lw	t1, -52(s0)
	lw	t2, -48(s0)
	sw	t2, 0(t1)
	la	t0, k_global0
	sw	t0, -56(s0)
	lw	t1, -56(s0)
	lw	t0, 0(t1)
	sw	t0, -60(s0)
	la	t0, p_global0
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t0, 0(t1)
	sw	t0, -68(s0)
	lw	t1, -68(s0)
	lw	t2, -60(s0)
	sub	t0, t1, t1
	sw	t0, -72(s0)
	li	t0, 1
	sw	t0, -76(s0)
	lw	t1, -76(s0)
	lw	t2, -72(s0)
	slt	t0, t1, t1
	sw	t0, -80(s0)
	lw	t1, -80(s0)
	bne	t1, zero, .if_then_bb0
	j	.main_bb2

.main_bb1:
	lw	t0, -8(s0)
	sw	t0, -84(s0)
	lw	t1, -84(s0)
	mv	a0, t1
	lw	t1, -16(s0)
	mv	s0, t1
	addi	sp, sp, 324
	ret

.if_then_bb0:
	la	t0, _str_constant0
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -92(s0)
	call	_f_print0
	lw	t1, -92(s0)
	mv	ra, t1
	j	.main_bb2

.main_bb2:
	la	t0, k_global0
	sw	t0, -96(s0)
	lw	t1, -96(s0)
	lw	t0, 0(t1)
	sw	t0, -100(s0)
	la	t0, p_global0
	sw	t0, -104(s0)
	lw	t1, -104(s0)
	lw	t0, 0(t1)
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	lw	t2, -100(s0)
	sub	t0, t1, t1
	sw	t0, -112(s0)
	la	t0, i_global0
	sw	t0, -116(s0)
	lw	t1, -116(s0)
	lw	t2, -112(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb_bb0

.for_condition_bb_bb0:
	la	t0, k_global0
	sw	t0, -120(s0)
	lw	t1, -120(s0)
	lw	t0, 0(t1)
	sw	t0, -124(s0)
	la	t0, p_global0
	sw	t0, -128(s0)
	lw	t1, -128(s0)
	lw	t0, 0(t1)
	sw	t0, -132(s0)
	lw	t1, -132(s0)
	lw	t2, -124(s0)
	add	t0, t1, t1
	sw	t0, -136(s0)
	la	t0, i_global0
	sw	t0, -140(s0)
	lw	t1, -140(s0)
	lw	t0, 0(t1)
	sw	t0, -144(s0)
	lw	t1, -136(s0)
	lw	t2, -144(s0)
	slt	t0, t1, t1
	sw	t0, -148(s0)
	lw	t1, -148(s0)
	xori	t0, t1, 1
	sw	t0, -148(s0)
	lw	t1, -148(s0)
	bne	t1, zero, .for_body_bb_bb0
	j	.main_bb3

.for_iter_bb_bb0:
	la	t0, i_global0
	sw	t0, -152(s0)
	lw	t1, -152(s0)
	lw	t0, 0(t1)
	sw	t0, -156(s0)
	lw	t1, -156(s0)
	addi	t0, t1, 1
	sw	t0, -160(s0)
	la	t0, i_global0
	sw	t0, -164(s0)
	lw	t1, -164(s0)
	lw	t2, -160(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb_bb0

.for_body_bb_bb0:
	la	t0, i_global0
	sw	t0, -168(s0)
	lw	t1, -168(s0)
	lw	t0, 0(t1)
	sw	t0, -172(s0)
	li	t0, 1
	sw	t0, -176(s0)
	lw	t1, -172(s0)
	lw	t2, -176(s0)
	slt	t0, t1, t1
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	xori	t0, t1, 1
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	bne	t1, zero, .long_block_bb0
	j	.short_block_bb0

.main_bb3:
	la	t0, n_global0
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	lw	t0, 0(t1)
	sw	t0, -188(s0)
	la	t0, k_global0
	sw	t0, -192(s0)
	lw	t1, -192(s0)
	lw	t0, 0(t1)
	sw	t0, -196(s0)
	la	t0, p_global0
	sw	t0, -200(s0)
	lw	t1, -200(s0)
	lw	t0, 0(t1)
	sw	t0, -204(s0)
	lw	t1, -204(s0)
	lw	t2, -196(s0)
	add	t0, t1, t1
	sw	t0, -208(s0)
	lw	t1, -208(s0)
	lw	t2, -188(s0)
	slt	t0, t1, t1
	sw	t0, -212(s0)
	lw	t1, -212(s0)
	bne	t1, zero, .if_then_bb3
	j	.main_bb6

.if_then_bb1:
	la	t0, p_global0
	sw	t0, -216(s0)
	lw	t1, -216(s0)
	lw	t0, 0(t1)
	sw	t0, -220(s0)
	la	t0, i_global0
	sw	t0, -224(s0)
	lw	t1, -224(s0)
	lw	t0, 0(t1)
	sw	t0, -228(s0)
	lw	t1, -228(s0)
	lw	t2, -220(s0)
	xor	t0, t1, t1
	sw	t0, -232(s0)
	lw	t1, -232(s0)
	seqz	t0, t1
	sw	t0, -232(s0)
	lw	t1, -232(s0)
	bne	t1, zero, .if_then_bb2
	j	.if_else_bb0

.main_bb4:
	j	.for_iter_bb_bb0

.short_block_bb0:
	lw	t2, -180(s0)
	sw	t2, -12(s0)
	j	.terminal_block_bb0

.long_block_bb0:
	la	t0, n_global0
	sw	t0, -236(s0)
	lw	t1, -236(s0)
	lw	t0, 0(t1)
	sw	t0, -240(s0)
	la	t0, i_global0
	sw	t0, -244(s0)
	lw	t1, -244(s0)
	lw	t0, 0(t1)
	sw	t0, -248(s0)
	lw	t1, -240(s0)
	lw	t2, -248(s0)
	slt	t0, t1, t1
	sw	t0, -252(s0)
	lw	t1, -252(s0)
	xori	t0, t1, 1
	sw	t0, -252(s0)
	lw	t2, -252(s0)
	sw	t2, -12(s0)
	j	.terminal_block_bb0

.terminal_block_bb0:
	lw	t0, -12(s0)
	sw	t0, -256(s0)
	lw	t1, -256(s0)
	bne	t1, zero, .if_then_bb1
	j	.main_bb4

.if_then_bb2:
	la	t0, _str_constant1
	sw	t0, -260(s0)
	lw	t1, -260(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -264(s0)
	call	_f_print0
	lw	t1, -264(s0)
	mv	ra, t1
	la	t0, i_global0
	sw	t0, -268(s0)
	lw	t1, -268(s0)
	lw	t0, 0(t1)
	sw	t0, -272(s0)
	lw	t1, -272(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -276(s0)
	call	_f_toString0
	lw	t1, -276(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -280(s0)
	lw	t1, -280(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -284(s0)
	call	_f_print0
	lw	t1, -284(s0)
	mv	ra, t1
	la	t0, _str_constant2
	sw	t0, -288(s0)
	lw	t1, -288(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -292(s0)
	call	_f_print0
	lw	t1, -292(s0)
	mv	ra, t1
	j	.main_bb5

.main_bb5:
	j	.main_bb4

.if_else_bb0:
	la	t0, i_global0
	sw	t0, -296(s0)
	lw	t1, -296(s0)
	lw	t0, 0(t1)
	sw	t0, -300(s0)
	lw	t1, -300(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -304(s0)
	call	_f_printInt0
	lw	t1, -304(s0)
	mv	ra, t1
	la	t0, _str_constant3
	sw	t0, -308(s0)
	lw	t1, -308(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -312(s0)
	call	_f_print0
	lw	t1, -312(s0)
	mv	ra, t1
	j	.main_bb5

.if_then_bb3:
	la	t0, _str_constant4
	sw	t0, -316(s0)
	lw	t1, -316(s0)
	mv	a0, t1
	mv	t0, ra
	sw	t0, -320(s0)
	call	_f_print0
	lw	t1, -320(s0)
	mv	ra, t1
	j	.main_bb6

.main_bb6:
	li	t0, 0
	sw	t0, -324(s0)
	lw	t2, -324(s0)
	sw	t2, -8(s0)
	j	.main_bb1

	.size	main, .-main
			 # -- End function
	.type	_str_constant0,@object
	.section	.rodata
_str_constant0:
	.asciz	"<< "
	.size	_str_constant0, 4
	.type	_str_constant1,@object
	.section	.rodata
_str_constant1:
	.asciz	"("
	.size	_str_constant1, 2
	.type	_str_constant2,@object
	.section	.rodata
_str_constant2:
	.asciz	") "
	.size	_str_constant2, 3
	.type	_str_constant3,@object
	.section	.rodata
_str_constant3:
	.asciz	" "
	.size	_str_constant3, 2
	.type	_str_constant4,@object
	.section	.rodata
_str_constant4:
	.asciz	">> "
	.size	_str_constant4, 4
	.type	n_global0,@object
	.section	.bss
	.globl	n_global0
n_global0:
	.word	0
	.size	n_global0, 4
	.type	p_global0,@object
	.section	.bss
	.globl	p_global0
p_global0:
	.word	0
	.size	p_global0, 4
	.type	k_global0,@object
	.section	.bss
	.globl	k_global0
k_global0:
	.word	0
	.size	k_global0, 4
	.type	i_global0,@object
	.section	.bss
	.globl	i_global0
i_global0:
	.word	0
	.size	i_global0, 4

