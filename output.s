	.text
	.globl	main
	.p2align		1
	.type	main,@function
main:
.main_bb0:
	addi	sp, sp, -28
	mv	s1, s0
	addi	s0, sp, 28
	mv	t0, s1
	sw	t0, -12(s0)
	li	a0, 2
	mv	t0, ra
	sw	t0, -16(s0)
	call	_f_abs0
	lw	t1, -16(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -20(s0)
	lw	t2, -20(s0)
	sw	t2, -8(s0)
	li	t0, 0
	sw	t0, -24(s0)
	lw	t2, -24(s0)
	sw	t2, -4(s0)
	j	.main_bb1

.main_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0, t1
	lw	t1, -12(s0)
	mv	s0, t1
	addi	sp, sp, 28
	ret

	.size	main, .-main
			 # -- End function
	.globl	_f_abs0
	.p2align		1
	.type	_f_abs0,@function
_f_abs0:
._f_abs0_bb0:
	addi	sp, sp, -48
	mv	s1, s0
	addi	s0, sp, 48
	mv	t0, s1
	sw	t0, -12(s0)
	sw	a0, -8(s0)
	lw	t0, -8(s0)
	sw	t0, -16(s0)
	li	t0, 0
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	slt	t0, t1, t2
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	bne	t1, zero, .if_then_bb0
	j	.if_else_bb0

._f_abs0_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0, t1
	lw	t1, -12(s0)
	mv	s0, t1
	addi	sp, sp, 48
	ret

.if_then_bb0:
	lw	t0, -8(s0)
	sw	t0, -32(s0)
	lw	t2, -32(s0)
	sw	t2, -4(s0)
	j	._f_abs0_bb1

._f_abs0_bb2:
	li	t0, 0
	sw	t0, -36(s0)
	lw	t2, -36(s0)
	sw	t2, -4(s0)
	j	._f_abs0_bb1

.if_else_bb0:
	lw	t0, -8(s0)
	sw	t0, -40(s0)
	li	t0, 0
	sw	t0, -44(s0)
	lw	t1, -44(s0)
	lw	t2, -40(s0)
	sub	t0, t1, t2
	sw	t0, -48(s0)
	lw	t2, -48(s0)
	sw	t2, -4(s0)
	j	._f_abs0_bb1

	.size	_f_abs0, .-_f_abs0
			 # -- End function

