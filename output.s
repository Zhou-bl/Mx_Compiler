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
	sw	t0, -8(s0)
	mv	t0, ra
	sw	t0, -12(s0)
	call	_f_getInt0
	lw	t1, -12(s0)
	mv	ra, t1
	mv	t0, a0
	sw	t0, -16(s0)
	la	t0, n_global0
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	sw	t2, 0(t1)
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
	lw	t1, -8(s0)
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
	addi	sp, sp, -44
	mv	s1, s0
	addi	s0, sp, 44
	mv	t0, s1
	sw	t0, -12(s0)
	sw	a0, -8(s0)
	lw	t0, -8(s0)
	sw	t0, -16(s0)
	li	t0, 0
	sw	t0, -20(s0)
	lw	t1, -20(s0)
	lw	t2, -16(s0)
	slt	t0, t1, t1
	sw	t0, -24(s0)
	lw	t1, -24(s0)
	bne	t1, zero, .if_then_bb0
	j	._f_abs0_bb2

._f_abs0_bb1:
	lw	t0, -4(s0)
	sw	t0, -28(s0)
	lw	t1, -28(s0)
	mv	a0, t1
	lw	t1, -12(s0)
	mv	s0, t1
	addi	sp, sp, 44
	ret

.if_then_bb0:
	lw	t0, -8(s0)
	sw	t0, -32(s0)
	lw	t2, -32(s0)
	sw	t2, -4(s0)
	j	._f_abs0_bb1

._f_abs0_bb2:
	lw	t0, -8(s0)
	sw	t0, -36(s0)
	li	t0, 0
	sw	t0, -40(s0)
	lw	t1, -40(s0)
	lw	t2, -36(s0)
	sub	t0, t1, t1
	sw	t0, -44(s0)
	lw	t2, -44(s0)
	sw	t2, -4(s0)
	j	._f_abs0_bb1

	.size	_f_abs0, .-_f_abs0
			 # -- End function
	.type	n_global0,@object
	.section	.bss
	.globl	n_global0
n_global0:
	.word	0
	.size	n_global0, 4
	.type	r_global0,@object
	.section	.bss
	.globl	r_global0
r_global0:
	.word	0
	.size	r_global0, 4
	.type	c_global0,@object
	.section	.bss
	.globl	c_global0
c_global0:
	.word	0
	.size	c_global0, 4
	.type	i_global0,@object
	.section	.bss
	.globl	i_global0
i_global0:
	.word	0
	.size	i_global0, 4
	.type	j_global0,@object
	.section	.bss
	.globl	j_global0
j_global0:
	.word	0
	.size	j_global0, 4

