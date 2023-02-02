	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
.main_bb:
	addi	sp, sp, -204
	mv	s1,s0
	addi	s0, sp, 204
	mv	t0,s1
	sw	t0, -8(s0)
	li	t0,0
	sw	t0, -12(s0)
	la	t0,i_glo
	sw	t0, -16(s0)
	lw	t1, -16(s0)
	lw	t2, -12(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	mv	a0,t1
	lw	t1, -8(s0)
	mv	s0,t1
	addi	sp, sp, 204
	ret

.for_condition_bb:
	la	t0,i_glo
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	lw	t0, 0(t1)
	sw	t0, -28(s0)
	li	t0,5
	sw	t0, -32(s0)
	lw	t1, -28(s0)
	lw	t2, -32(s0)
	slt	t0, t1, t2
	sw	t0, -36(s0)
	lw	t1, -36(s0)
	bne	t1,zero,.for_body_bb
	j	.main_bb2

.for_iter_bb:
	la	t0,i_glo
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t0, 0(t1)
	sw	t0, -44(s0)
	lw	t1, -44(s0)
	addi	t0, t1, 1
	sw	t0, -48(s0)
	la	t0,i_glo
	sw	t0, -52(s0)
	lw	t1, -52(s0)
	lw	t2, -48(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb

.for_body_bb:
	li	t0,0
	sw	t0, -56(s0)
	la	t0,j_glo
	sw	t0, -60(s0)
	lw	t1, -60(s0)
	lw	t2, -56(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb1

.main_bb2:
	la	t0,c_glo
	sw	t0, -64(s0)
	lw	t1, -64(s0)
	lw	t0, 0(t1)
	sw	t0, -68(s0)
	li	t0,2
	sw	t0, -72(s0)
	lw	t1, -72(s0)
	lw	t2, -68(s0)
	sub	t0, t1, t2
	sw	t0, -76(s0)
	lw	t1, -76(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -80(s0)
	call	_f_abs
	lw	t1, -80(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -84(s0)
	la	t0,r_glo
	sw	t0, -88(s0)
	lw	t1, -88(s0)
	lw	t0, 0(t1)
	sw	t0, -92(s0)
	li	t0,2
	sw	t0, -96(s0)
	lw	t1, -96(s0)
	lw	t2, -92(s0)
	sub	t0, t1, t2
	sw	t0, -100(s0)
	lw	t1, -100(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -104(s0)
	call	_f_abs
	lw	t1, -104(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -108(s0)
	lw	t1, -108(s0)
	lw	t2, -84(s0)
	add	t0, t1, t2
	sw	t0, -112(s0)
	lw	t1, -112(s0)
	mv	a0,t1
	mv	t0,ra
	sw	t0, -116(s0)
	call	_f_printInt
	lw	t1, -116(s0)
	mv	ra,t1
	li	t0,0
	sw	t0, -120(s0)
	lw	t2, -120(s0)
	sw	t2, -4(s0)
	j	.main_bb1

.for_condition_bb1:
	la	t0,j_glo
	sw	t0, -124(s0)
	lw	t1, -124(s0)
	lw	t0, 0(t1)
	sw	t0, -128(s0)
	li	t0,5
	sw	t0, -132(s0)
	lw	t1, -128(s0)
	lw	t2, -132(s0)
	slt	t0, t1, t2
	sw	t0, -136(s0)
	lw	t1, -136(s0)
	bne	t1,zero,.for_body_bb1
	j	.main_bb3

.for_iter_bb1:
	la	t0,j_glo
	sw	t0, -140(s0)
	lw	t1, -140(s0)
	lw	t0, 0(t1)
	sw	t0, -144(s0)
	lw	t1, -144(s0)
	addi	t0, t1, 1
	sw	t0, -148(s0)
	la	t0,j_glo
	sw	t0, -152(s0)
	lw	t1, -152(s0)
	lw	t2, -148(s0)
	sw	t2, 0(t1)
	j	.for_condition_bb1

.for_body_bb1:
	mv	t0,ra
	sw	t0, -156(s0)
	call	_f_getInt
	lw	t1, -156(s0)
	mv	ra,t1
	mv	t0,a0
	sw	t0, -160(s0)
	la	t0,n_glo
	sw	t0, -164(s0)
	lw	t1, -164(s0)
	lw	t2, -160(s0)
	sw	t2, 0(t1)
	la	t0,n_glo
	sw	t0, -168(s0)
	lw	t1, -168(s0)
	lw	t0, 0(t1)
	sw	t0, -172(s0)
	li	t0,1
	sw	t0, -176(s0)
	lw	t1, -172(s0)
	lw	t2, -176(s0)
	xor	t0, t1, t2
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	seqz	t0, t1
	sw	t0, -180(s0)
	lw	t1, -180(s0)
	bne	t1,zero,.if_then_bb1
	j	.main_bb4

.main_bb3:
	j	.for_iter_bb

.if_then_bb1:
	la	t0,i_glo
	sw	t0, -184(s0)
	lw	t1, -184(s0)
	lw	t0, 0(t1)
	sw	t0, -188(s0)
	la	t0,r_glo
	sw	t0, -192(s0)
	lw	t1, -192(s0)
	lw	t2, -188(s0)
	sw	t2, 0(t1)
	la	t0,j_glo
	sw	t0, -196(s0)
	lw	t1, -196(s0)
	lw	t0, 0(t1)
	sw	t0, -200(s0)
	la	t0,c_glo
	sw	t0, -204(s0)
	lw	t1, -204(s0)
	lw	t2, -200(s0)
	sw	t2, 0(t1)
	j	.main_bb4

.main_bb4:
	j	.for_iter_bb1

	.size	main, .-main
			 # -- End function
	.globl	_f_abs
	.p2align	1
	.type	_f_abs,@function
_f_abs:
._f_abs_bb:
	addi	sp, sp, -44
	mv	s1,s0
	addi	s0, sp, 44
	mv	t0,s1
	sw	t0, -12(s0)
	sw	a0, -8(s0)
	lw	t0, -8(s0)
	sw	t0, -16(s0)
	li	t0,0
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	slt	t0, t1, t2
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	bne	t1,zero,.if_then_bb
	j	._f_abs_bb2

._f_abs_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0,t1
	lw	t1, -12(s0)
	mv	s0,t1
	addi	sp, sp, 44
	ret

.if_then_bb:
	lw	t0, -8(s0)
	sw	t0, -32(s0)
	lw	t2, -32(s0)
	sw	t2, -4(s0)
	j	._f_abs_bb1

._f_abs_bb2:
	lw	t0, -8(s0)
	sw	t0, -36(s0)
	li	t0,0
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sub	t0, t1, t2
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -4(s0)
	j	._f_abs_bb1

	.size	_f_abs, .-_f_abs
			 # -- End function
	.type	n_glo,@object
	.section	.bss
	.globl	n_glo
n_glo:
	.word	0
	.size	n_glo, 4
	.type	r_glo,@object
	.section	.bss
	.globl	r_glo
r_glo:
	.word	0
	.size	r_glo, 4
	.type	c_glo,@object
	.section	.bss
	.globl	c_glo
c_glo:
	.word	0
	.size	c_glo, 4
	.type	i_glo,@object
	.section	.bss
	.globl	i_glo
i_glo:
	.word	0
	.size	i_glo, 4
	.type	j_glo,@object
	.section	.bss
	.globl	j_glo
j_glo:
	.word	0
	.size	j_glo, 4

